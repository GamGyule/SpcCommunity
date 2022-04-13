import axios from 'axios'
import Head from 'next/head'
import Image from 'next/image'
import Layout from '../components/public/Layout';
import { useStore } from '../store/store.js'
import ListComponent from '../components/common/ListBoardComponent.js'
import Link from 'next/link';
import Styles from '../styles/Paging.module.scss'

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
                result.push(<Link key={i} href={'/humor?page=' + i}><span>{i}</span></Link>);
            } else {
                result.push(<Link key={i} href={'/humor?page=' + i}><span>{i}</span></Link>);
            }
        }
        return result;
    }

    return rendering()

}
const HumorBoard = ({ data }) => (
    <Layout>
        <div className='center-container'>
            <div className='center-child'>
                <ListComponent board="유머 게시판" data={data}></ListComponent>
                <div className={Styles.PagingArea}>
                    {BoardPaging(data)}
                </div>
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



    return { props: { data: data } }
}

export default HumorBoard;