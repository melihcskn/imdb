import React, { useEffect, useRef, useState } from 'react'
import {
  GoogleLoginButton,
  FacebookLoginButton,
  AppleLoginButton,
} from 'react-social-login-buttons'
import 'bootstrap/dist/css/bootstrap.min.css'
import { Button, Form, FormFeedback, FormGroup, Input, Label } from 'reactstrap'
import { useUserContext } from '@/contexts/UserContext'
import styled from 'styled-components'
import axios from 'axios'
import styles from '@/pages/page.module.css'

const FormItem = styled.p`
  margin-top: 1rem;
`

const testEmail = (emailToTest) => {
  const emailRegex = /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$/i
  if (emailRegex.test(emailToTest)) {
    return true
  } else {
    return false
  }
}

export default function SignIn() {
  const [userName, setUserName] = useState('')
  const [password, setPassword] = useState('')
  const [render, setRender] = useState(false)

  const isValid = useRef(true)

  const { dispatch } = useUserContext()

  const loginUrl = 'http://localhost:8080/api/users/login'
  const registerUrl = 'http://localhost:8080/api/users/register'

  const handleGoogleLogin = async () => {
    //Add google login
  }

  const handleFacebookLogin = async () => {
    //Add facebook login
  }

  useEffect(() => {
    document.body.style.backgroundColor = 'gray'
  }, [])

  const handleUserNameInput = (e) => {
    setUserName(e.target.value)
    isValid.current = true
  }

  const handlePassword = (e) => {
    setPassword(e.target.value)
    isValid.current = true
  }

  const handleLogIn = async (e) => {
    if (testEmail(userName)) {
      isValid.current = true
      try {
        const response = await axios.post(loginUrl, {
          email: userName,
          password: password,
        })
        dispatch({ type: 'SIGN_IN', payload: response.data.token })
      } catch (error) {
        alert(error.response.data.message)
      }
    } else {
      isValid.current = false
      setRender(!render)
    }
  }

  const handleRegister = async (e) => {
    if (testEmail(userName)) {
      isValid.current = true
      try {
        const response = await axios.post(registerUrl, {
          email: userName,
          password: password,
        })
        dispatch({ type: 'SIGN_IN', payload: response.data.token })
      } catch (error) {
        alert(error.response.data.message)
        console.log(error)
      }
    }
  }

  return (
    <div className={styles.logIn}>
      <div className={styles.login__content}>
        <Form className={styles.login__form}>
          <FormGroup>
            <FormItem htmlFor="email">Email</FormItem>
            <Input
              id="loginEmail"
              name="email"
              placeholder="test@mail.com"
              type="email"
              onChange={handleUserNameInput}
              value={userName}
              invalid={!isValid.current}
            />
            <FormFeedback>Please enter a valid email adress</FormFeedback>
            <FormItem htmlFor="password">Password</FormItem>
            <Input
              id="loginPassword"
              name="password"
              placeholder="password"
              type="password"
              onChange={handlePassword}
              value={password}
            />
          </FormGroup>
          <Button
            className="btn"
            style={{ width: '100%', marginTop: '0.5rem' }}
            onClick={handleLogIn}
          >
            Log In
          </Button>
          <Button
            className="btn"
            style={{ width: '100%', marginTop: '0.5rem' }}
            onClick={handleRegister}
          >
            Register
          </Button>
          <h5
            style={{
              textAlign: 'center',
              marginTop: '2.5rem',
              marginBottom: '2.5rem',
            }}
          >
            OR
          </h5>
          <GoogleLoginButton className="mb-2" />
          <FacebookLoginButton className="mb-2" />
          <AppleLoginButton className="mb-2" />
        </Form>
      </div>
    </div>
  )
}
