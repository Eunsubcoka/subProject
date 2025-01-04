package green.study.infrastructure.util;



import green.study.domain.model.User;
import io.github.cdimascio.dotenv.Dotenv;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
@Slf4j
@Getter
public class JwtUtil {
    private final String secretKey ;
    private final SecretKey key;

    public JwtUtil() {
        Dotenv dotenv = Dotenv.load();
        this.secretKey = dotenv.get("JWT_SECRET_KEY");
        this.key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
    }

    Long EXPIRATION_TIME_MS = 1000 * 60 * 60 * 24L; // 밀리세컨이라 1000 * 60초 * 60분 * 24시 => 하루
    private static final String USER_NO_KEY_NAME = "userNo";
    private static final String USER_ID_KEY_NAME = "userId";
    private static final String USER_TYPE_KEY_NAME = "type";

    /**
     * 만료시간에 대한 서비스 확장성을 위한 오버로딩 메서드 생성
     * @param loginUser
     * @return
     **/

    public String createAccessToken(final User loginUser) {
        String token = Jwts.builder()
                .claim(USER_NO_KEY_NAME, loginUser.getUserNo())
                .claim(USER_ID_KEY_NAME, loginUser.getUserId())
                .claim(USER_TYPE_KEY_NAME, loginUser.getRole())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME_MS))
                .signWith(key)
                .compact();
        log.debug("created token : {} ", token);
        return token;
    }



    public User getLoginUserFromAccessToken(final String accessToken) {
        Claims claims = getClaims(accessToken);

        return User.builder()
                .userNo(claims.get(USER_NO_KEY_NAME, Long.class))
                .userId(claims.get(USER_ID_KEY_NAME, String.class))
                .role(claims.get(USER_TYPE_KEY_NAME, String.class))
                .build();

    }

    private Claims getClaims(final String accessToken) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .verifyWith(key) // 단순히 key 타입만 검증하더라...
                    .build()
                    .parseSignedClaims(accessToken)
                    .getPayload();
        } catch(ExpiredJwtException eje) { // 만료된 토큰일 경우 발생하는 Exception
            throw new IllegalArgumentException("No Token"); // 내가 만든 Exception으로 바꿔서 던짐 -> 리프레시토큰 로직으로 분기되어야함
        }
        return claims;
    }

}