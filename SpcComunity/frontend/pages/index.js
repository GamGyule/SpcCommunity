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

export default function Home() {
  return (
    <Layout>
      <div className='center-container'>
        <div className='center-child'>
          <br></br>
          <KaikasLogin></KaikasLogin>
        </div>
      </div>
    </Layout>

  )
}
