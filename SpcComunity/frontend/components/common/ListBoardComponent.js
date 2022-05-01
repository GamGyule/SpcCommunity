import axios from 'axios';
import { useStore } from '../../store/store';
import Styles from '../../styles/ListStyle.module.scss'
import Link from 'next/link';


function BoardReturn(props) {

    let list = props.data.board;
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
        list.map(function (board) {
            let regDate = new Date(board.regDate);
            let today = new Date();
            let betweenTime = Math.floor((today.getTime() - regDate.getTime()) / 1000 / 60);
            let betweenTimeHour = Math.floor(betweenTime / 60);
            let betweenTimeDay = Math.floor(betweenTime / 60 / 24);
            let showDate;
            // 방금 전
            if (betweenTime < 1) {
                showDate = "방금 전";
            }
            // 몇 분 전
            else if (betweenTime < 60) {
                showDate = betweenTime + " 분 전";
            } else {
                // 시간 전
                if (betweenTimeHour < 24) {
                    showDate = betweenTimeHour + " 시간 전";
                } else {
                    // 몇 일 전
                    if (betweenTimeDay < 365) {
                        showDate = (board.regDate).substr(0, 10);
                    }
                    // 몇 년 전
                    else {
                        showDate = (board.regDate).substr(0, 10);
                    }
                }
            }

            return (
                <tr key={board.idx}>
                    <td> 탭{board.idx} </td>
                    <td> <Link href={url + "/" + board.idx}><span className={Styles.Title}>{board.title}[{board.commentCnt}]</span></Link></td>
                    <td> {board.writer} </td>
                    <td> {showDate} </td>
                    <td> {board.thumbsUp - board.thumbsDown} </td>
                    <td> {board.viewPoint} </td>
                </tr>
            )
        })
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
                        <th >작성자 </th>
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