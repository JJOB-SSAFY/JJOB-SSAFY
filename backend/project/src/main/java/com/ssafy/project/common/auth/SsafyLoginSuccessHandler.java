package com.ssafy.project.common.auth;

import com.ssafy.project.common.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.endpoint.OAuth2ParameterNames;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@Log4j2
@RequiredArgsConstructor
@Component
public class SsafyLoginSuccessHandler implements AuthenticationSuccessHandler {

    private final JwtTokenUtil jwtUtil;

    private final RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        log.info("----------------------------");
        log.info("onAuthenticationSuccess");

        SsafyOAuth2UserDetails authMember = (SsafyOAuth2UserDetails)authentication.getPrincipal();

        String accessToken = jwtUtil.getToken(authMember.getEmail());
        String name = authMember.getName();
        String role = getRole(authMember.getAuthorities());

        log.info(accessToken);
        log.info(name);
        log.info(role);

        Cookie accessTokenCookie = new Cookie("accessToken", accessToken);
        Cookie nameCookie = new Cookie("name", name);
        Cookie roleCookie = new Cookie("role", role);

        accessTokenCookie.setPath("/");
        nameCookie.setPath("/");
        roleCookie.setPath("/");

        response.addCookie(accessTokenCookie);
        response.addCookie(nameCookie);
        response.addCookie(roleCookie);

        String url = makeRedirectUrl();

        if (response.isCommitted()) {
            log.debug("응답이 이미 커밋된 상태입니다. " + url + "로 리다이렉트하도록 바꿀 수 없습니다.");
            return;
        }

        redirectStrategy.sendRedirect(request, response, url);

    }

    private String makeRedirectUrl() {
        return UriComponentsBuilder.fromUriString("http://localhost/loginRedirectPage")
                .build().toUriString();
    }

    private String getRole(Collection<GrantedAuthority> authorities) {
        if (authorities.toString().contains("ADMIN")) {
            return "ADMIN";
        } else if (authorities.toString().contains("COMPANY")) {
            return "COMPANY";
        }
        return "USER";
    }
}