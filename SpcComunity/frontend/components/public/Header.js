import Link from 'next/link'
import Image from 'next/image'
import Styles from '../../styles/Header.module.scss'
import Logo from '../../public/logo.png'
const Header = () => {
    return (
        <div className={Styles.NavBarBox}>
            <div className={Styles.NavToolbar}>
                <ul>
                    <li>왼쪽에 넣을거</li>
                </ul>
                <ul>
                    <li>로그인</li>
                </ul>
            </div>
            <div className={Styles.NavBar}>
                <div className={Styles.NavBarLogo}>
                    <Image src={Logo}></Image>
                    <Link href="/">Poopla</Link>
                </div>
                <ul className={Styles.NavMenu}>
                    <li><Link href="/free">자유 게시판</Link></li>
                    <li><Link href="/humor">유머 게시판</Link></li>
                </ul>
            </div>
        </div>
    );
};

export default Header;