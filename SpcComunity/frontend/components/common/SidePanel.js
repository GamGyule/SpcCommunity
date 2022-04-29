import axios from 'axios'
import { GetServerSideProps } from 'next';
import { useRouter } from 'next/router';
import Layout from '../public/Layout'

import Styles from '../../styles/SidePanel.module.scss'



function SidePanel({ board, comment }) {
    return (    
        <div className={Styles.test}>
            <div>
                <div>
                    <h5>BEST 게시글 혹은 순위</h5> <a>더보기</a>
                </div>
                <ul>
                    <li><a>title</a></li>
                </ul>
            </div>
        </div>     
    )
}
export default SidePanel;