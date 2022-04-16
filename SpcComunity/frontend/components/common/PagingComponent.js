import Link from 'next/link';
import Styles from '../../styles/Paging.module.scss'

function Paging(data, page, board) {
    let pagingSlice = 10;
    let boardSlice = 20;
    let currPage = page;
    let boardLength = data.boardCount;
    let boardPage = Math.round(boardLength / 20);
    let indexOfFirst = Math.ceil(currPage / 10) * 10 - 9;
    let indexOfLast = (indexOfFirst + 9) > boardPage ? boardPage : (indexOfFirst + 9);
    const rendering = () => {
        let result = [];
        if (currPage > 10) {
            result.push(<Link href={'/' + board + '?page=' + parseInt(indexOfFirst - 1)}><span>이전</span></Link>);
        }
        for (let i = indexOfFirst; i <= indexOfLast; i++) {
            if (i == currPage) {
                result.push(<Link key={i} href={'/' + board + '?page=' + i}><span className={Styles.Active}>{i}</span></Link>);
            } else {
                result.push(<Link key={i} href={'/' + board + '?page=' + i}><span>{i}</span></Link>);
            }
        }
        if (indexOfLast < boardPage) {
            result.push(<Link href={'/' + board + '?page=' + parseInt(indexOfLast + 1)}><span>다음</span></Link>);
        }
        return result;
    }
    return rendering()
}

function PagingComponent({ data, page, board }) {
    return (
        <div className={Styles.PagingArea} >
            {Paging(data, page, board)}
        </div>
    )
}

export default PagingComponent;