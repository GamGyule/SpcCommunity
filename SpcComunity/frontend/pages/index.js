import Layout from '../components/public/Layout'
import { useStore } from '../store/store.js'
import Styles from '../styles/Home.module.scss'
import MainLatelyComponent from '../components/common/MainLatelyComponent'
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
    console.log(e.data)
    humorData = e.data;
  });



  return { props: { freeData: freeData, humorData: humorData } }
}

export default function Home({ freeData, humorData }) {
  return (
    <Layout>
      <div className='center-container'>
        <div className={Styles.MainContainer}>
          <div className='center-child'>
            <div className={Styles.MainContent}>
              <div className={Styles.MainBanner}>
              </div>
              <div className={Styles.LatelyLayout}>
                <MainLatelyComponent boardName="자유게시판" board={freeData}></MainLatelyComponent>
                <MainLatelyComponent boardName="유머게시판" board={humorData}></MainLatelyComponent>
              </div>
            </div>
          </div>
        </div>
      </div>
    </Layout>

  )
}
