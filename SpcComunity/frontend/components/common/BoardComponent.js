import axios from 'axios'
import { GetServerSideProps } from 'next';
import { useRouter } from 'next/router';
import Layout from '../public/Layout'

import Styles from '../../styles/Board.module.scss'



function Board({ board, comment }) {
    return (
        <Layout>
            <div className='center-container'>
                <div className='center-child'>
                    <div>
                        <div className={Styles.BoardTitle}><h2>{board.title}</h2><div className={Styles.RegBox}><div className={Styles.Reg}>{board.writer}</div><div className={Styles.RegDate}>{board.regDate}</div></div></div>
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
                    <hr></hr>
                    <ul className={Styles.CommentArea}>
                        {
                            comment.map(reply => {
                                return (
                                    <li key={reply.idx}>
                                        <div className={Styles.CommentMeta}><div><div>{reply.commentWriter}</div><div>{reply.regDate}</div></div><div>댓글</div></div>
                                        <div className={Styles.CommentBody}>{reply.content}</div>
                                    </li>
                                )
                            })
                        }
                    </ul>
                </div>
            </div>
        </Layout>

    )
}
export default Board;