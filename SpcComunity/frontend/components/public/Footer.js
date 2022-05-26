import Image from 'next/image'
import Link from 'next/link'
import Logo from '../../public/logo.svg'
import {Container, Row, Col} from 'react-bootstrap'
import Styles from '../../styles/Footer.module.scss'
import IconDiscord from '../../public/icons/icon-discord.svg'
import IonPP from '../../public/icons/icon-pp.svg'
import IconTwitter from '../../public/icons/icon-twitter.svg'
import IconTop from '../../public/icons/icon-btn-top.svg'

const Footer = () => {
    return (
        <Container fluid className={`${Styles.FooterWrap}`}>
            <Row className={`${Styles.FooterBox} mt-4`}>
                <Col xs={12} className={`${Styles.FooterBar} d-flex align-items-center justify-content-between`}>
                    <div>
                        <Image src={Logo} alt="logo"></Image>
                        Copyright © POOPLELA All right reserved.. 
                    </div>
                    <div className="d-flex align-items-center">
                        <Link href="/"><Image src={IconDiscord} alt="Discord"></Image></Link>
                        <Link href="/"><Image src={IonPP} alt="PP"></Image></Link>
                        <Link href="/"><Image src={IconTwitter} alt="Twitter"></Image></Link>
                        <Link href="/"><Image src={IconTop} alt="Top"></Image></Link>
                    </div>
                </Col>
            </Row>
        </Container>
    );
};

export default Footer;