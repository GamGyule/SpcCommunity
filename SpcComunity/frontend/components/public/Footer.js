import Image from 'next/image'
import Logo from '../../public/logo.png'
import {Container, Row, Col} from 'react-bootstrap'
import Styles from '../../styles/Footer.module.scss'

const Footer = () => {
    return (
        <Container fluid>
            <Row className={`${Styles.FooterBox} mt-4`}>
                <Col xs={12} className={`${Styles.FooterBar} d-flex align-items-center justify-content-between`}>
                    <Image src={Logo} alt="logo"></Image>
                    <div>Footer 영역</div>
                </Col>
            </Row>
        </Container>
    );
};

export default Footer;