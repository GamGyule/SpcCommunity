import axios from 'axios'
import { GetServerSideProps } from 'next';
import WriteComponent from '../components/common/WriteComponent';
import Layout from '../components/public/Layout';
import { useStore } from '../store/store.js'

function Write() {
  return (
    <Layout>
      <div className='center-container'>
        <div className='center-child'>
            <WriteComponent>

            </WriteComponent>
        </div>
      </div>
    </Layout>
  )
}


export default Write;