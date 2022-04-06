import axios from 'axios';
import { useEffect } from 'react';
import { useStore } from '../../store/board.js'




function BoardReturn() {

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
                    <td> {board.writer} </td>
                    <td> {board.regDate} </td>
                    <td> {board.thubmsUp} </td>
                    <td> {board.thumbsDown} </td>
                    <td> {board.viewPoint} </td>
                </tr>
        )
    )
}

const ListBoardComponent = () => (
    <div>
        <h2 className="text-center">Boards List</h2>
        <div className="row">
            <table className="table table-striped table-bordered">
                <thead>
                    <tr>
                        <th>글 번호</th>
                        <th>제목 </th>
                        <th>작성자 </th>
                        <th>작성일 </th>
                        <th>공감 </th>
                        <th>비공감</th>
                        <th>조회수</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        BoardReturn()
                        // this.state.boards.map(
                        //     board =>
                        //         <tr key={board.idx}>
                        //             <td> {board.idx} </td>
                        //             <td> {board.title} </td>
                        //             <td> {board.writer} </td>
                        //             <td> {board.regDate} </td>
                        //             <td> {board.thubmsUp} </td>
                        //             <td> {board.thumbsDown} </td>
                        //             <td> {board.viewPoint} </td>
                        //         </tr>
                        // )
                    }
                </tbody>
            </table>
        </div>
    </div>
)

export default ListBoardComponent;