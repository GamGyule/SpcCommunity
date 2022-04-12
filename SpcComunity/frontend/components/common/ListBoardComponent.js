import axios from 'axios';
import { useEffect } from 'react';
import { useStore } from '../../store/board.js'
import Styles from '../../styles/ListStyle.module.scss'
import Link from 'next/link';



function BoardReturn(props) {

    let list = props.data;
    let url;
    switch (props.board) {
        case "자유 게시판":
            url = "/free";
            break;
        case "유머 게시판":
            url = "/humor";
            break;
    }

    return (
        list.map(
            board =>
                <tr key={board.idx}>
                    <td> 탭{board.idx} </td>
                    <td> <Link href={url + "/" + board.idx}>{board.title}</Link></td>
                    <td> {board.reg} </td>
                    <td> {board.regDate} </td>
                    <td> {board.thumbsUp - board.thumbsDown} </td>
                    <td> {board.viewPoint} </td>
                </tr>
        )
    )
}

const ListBoardComponent = (props) => (
    < div className={Styles.BoardArea}>
        <h2>{props.board}</h2>
        <div>
            <table className={Styles.TableStyle}>
                <thead>
                    <tr>
                        <th>탭</th>
                        <th>제목 </th>
                        <th>작성자 </th>
                        <th>작성일 </th>
                        <th>추천 </th>
                        <th>조회수</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        BoardReturn(props)
                    }
                </tbody>
            </table>
        </div>
    </div >
)
export default ListBoardComponent;