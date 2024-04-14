import { jwtDecode } from 'jwt-decode'

const userToken = 'userToken'

//Check if token is valid
const checkToken = (token) => {
  const decodedToken = jwtDecode(token, { payload: true })
  if (decodedToken.sub !== null) {
    return { result: { decodedToken: decodedToken, isValid: true } }
  } else {
    return { result: { isvalid: false } }
  }
}

//Save user to local
const saveUser = (token) => {
  const { result } = checkToken(token)
  if (result.isValid) {
    localStorage.setItem(userToken, JSON.stringify(token))
    return {
      ...initial,
      user: { userName: result.decodedToken.sub },
      isSigned: true,
    }
  } else {
    return { initial }
  }
}

export { checkToken, saveUser }
