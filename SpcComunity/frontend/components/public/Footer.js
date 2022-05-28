import Image from 'next/image'
import Link from 'next/link'
import Logo from '../../public/logo.svg'
import {Container, Row, Col, Stack} from 'react-bootstrap'
import Styles from '../../styles/Footer.module.scss'
import IconDiscord from '../../public/icons/icon-discord.svg'
import IonPP from '../../public/icons/icon-pp.svg'
import IconTwitter from '../../public/icons/icon-twitter.svg'
import IconTop from '../../public/icons/icon-btn-top.svg'

const Footer = () => {
    return (
        <Container fluid className={`${Styles.FooterWrap} mt-5`}>
            <Row className={`${Styles.FooterBox} p-3`}>
                <Col xs={12} className={`${Styles.FooterBar} d-flex align-items-center justify-content-between`}>
                    <div className="d-flex flex-column align-items-start">
                        <Image src={Logo} alt="logo"></Image>
                        <p className="mt-1 mb-0 small text-white">Copyright © POOPLELA All right reserved..</p> 
                    </div>
                    <Stack direction="horizontal" gap={3} className="d-flex align-items-center">
                        <Link href="/"><Image src={IconDiscord} alt="Discord"></Image></Link>
                        <Link href="/"><Image src={IonPP} alt="PP"></Image></Link>
                        <Link href="/"><Image src={IconTwitter} alt="Twitter"></Image></Link>
                        <Link href="/"><Image src={IconTop} alt="Top"></Image></Link>
                    </Stack>
                </Col>
            </Row>
        </Container>
    );
};

export default Footer;