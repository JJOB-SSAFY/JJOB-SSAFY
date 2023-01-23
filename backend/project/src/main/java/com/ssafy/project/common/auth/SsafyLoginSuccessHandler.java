package com.ssafy.project.common.auth;

import com.ssafy.project.common.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
@RequiredArgsConstructor
public class SsafyLoginSuccessHandler implements AuthenticationSuccessHandler {

    private final JwtTokenUtil jwtUtil;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        log.info("----------------------------");
        log.info("onAuthenticationSuccess");

        SsafyOAuth2UserDetails authMember = (SsafyOAuth2UserDetails)authentication.getPrincipal();

//        boolean fromSocial = authMember.isFromSocial();

//        if (fromSocial) {
        String token = jwtUtil.getToken(authMember.getEmail());
        response.setContentType("text/plain");
        response.getOutputStream().write(token.getBytes());

        log.info(token);
//        }

    }
}