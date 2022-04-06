import axios from 'axios';
import { useEffect } from 'react';
import { useStore } from '../../store/board.js'
import Styles from '../../styles/ListStyle.module.scss'



function BoardReturn(props) {
    console.log(props.board);
    useEffect(async () => {
        axios.get('/api/board/list').then(function (e) {
            useStore.setState(state => ({ boardList: e.data }));
        });
    }, [])

    let list = useStore(state => state.boardList);

    return (
        list.map(
            board =>
                <tr key={board.idx}>
                    <td> {board.idx} </td>
                    <td> {board.title} </td>
                    <td> {board.reg} </td>
                    <td> {board.regDate} </td>
                    <td> {board.thumbsUp - board.thumbsDown} </td>
                    <td> {board.viewPoint} </td>
                </tr>
        )
    )
}

const ListBoardComponent = (props) => (
    < div >
        <h2>자유 게시판</h2>
        <div>
            <table className={Styles.TableStyle}>
                <thead>
                    <tr>
                        <th>No.</th>
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