import 'bootstrap/dist/css/bootstrap.min.css';
import '../styles/globals.scss'

// 사용할 컴포넌트가 있다면 아래와 같은 식으로 컴포넌트 붙여주면 <Button>BUTTON</Button> 이런코드 사용가능
// import { 사용할 컴포넌트명 } from 'react-bootstrap';

function MyApp({ Component, pageProps }) {
  return <Component {...pageProps} />
}

export default MyApp
