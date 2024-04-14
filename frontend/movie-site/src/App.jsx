import {
  BrowserRouter as Router,
  Routes,
  Route,
  Navigate,
} from 'react-router-dom'
import { Header } from './layouts/index'
import { Home, Error, Title, Actor, SignIn, SignOut } from './pages/index'
import { useUserContext } from './contexts/UserContext'

export default function App() {
  const { state } = useUserContext()
  const isSigned = state.isSigned

  return (
    <div>
      <Router>
        <Header />
        <Routes>
          <Route exact path="/" element={<Home />} />
          <Route path="movie/:id" element={<Title />} />
          <Route path="actor/:id" element={<Actor />} />
          <Route
            path="signin/"
            element={isSigned ? <Navigate to="/" /> : <SignIn />}
          />
          <Route path="/*" element={<Error />} />
          <Route
            path="signOut/"
            element={isSigned ? <SignOut /> : <Navigate to="/" />}
          ></Route>
        </Routes>
      </Router>
    </div>
  )
}
