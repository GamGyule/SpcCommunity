import React, { Component } from 'react';
import BoardService from '../service/BoardService';

class ListBoardComponent extends Component {
    constructor(props) {
        super(props)
    // # 1. 
        this.state = { 
            boards: []
        }
		
    }
    // # 2. 
    componentDidMount() {
        BoardService.getBoards().then((res) => {
            this.setState({ boards: res.data});
        });
    }

    // # 3.
    render() {
        return (
            <div>
                <h2 className="text-center">Boards List</h2>
                <div className ="row">
                    <table className="table table-striped table-bordered">
                        <thead>
                            <tr>
                                <th>글 번호</th>
                                <th>제목 </th>
                                <th>작성자 </th>
                                <th>작성일 </th>
                                <th>갱신일 </th>
                                <th>좋아요수</th>
                                <th>조회수</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.boards.map(
                                    board => 
                                    <tr key = {board.idx}>
                                        <td> {board.idx} </td>
                                        <td> {board.title} </td>
                                        <td> {board.writer} </td>
                                        <td> {board.regDate} </td>
                                        <td> {board.thubmsUp} </td>
                                        <td> {board.thumbsDown} </td>
                                        <td> {board.viewPoint} </td>
                                    </tr>
                                )
                            }
                        </tbody>
                    </table>
                </div>
        );
    }
}

export default ListBoardComponent;