import axios from "axios";
import { useRouter } from "next/router";
import { useEffect } from "react";
import { useStore } from '../../../store/store'

function NaverCallback() {

    const router = useRouter();

    const getNaverToken = () => {
        if (typeof window !== 'undefined') {
            const location = window.location.href;
            const token = location.split('=')[1].split('&')[0];
            axios.get("/auth/naver/token?token=" + token).then(function (res) {
                useStore.setState(state => ({ userInfo: res.data }));
                localStorage.setItem("userData", JSON.stringify(res.data))
                opener.location.reload();
                self.close();
            })
        }
    }

    useEffect(() => {
        getNaverToken();
    }, [])

    return (
        <div></div>
    )
}

export default NaverCallback;