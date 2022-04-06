import axios from 'axios'
import Head from 'next/head'
import Image from 'next/image'
import Layout from '../components/public/Layout';
import { useStore } from '../store/store.js'
import ListComponent from '../components/common/ListBoardComponent.js'


const BoardList = () => (
  <Layout>
    <h2>자유 게시판</h2>
    <ListComponent></ListComponent>
  </Layout>
);

export default BoardList;