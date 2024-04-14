import React from 'react'
import Carousel from 'react-bootstrap/Carousel'
import 'bootstrap/dist/css/bootstrap.css'
import { CarouselCaption } from 'react-bootstrap'
import styles from './home.module.css'

export default function HomeSlider() {
  const a1 = '/images/avengers.jpg'
  const a2 = '/images/avengers2.jpg'

  return (
    <div className={styles.home}>
      <Carousel className={styles.carousel} indicators={false} interval={null}>
        <Carousel.Item>
          <img src={a1} />
          <CarouselCaption>
            <h3></h3>
            <p></p>
          </CarouselCaption>
        </Carousel.Item>
        <Carousel.Item>
          <img src={a2} />
          <CarouselCaption>
            <h3></h3>
            <p></p>
          </CarouselCaption>
        </Carousel.Item>
      </Carousel>
    </div>
  )
}
