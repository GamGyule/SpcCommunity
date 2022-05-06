import axios from 'axios'
import { GetServerSideProps } from 'next';
import { useRouter } from 'next/router';
import {Container, Row, Col} from 'react-bootstrap'
import Layout from '../public/Layout'

import Styles from '../../styles/Board.module.scss'



function Board({ board, comment }) {
    return (    
        <Layout>
            <Container>
                <div>
                    <div className={`${Styles.BoardTitle} py-3`}>
                        <h2>{board.title}</h2>
                        <div className={Styles.RegBox}>
                            <span className={Styles.Reg}>{board.writer} | </span>
                            <span className={Styles.RegDate}>{board.regDate}</span>
                        </div>
                    </div>
                    <div>
                        <div className={`${Styles.BoardContents} py-3`}>
                            <div className={Styles.ContentArea}>{board.contents}</div>
                            <div className={`${Styles.UpDownShare} d-flex align-items-center justify-content-center mt-5 mb-3`}>
                                <div className={Styles.Up}></div>
                                <span>0</span>
                                <div className={Styles.Down}></div>
                            </div>
                        </div>

                    </div>
                </div>
                <ul className={Styles.CommentArea}>
                    {
                        comment.map(reply => {
                            return (
                                <li key={reply.idx}>
                                    <div className={Styles.CommentMeta}>
                                        <div>
                                            <div>{reply.commentWriter} <small className='small-gray'>{reply.regDate}</small> </div>                                                                                  
                                        </div>                                    
                                        <div>댓글</div>                                    
                                    </div>
                                    <div className={Styles.CommentBody}>{reply.content}</div>
                                </li>
                            )
                        })
                    }
                </ul>
            </Container>
        </Layout>

    )
}
export default Board;