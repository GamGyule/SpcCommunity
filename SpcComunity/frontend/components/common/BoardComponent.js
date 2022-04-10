import axios from 'axios'
import { GetServerSideProps } from 'next';
import { useRouter } from 'next/router';
import Layout from '../public/Layout'

import Styles from '../../styles/Board.module.scss'



function Board({ board, children }) {
    console.log(board);
    return (
        <Layout>
            <div className='center-container'>
                <div className='center-child'>
                    <div className={Styles.BoardTitle}><h2>{board.title}</h2><div className={Styles.RegBox}><div className={Styles.Reg}>{board.reg}</div><div className={Styles.RegDate}>{board.regDate}</div></div></div>
                    <div>
                        <div className={Styles.BoardContents}>
                            <div className={Styles.ContentArea}>{board.contents}</div>
                            <div className={Styles.UpDownShare}>
                                <div className={Styles.Up}></div>
                                <span>0</span>
                                <div className={Styles.Down}></div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
            {children}
        </Layout>

    )
}
export default Board;