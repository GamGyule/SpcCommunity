import axios from 'axios'
import { GetServerSideProps } from 'next';
import Layout from '../components/public/Layout';
import { useStore } from '../store/store.js'
import ListComponent from '../components/common/ListBoardComponent.js'
import PagingComponent from '../components/common/PagingComponent';

function FreeBoard({ data, page }) {
  return (
    <Layout>
      <div className='center-container'>
        <div className='center-child'>
          <ListComponent board="자유 게시판" data={data}></ListComponent>
          <PagingComponent data={data} page={page} board='free'></PagingComponent>
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



  return { props: { data: data, page: page } }
}



export default FreeBoard;