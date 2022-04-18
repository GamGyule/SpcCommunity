import axios from 'axios'
import Head from 'next/head'
import Image from 'next/image'
import Layout from '../components/public/Layout';
import { useStore } from '../store/store.js'
import ListComponent from '../components/common/ListBoardComponent.js'
import Link from 'next/link';
import PagingComponent from '../components/common/PagingComponent';

const HumorBoard = ({ data, page }) => (
    <Layout>
        <div className='center-container'>
            <div className='center-child'>
                <ListComponent board="유머 게시판" data={data}></ListComponent>
                <PagingComponent data={data} page={page} board='humor'></PagingComponent>
            </div>
        </div>
    </Layout>
);

export const getServerSideProps = async ({ query: { page } }) => {
    if (page == null) {
        page = 1;
    }
    let data = [];
    await axios.get('http://127.0.0.1:9999/api/board/humor?page=' + page).then(function (e) {
        data = e.data;
    });



    return { props: { data: data, page: page } }
}

export default HumorBoard;