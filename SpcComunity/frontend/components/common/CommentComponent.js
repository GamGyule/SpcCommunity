import axios from 'axios'
import { GetServerSideProps } from 'next';
import { useRouter } from 'next/router';
import Layout from '../public/Layout'



function Comment({ comment }) {
    return (
        <div className='center-container'>
            <div className='center-child'>
                대애애앳그으으을
            </div>
        </div>


    )
}
export default Comment;