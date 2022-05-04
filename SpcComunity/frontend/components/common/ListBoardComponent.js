import axios from 'axios';
import { useStore } from '../../store/store';
import {Container, Row, Col} from 'react-bootstrap'
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
                <Col xs={12} key={board.idx} className={Styles.BoardListItem}>
                    {/* 글번호
                    <div>
                        탭 {borard.idx}
                    </div> 
                    */}
                    <h5 className={Styles.Title}> 
                        <Link href={url + "/" + board.idx}><div>{board.title}[{board.commentCnt}]</div></Link> 
                    </h5>
                    <div className={Styles.BoardSubInfo}>
                        <small> {board.writer} </small> |
                        <small> {showDate} </small> |
                        <small> 추천 {board.thumbsUp - board.thumbsDown} </small> |
                        <small> 조회수 {board.viewPoint} </small> 
                    </div>                        
                </Col>  
            )
        })
    )
}

const ListBoardComponent = (props) => (
    <Container>
        < div className={Styles.BoardArea}>
            <h2>{props.board}</h2>
            <Row>
                <div>
                    {
                        BoardReturn(props)
                    }
                </div>
            </Row>
        </div >
    </Container>
)
export default ListBoardComponent;