import React from 'react'
import ReactPlayer from 'react-player'

export default function TitleVideo(props) {
  const { trailer: trailerLink } = props

  return (
    <ReactPlayer
      controls={true}
      height="inherit"
      style={{ paddingLeft: '0.2rem', paddingRight: '0.2rem' }}
      url={trailerLink}
    />
  )
}

export { TitleVideo }
