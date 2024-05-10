import { useSearchResultContext } from '@/contexts/SearchResultContext'
import { getData } from '@/contexts/actions/searchResultActions'
import { useEffect } from 'react'
import { useParams } from 'react-router-dom'
import Spinner from 'react-bootstrap/Spinner'
import styles from './page.module.css'
import { TitleHeader, TitleScore, TitlePoster, TitleVideo } from '@/components'

const runtimeToHours = (runtime) => {
  const hours = Math.floor(runtime / 60)
  const minutes = runtime % 60
  return ' ' + hours + 'h ' + minutes + 'm'
}

const types = ['imdbRating', 'userRating', 'popularity']

export default function Title() {
  const { id } = useParams()
  const { state: searchResultState, dispatch: searchResultDispatch } =
    useSearchResultContext()
  let isLoading = searchResultState.isLoading
  let movie = null

  if (Object.keys(searchResultState.data).length !== 0) {
    movie = searchResultState.data
  }

  if (searchResultState)
    useEffect(() => {
      getData(searchResultDispatch, id, 'movie')
      document.body.style.backgroundColor = '#1F1F1F'
    }, [id])

  return (
    <div
      className={` ${styles.page__container}  ${styles['page__container--left']} ${styles['page__container--right']}`}
    >
      {!isLoading ? (
        <>
          <div className={styles.data__header}>
            <TitleHeader movie={movie} />
            <div className={styles['data__header--right']}>
              {types.map((type, index) => {
                return <TitleScore type={type} key={index} />
              })}
            </div>
          </div>
          <div style={{ maxHeight: '25rem', display: 'flex' }}>
            <TitlePoster poster={movie?.moviePoster} />
            <TitleVideo trailer={movie?.movieTrailer} />
          </div>
        </>
      ) : (
        <div
          style={{
            display: 'flex',
            justifyContent: 'center',
          }}
        >
          <Spinner
            className={styles.spinner}
            animation="border"
            role="status"
            variant="dark"
          >
            <span className="visually-hidden">Loading...</span>
          </Spinner>
        </div>
      )}
    </div>
  )
}
