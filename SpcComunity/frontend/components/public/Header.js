import Link from 'next/link'
import Head from 'next/head'
import Image from 'next/image'
import Styles from '../../styles/Header.module.scss'
import Logo from '../../public/logo.png'
import NaverLoginComponent from '../common/NaverLoginComponent';
import { useStore } from '../../store/store'
import { useEffect } from 'react'

function UserInfo() {
    const userData = useStore(state => state.userInfo);
    if (Object.keys(userData).length < 1) {
        return (
            <NaverLoginComponent></NaverLoginComponent>
        )
    } else {
        return (
            <div>{userData.nickname}</div>
        )
    }
}

const Header = () => {
    useEffect(() => {
        if (localStorage.getItem("userData") !== null) {
            const userData = JSON.parse(localStorage.getItem("userData"));
            useStore.setState(state => ({ userInfo: userData }))
        }
    }, [])
    return (
        <div>
            <Head><script src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.2.js"></script></Head>
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
                    <ul className={Styles.NavMenu}>
                        <div>{UserInfo()}</div>
                    </ul>
                    <div className={Styles.MobileMenu}>
                        asd
                    </div>
                </div>
            </div>
        </div>
    );
};

export default Header;