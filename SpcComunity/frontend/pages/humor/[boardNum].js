import axios from 'axios'
import { GetServerSideProps } from 'next';
import { useRouter } from 'next/router';
import { useEffect } from 'react';
import { Fragment } from 'react/cjs/react.production.min';
import BoardComponent from '../../components/common/BoardComponent'
import CommentComponent from '../../components/common/CommentComponent'

function Board({ data }) {
    return (
        <Fragment>
            <BoardComponent board={data.board} comment={data.comment} />
        </Fragment>
    )
}

export const getServerSideProps = async ({ query: { boardNum } }) => {
    let data = [];
    await axios.get('http://127.0.0.1:9999/api/board/humor/' + boardNum).then(function (e) {
        data = e.data;
    });


    return { props: { data: data } }
}

export default Board;