import create from 'zustand'
import { devtools } from 'zustand/middleware'
import axios from 'axios';

export const useStore = create(devtools((set) => ({
    walletAddress: "",
    page: 1,
    userInfo: {
    }


})))