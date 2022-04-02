import create from 'zustand'
import { devtools } from 'zustand/middleware'
import axios from 'axios';

export const useStore = create(devtools((set) => ({
    walletAddress: "",
    backData: "",

    //ajax 요청법
    async BackConnectApi() {
        axios.get('/api/hi').then(function (e) {
            set((state) => ({ backData: e.data }))
        });
    },

    //BoardList
    async BoardListApi() {
        axios.get('/api/boardlist').then(function (e) {
            set((state) => ({ backData: e.data }))
        });
    }


})))