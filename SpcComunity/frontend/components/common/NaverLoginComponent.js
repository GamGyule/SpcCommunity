import { useRouter } from "next/router";
import { useEffect } from "react";
import "../env"
import { NAVER_CLIENT_ID, OAUTH_REDIRECT_URI } from "../env";

function NaverLoginComponent() {
    const router = useRouter();
    const NaverLogin = () => {
        //ssr은 초기 window 객체를 불러오지 못한다.
        if (typeof window.naver !== 'undefined') {
            Naver();
        }
    };
    useEffect(() => {
        NaverLogin();
    }, []);

    function Naver() {
        const naverLogin = new naver.LoginWithNaverId({
            clientId: NAVER_CLIENT_ID,
            callbackUrl: OAUTH_REDIRECT_URI,
            isPopup: true,
            loginButton: { color: 'white', type: 1, height: 30 }
        });
        naverLogin.init();
    }
    return (
        <div id='naverIdLogin' onClick={NaverLogin}></div>
    )
}
export default NaverLoginComponent;