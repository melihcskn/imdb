import React, { useEffect } from 'react'
import { useUserContext } from '@/contexts/UserContext'
import { useNavigate } from 'react-router-dom'

export default function SignOut() {
  const { dispatch } = useUserContext()
  const navigate = useNavigate()

  useEffect(() => {
    dispatch({ type: 'SIGN_OUT' })
    navigate('/')
  }, [])
  return <div></div>
}
