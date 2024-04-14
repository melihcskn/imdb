const URLs = [
  'http://localhost:8080/api/movies/getMovieStartingWith?searchParam=',
  'http://localhost:8080/api/movies/getMovieContains?searchParam=',
  'http://localhost:8080/api/actors/getByNameStartingWith?searchParam=',
  'http://localhost:8080/api/actors/getByNameContains?searchParam=',
]

const siteLogo = '/images/IMDB_Logo.png'
const noPictureLogo = '/images/no_picture_available.png'

const filterOptions = [
  { name: 'All', id: 0 },
  { name: 'Titles', id: 1 },
  { name: 'TV Episodes', id: 2 },
  { name: 'Celebs', id: 3 },
]

const userOptions = [
  { name: 'Watchlist', id: 0, Link: '' },
  { name: 'User Settings', id: 1, Link: '' },
  { name: 'LogOut', id: 2, Link: '/SignOut' },
]

export { URLs, siteLogo, filterOptions, noPictureLogo, userOptions }
