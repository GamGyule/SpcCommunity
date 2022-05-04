import Link from 'next/link'
import Head from 'next/head'
import Image from 'next/image'
import {Container, Row, Col, Nav, Navbar, NavDropdown, Form, FormControl, Button, Offcanvas} from 'react-bootstrap'
import Styles from '../../styles/Header.module.scss'
import Logo from '../../public/logo.png'
// import NaverLoginComponent from '../common/NaverLoginComponent';
import { useStore } from '../../store/store'
import { useEffect } from 'react'

function UserInfo() {
    const userData = useStore(state => state.userInfo);
    if (Object.keys(userData).length < 1) {
        return (
            // <NaverLoginComponent></NaverLoginComponent>
            <div></div>
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
            {/* <Head><script src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.2.js"></script></Head> */}
            {/* <div className='container' style={{border: '1px solid red'}}>
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
            </div> */}
            
            <>
            <Navbar bg="light" expand="1" className="mb-3">
                <Container fluid>
                    <Navbar.Brand href="/" className="d-flex align-items-center justify-content-center">
                        <Image className={Styles.Logo} src={Logo} alt="Logo"></Image>
                        poople
                    </Navbar.Brand>
                    <Navbar.Toggle aria-controls="offcanvasNavbar-expand-md" />
                    <Navbar.Offcanvas
                        id="offcanvasNavbar-expand-md"
                        aria-labelledby="offcanvasNavbarLabel-expand-md"
                        placement="end"
                    >
                        <Offcanvas.Header closeButton>
                            <Offcanvas.Title id="offcanvasNavbarLabel-expand-md">
                                Offcanvas
                            </Offcanvas.Title>
                        </Offcanvas.Header>
                        <Offcanvas.Body>
                            <Nav className="justify-content-end flex-grow-1 pe-3">
                                <Nav.Link href="/free">자유 게시판</Nav.Link>
                                <Nav.Link href="/humor">유머 게시판</Nav.Link>
                                <NavDropdown
                                    title="Dropdown"
                                    id="offcanvasNavbarDropdown-expand-md"
                                >
                                    <NavDropdown.Item href="#action3">Action</NavDropdown.Item>
                                    <NavDropdown.Item href="#action4">
                                    Another action
                                    </NavDropdown.Item>
                                    <NavDropdown.Divider />
                                    <NavDropdown.Item href="#action5">
                                    Something else here
                                    </NavDropdown.Item>
                                </NavDropdown>
                            </Nav>
                            <Form className="d-flex">
                                <FormControl
                                    type="search"
                                    placeholder="Search"
                                    className="me-2"
                                    aria-label="Search"
                                />
                                <Button variant="outline-success">Search</Button>
                            </Form>
                        </Offcanvas.Body>
                    </Navbar.Offcanvas>
                </Container>
            </Navbar>
            </>
        </div>
    );
    
};

export default Header;