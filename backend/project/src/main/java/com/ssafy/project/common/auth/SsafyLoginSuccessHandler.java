package com.ssafy.project.common.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.project.api.response.MemberLoginPostRes;
import com.ssafy.project.common.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.var;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
@RequiredArgsConstructor
@Component
public class SsafyLoginSuccessHandler implements AuthenticationSuccessHandler {

    private final JwtTokenUtil jwtUtil;

    private final ObjectMapper objectMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        log.info("----------------------------");
        log.info("onAuthenticationSuccess");

        SsafyOAuth2UserDetails authMember = (SsafyOAuth2UserDetails)authentication.getPrincipal();

        String accessToken = jwtUtil.getToken(authMember.getEmail());
        writeTokenResponse(response, accessToken);

        log.info(accessToken);

    }

    private void writeTokenResponse(HttpServletResponse response, String accessToken) throws IOException {
        response.setContentType("text/html;charset=UTF-8");

//        response.addHeader("accessToken", accessToken);
//        response.setContentType("application/json;charset=UTF-8");

        var writer = response.getWriter();
        writer.println(objectMapper.writeValueAsString(MemberLoginPostRes.of(200, "Success", accessToken)));
        writer.flush();
    }
}