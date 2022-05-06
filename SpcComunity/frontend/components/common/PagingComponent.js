import Link from 'next/link';
import Image from 'next/image'
import Styles from '../../styles/Paging.module.scss'
import chevronLeft from '../../public/icons/icon-chevron-left.svg'
import chevronRight from '../../public/icons/icon-chevron-right.svg'

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
            result.push(<Link key={indexOfFirst - 1} href={'/' + board + '?page=' + parseInt(indexOfFirst - 1)}><span className={Styles.PagingArrow}><Image src={chevronLeft} alt="Next"></Image></span></Link>);
        }
        for (let i = indexOfFirst; i <= indexOfLast; i++) {
            if (i == currPage) {
                result.push(<Link key={i} href={'/' + board + '?page=' + i}><span className={Styles.Active}>{i}</span></Link>);
            } else {
                result.push(<Link key={i} href={'/' + board + '?page=' + i}><span>{i}</span></Link>);
            }
        }
        if (indexOfLast < boardPage) {
            result.push(<Link key={indexOfLast + 1} href={'/' + board + '?page=' + parseInt(indexOfLast + 1)}><span className={Styles.PagingArrow}><Image src={chevronRight} alt="Prev"></Image></span></Link>);
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