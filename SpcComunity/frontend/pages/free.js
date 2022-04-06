import axios from 'axios'
import Head from 'next/head'
import Image from 'next/image'
import Layout from '../components/public/Layout';
import { useStore } from '../store/store.js'
import ListComponent from '../components/common/ListBoardComponent.js'


const BoardList = () => (
  <Layout>
    <div className='center-container'>
      <div className='center-child'>
        <ListComponent board="d"></ListComponent>
      </div>
    </div>
  </Layout>
);

export default BoardList;