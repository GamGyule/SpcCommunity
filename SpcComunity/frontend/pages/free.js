import axios from 'axios'
import { GetServerSideProps } from 'next';
import Layout from '../components/public/Layout';
import { useStore } from '../store/store.js'
import ListComponent from '../components/common/ListBoardComponent.js'

function FreeBoard({ data }) {
  return (
    <Layout>
      <div className='center-container'>
        <div className='center-child'>
          <ListComponent board="자유 게시판" data={data}></ListComponent>
        </div>
      </div>
    </Layout>
  )
}

export const getServerSideProps = async (context) => {
  let data = [];
  await axios.get('http://127.0.0.1:9999/api/board/free').then(function (e) {
    data = e.data;
  });



  return { props: { data: data } }
}



export default FreeBoard;