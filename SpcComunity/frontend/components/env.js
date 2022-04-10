export const NAVER_CLIENT_ID = "HKij2ahOulwKfIHiCVTt";
export const NAVER_CLIENT_SECRET = "OUwmHHTLJs";

export const OAUTH_REDIRECT_URI = "/naverLogin";


export const NAVER_AUTH_URL = "https://nid.naver.com/oauth2.0/authorize?client_id=" + NAVER_CLIENT_ID +
    "&redirect_uri=" + OAUTH_REDIRECT_URI + "naver" +
    "&response_type=token" +
    "&state=state"

export const NAVER_TOKEN_URL = "https://nid.naver.com/oauth2.0/token?client_id=" + NAVER_CLIENT_ID +
    "&client_secret=" + NAVER_CLIENT_SECRET +
    "&redirect_uri=" + OAUTH_REDIRECT_URI + "naver" +
    "&grant_type=authorization_code" +
    "&code="