import axios from 'axios';
import { useEffect } from 'react';
import { useStore } from '../../store/board.js'
import Styles from '../../styles/MainLately.module.scss'
import Link from 'next/link';



function MainListReturn(props) {

    let list = props.data;

    if (list.length < 1) {
        console.log("No Data");
    }

    return (
        list.map(
            board =>
                <li key={board.idx}><Link href='/'><div><div>{board.title}</div><div>[10]</div><div>[?]</div></div></Link></li>
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