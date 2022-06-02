import Layout from '../components/public/Layout'
import {Container, Row, Col} from 'react-bootstrap'
import { useStore } from '../store/store.js'
import Styles from '../styles/Home.module.scss'
import MainLatelyComponent from '../components/common/MainLatelyComponent'
import SidePanel from '../components/common/SidePanel'
import axios from 'axios'

async function testKaikasLogin() {
  const accounts = await klaytn.enable();
  useStore.setState(state => ({ walletAddress: accounts[0] }));
}

function KaikasLogin() {
  const account = useStore(state => state.walletAddress);

  return (
    <div>
      <span>{account}</span>
      <input type="button" value="로그인 테스트" onClick={testKaikasLogin} />
    </div>
  )
}

export const getServerSideProps = async (context) => {
  let freeData = [];
  let humorData = [];
  await axios.get('http://127.0.0.1:9999/api/board/free/lately').then(function (e) {
    freeData = e.data;
  });

  await axios.get('http://127.0.0.1:9999/api/board/humor/lately').then(function (e) {
    humorData = e.data;
  });



  return { props: { freeData: freeData, humorData: humorData } }
}
export default function Home({ freeData, humorData }) {
  return (
    <Layout>
      <Container>
        <Row>
          <Col xs={12} className="header-sub py-5">
            <div className="header-sub-text">COMMUNITY</div>
          </Col>
        </Row>
      </Container>
      <Container>
        <Row>
          <Col className={Styles.MainContainer} xs={12} lg={8}>
            <div className="beige-bg radius-right">
              <div className={Styles.MainContent}>
                {/* <div className={Styles.MainBanner}>
                </div> */}
                <Row className={`${Styles.LatelyLayout}`}>
                  <Col xs={12} className="mb-5">
                    <MainLatelyComponent boardName="자유 게시판 BEST" board={freeData}></MainLatelyComponent>
                  </Col>
                  <Col xs={12}>
                    <MainLatelyComponent boardName="유머게시판 BEST" board={humorData}></MainLatelyComponent>
                  </Col>
                </Row>
              </div>
            </div>
          </Col>

          {/* 사이드 패널 */}
          <Col xs={12} lg={4} className="d-none d-md-block">
            <div className="beige-bg radius-left">
              <SidePanel />
            </div>
          </Col>
        </Row>
      </Container>

    </Layout>

  )
}
