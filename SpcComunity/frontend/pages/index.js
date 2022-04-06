import axios from 'axios'
import Head from 'next/head'
import Image from 'next/image'
import styles from '../styles/Home.module.scss'
import Layout from '../components/public/Layout'
import { useStore } from '../store/store.js'


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


function BackConnect() {
  const backData = useStore(state => state.backData);
  const BackConnectApi = useStore(state => state.BackConnectApi);

  const rendering = () => {
    const result = [];
    for (let i = 0; i < backData.length; i++) {
      result.push(<tr key={i}><td>{backData[0][i].uuid}</td><td>{backData[0][i].id}</td></tr>)
    }
    return result;
  }

  return (
    <div>
      <table>
        <thead>
          <tr>
            <th>UUID</th>
            <th>ID</th>
          </tr>
        </thead>
        <tbody>
          {rendering()}
        </tbody>
      </table>
      <input type="button" value="백엔드 테스트" onClick={BackConnectApi} />
    </div>
  )
}

export default function Home() {
  return (
    <Layout>
      <div className='center-container'>
        <div className='center-child'>
          <br></br>
          <KaikasLogin></KaikasLogin>
          <br></br>
          <BackConnect></BackConnect>
        </div>
      </div>
    </Layout>

  )
}
