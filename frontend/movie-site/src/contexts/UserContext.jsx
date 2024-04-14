import { jwtDecode } from 'jwt-decode'
import { createContext, useContext, useEffect, useReducer } from 'react'
import { saveUser } from './actions/userActions'

const UserContext = createContext('context')
const userToken = 'userToken'
const defaultRoute = 'http://localhost:5173/'

const initial = { user: { userName: '' }, isSigned: false }

const reducer = (state, action) => {
  switch (action.type) {
    case 'CHECK_USER': {
      //Check if any user has signed in
      if (localStorage.getItem(userToken)) {
        const token = JSON.parse(localStorage.getItem(userToken))
        const decodedToken = jwtDecode(token, { payload: true })
        return {
          ...state,
          user: { userName: decodedToken.sub },
          isSigned: true,
        }
      } else {
        return { ...initial }
      }
    }
    case 'SIGN_IN': {
      if (!localStorage.getItem(userToken)) {
        return {
          ...saveUser(action.payload),
        }
      } else {
        window.location.href = defaultRoute
        return { ...state }
      }
    }
    case 'SIGN_OUT': {
      localStorage.removeItem(userToken)
      return { ...initial }
    }
    default: {
      throw new Error()
    }
  }
}

const UserContextProvider = ({ children }) => {
  const [state, dispatch] = useReducer(reducer, initial)

  useEffect(() => {
    dispatch({ type: 'CHECK_USER', payload: { ...state } })
  }, [])

  return (
    <UserContext.Provider value={{ state, dispatch }}>
      {children}
    </UserContext.Provider>
  )
}

export const useUserContext = () => {
  const context = useContext(UserContext)
  if (!context) {
    throw new Error('No UserContext found')
  }
  return context
}

export { UserContext, UserContextProvider }
