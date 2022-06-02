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
                    <h2 className="latest-title">BEST 게시글 혹은 순위</h2>
                </div>
                <ul>
                    <li><a className={Styles.LatestSubTitle}>title test</a></li>
                </ul>
            </div>
        </div>     
    )
}
export default SidePanel;