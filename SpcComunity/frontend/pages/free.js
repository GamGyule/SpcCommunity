import axios from 'axios'
import { GetServerSideProps } from 'next';
import Layout from '../components/public/Layout';
import { useStore } from '../store/store.js'
import ListComponent from '../components/common/ListBoardComponent.js'

function BoardPaging(data) {
  let currPage = useStore((state) => state.page);
  let boardLength = data.boardCount;
  let boardSlice = 10;

  let indexOfFirst = currPage;
  let indexOfLast = ((currPage + boardSlice) - 1) > boardLength ? boardLength : (currPage + boardSlice) - 1;

  const rendering = () => {
    const result = [];
    for (let i = indexOfFirst; i <= indexOfLast; i++) {
      if (i == currPage) {
        result.push(<a className={Styles.CurrPage} key={i}>{i}</a>);
      } else {
        result.push(<Link key={i} href={url}><span>{i}</span></Link>);
      }
    }
    return result;
  }

  return rendering()

}

function FreeBoard({ data }) {
  return (
    <Layout>
      <div className='center-container'>
        <div className='center-child'>
          <ListComponent board="자유 게시판" data={data}></ListComponent>
          <div>
            {BoardPaging(data)}
          </div>
        </div>
      </div>
    </Layout>
  )
}

export const getServerSideProps = async ({ query: { page } }) => {
  if (page == null) {
    page = 1;
  }
  let data = [];
  await axios.get('http://127.0.0.1:9999/api/board/free?page=' + page).then(function (e) {
    data = e.data;
  });



  return { props: { data: data } }
}



export default FreeBoard;