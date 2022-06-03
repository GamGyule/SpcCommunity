import axios from 'axios';
import { useEffect } from 'react';
import Container from 'react-bootstrap/Container'
import Row from 'react-bootstrap/Row'
import Col from 'react-bootstrap/Col'
import Styles from '../../styles/MainLately.module.scss'
import Link from 'next/link';
import Image from 'next/image'
import IconEye from '../../public/icons/icon-eye.svg';
import IconThumbsUp from '../../public/icons/icon-thumbs-up.svg';
import IconPlus from '../../public/icons/icon-plus.svg';



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
                <li key={item.idx}>
                    <Link href={'/' + url + '/' + item.idx}>
                        <div className="justify-content-between">
                            <div className='d-flex'>
                                <div className={`${Styles.tt} text-truncate`}>
                                    {item.title}
                                </div>
                                <div className="poo-blue ms-2">{item.commentCnt}</div>
                            </div>
                            <div className={`${Styles.LatestInfo} d-flex`}>
                                <Image src={IconEye} alt="조회수"></Image> {item.viewPoint}
                                <Image src={IconThumbsUp} alt="추천수"></Image> {item.thumbsUp}
                            </div>
                        </div>
                    </Link>
                </li>
        )
    )
}

const ListBoardComponent = ({ boardName, board, comment }) => (
    < div >
        <h2 className="latest-title d-flex justify-content-between align-content-center">
            {boardName}
            <Link href="/free">
                <div className="latest-more-btn d-flex justify-content-center">
                    <Image src={IconPlus} alt="조회수"></Image>
                </div>
            </Link>
        </h2>
        <ul className={Styles.TableStyle}>
            {MainListReturn(boardName, board, comment)}
        </ul>

    </div >
)
export default ListBoardComponent;