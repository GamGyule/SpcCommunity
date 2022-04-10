import Link from 'next/link'
import Image from 'next/image'
import Styles from '../../styles/Header.module.scss'
import Logo from '../../public/logo.png'

//https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id={CLIENT_ID}&state={STATE_STRING}&redirect_uri={CALLBACK_URL}
const Header = () => {
    return (
        <div className={Styles.NavBarBox}>
            <div className={Styles.NavBar}>
                <div className={Styles.NavBarLogo}>
                    <Image className={Styles.Logo} src={Logo} alt="Logo"></Image>
                    <Link href="/">Poopla</Link>
                </div>
                <ul className={Styles.NavMenu}>
                    <li><Link href="/free">자유 게시판</Link></li>
                    <li><Link href="/humor">유머 게시판</Link></li>
                </ul>
                <div className={Styles.MobileMenu}>
                    asd
                </div>
            </div>
        </div>
    );
};

export default Header;