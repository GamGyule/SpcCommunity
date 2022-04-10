import axios from 'axios';
import { useEffect } from 'react';
import Styles from '../../styles/MainLately.module.scss'
import Link from 'next/link';



function MainListReturn(props) {

    let list = props.data;
    let board = props.board;

    let url;
    switch (board) {
        case "자유게시판":
            url = "free";
            break;
        case "유머게시판":
            url = "humor";
            break;
    }

    if (list.length < 1) {
        console.log("No Data");
    }

    return (
        list.map(
            board =>
                <li key={board.idx}>
                    <Link href={'/' + url + '/' + board.idx}><div><div>{board.title}</div><div>[10]</div><div>[?]</div></div></Link></li >
        )
    )
}

const ListBoardComponent = (props) => (
    < div >
        <h2>{props.board}</h2>

        <ul className={Styles.TableStyle}>
            {MainListReturn(props)}
        </ul>

    </div >
)
export default ListBoardComponent;