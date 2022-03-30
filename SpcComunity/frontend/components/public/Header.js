import Link from 'next/link';

const linkStyle = {
    marginRight: '1rem'
};

const Header = () => {
    return (
        <div>
            <Link href="/"><a style={linkStyle}>홈</a></Link>
            <Link href="/board"><a style={linkStyle}>게시판</a></Link>
        </div>
    );
};

export default Header;