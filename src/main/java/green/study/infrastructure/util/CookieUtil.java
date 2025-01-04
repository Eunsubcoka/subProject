package green.study.infrastructure.util;


import jakarta.servlet.http.Cookie;
import org.springframework.stereotype.Component;

@Component
public class CookieUtil {

    public static Cookie createJwtCookie(String token) {
        Cookie jwtCookie = new Cookie("JWT_TOKEN", token);
        jwtCookie.setHttpOnly(true);
        jwtCookie.setPath("/");
        jwtCookie.setMaxAge(60 * 60 * 24); // 1일
        return jwtCookie;
    }
    public static Cookie[] deleteCookie(Cookie[] cookies) {
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                // 기존 쿠키를 삭제하기 위해 유효기간을 0으로 설정
                cookie.setMaxAge(0);
                cookie.setPath("/"); // 모든 경로에서 삭제되도록 설정
            }
        }
        return cookies;
    }
}