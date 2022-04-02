import Link from 'next/link'
import Image from 'next/image'
import Styles from '../../styles/Header.module.css'

const linkStyle = {
    marginRight: '1rem'
};

const Header = () => {
    return (
        <div>
            <div>
                <div><Image src="/logo.png" alt='logo' width={260} height={110}></Image></div>
            </div>
            <div>
                <ul className={Styles.ul}>
                    <li>
                        <Link href="/"><a style={linkStyle}>홈</a></Link>
                    </li>
                    <li>
                        <Link href="/humor"><a style={linkStyle}>유머</a></Link>
                    </li>
                    <li>
                        <Link href="/free"><a style={linkStyle}>자유</a></Link>
                    </li>
                    <li>
                        <Link href="/prison"><a style={linkStyle}>감옥</a></Link>
                    </li>
                </ul>
            </div>
        </div>
    );
};

export default Header;