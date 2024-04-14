import { useEffect } from 'react'
import HomeSlider from '../components/home/HomeSlider'

export default function Home() {
  useEffect(() => {
    document.body.style.backgroundColor = 'black'
  }, [])
  return (
    <div>
      <HomeSlider></HomeSlider>
    </div>
  )
}
