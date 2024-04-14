import styles from '@/components/header/header.module.css'
import { MenuToggle, SearchBar, Logo, SignInButton } from '@/components/index'
import { SearchContextProvider } from '@/contexts/SearchContext'

export default function Header() {
  return (
    <div className={styles.header}>
      <Logo />
      <MenuToggle />
      <SearchContextProvider>
        <SearchBar />
      </SearchContextProvider>
      <SignInButton />
    </div>
  )
}
