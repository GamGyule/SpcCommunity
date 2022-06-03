import axios from 'axios'
import { GetServerSideProps } from 'next';
import { useRouter } from 'next/router';
import Layout from '../public/Layout'

import Styles from '../../styles/SidePanel.module.scss'



function SidePanel({ board, comment }) {
    return (    
        <div className={Styles.SidePanel}>
            <div className={Styles.SidePanelItem}>          
                <h2 className="latest-title">푸플 인기글</h2>              
                <ul>
                    <li><a className={Styles.SidePanelSubTitle}>title test</a></li>
                </ul>
            </div>
        </div>     
    )
}
export default SidePanel;