import axios from 'axios'
import Head from 'next/head'
import Image from 'next/image'
import Layout from '../components/public/Layout';
import { useStore } from '../store/store.js'
import ListComponent from '../components/common/ListBoardComponent.js'

function LoadList() {
    useEffect(async () => {
        axios.get('/api/board/humor').then(function (e) {
            useStore.setState(state => ({ boardList: e.data }));
        });
    }, [])
}

const HumorBoard = ({ data }) => (
    <Layout>
        <div className='center-container'>
            <div className='center-child'>
                <ListComponent board="유머 게시판" data={data}></ListComponent>
            </div>
        </div>
    </Layout>
);

export const getServerSideProps = async (context) => {
    let data = [];
    await axios.get('http://127.0.0.1:9999/api/board/humor').then(function (e) {
        data = e.data;
    });



    return { props: { data: data } }
}

export default HumorBoard;