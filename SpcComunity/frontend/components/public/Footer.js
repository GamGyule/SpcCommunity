import {Container, Row, Col} from 'react-bootstrap'
import Styles from '../../styles/Footer.module.scss'

const Footer = () => {
    return (
        <Container>
            <Row className={Styles.FooterBox}>
                <Col xs={12} className={Styles.FooterBar}>
                    <div>Footer 영역</div>
                </Col>
            </Row>
        </Container>
    );
};

export default Footer;