import axios from 'axios';
import { useEffect } from 'react';
import Container from 'react-bootstrap/Container'
import Row from 'react-bootstrap/Row'
import Col from 'react-bootstrap/Col'
import Styles from '../../styles/MainLately.module.scss'
import Link from 'next/link';



function MainListReturn(boardName, board) {
    let url;
    switch (boardName) {
        case "자유게시판":
            url = "free";
            break;
        case "유머게시판":
            url = "humor";
            break;
    }

    return (

        board.map(
            item =>
                <li key={item.idx}><Link href={'/' + url + '/' + item.idx}><div><div>{item.title}</div><div>[{item.commentCnt}]</div></div></Link></li>
        )
    )
}

const ListBoardComponent = ({ boardName, board, comment }) => (
    < div >
        <h2>{boardName}</h2>
        <ul className={Styles.TableStyle}>
            {MainListReturn(boardName, board, comment)}
        </ul>

    </div >
)
export default ListBoardComponent;