import Link from 'next/link'
import Image from 'next/image'
import Styles from '../../styles/Header.module.scss'
import Logo from '../../public/logo.png'
const Header = () => {
    return (
        <div className={Styles.NavBarBox}>
            <div className={Styles.NavBar}>
                <div className={Styles.NavBarLogo}>
                    <Image src={Logo}></Image>
                    <Link href="/">Poopla</Link>
                </div>
                <ul className={Styles.NavMenu}>
                    <li><Link href="/free">자유 게시판</Link></li>
                    <li>2</li>
                    <li>3</li>
                    <li>4</li>
                </ul>
            </div>
        </div>
    );
};

export default Header;