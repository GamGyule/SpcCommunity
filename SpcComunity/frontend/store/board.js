import create from 'zustand'
import { devtools } from 'zustand/middleware'
import axios from 'axios';

export const useStore = create(devtools((set) => ({

    boardList: [],
    //BoardList
    async BoardListApi() {
        axios.get('/api/boardlist').then(function (e) {
            set((state) => ({ boardList: e.data }))
        });
    }


})))