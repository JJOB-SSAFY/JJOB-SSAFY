package com.ssafy.project.common.auth;

import com.ssafy.project.db.entity.Member;
import com.ssafy.project.db.entity.MemberRoleEnum;
import com.ssafy.project.db.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class SsafyOAuth2UserDetailService extends DefaultOAuth2UserService {

    private final MemberRepository memberRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        log.info("------------------------------");
        log.info("userRequest:" + userRequest);

        String clientName = userRequest.getClientRegistration().getClientName();

        log.info("clientName: " + clientName);
        log.info(userRequest.getAdditionalParameters());

        OAuth2User oAuth2User = super.loadUser(userRequest);

        log.info("==============================");
        oAuth2User.getAttributes().forEach((k,v) -> {
            log.info(k + " : " + v);
        });

        String email = null;
        String name = null;

        if (clientName.equals("Google")) {
            email = oAuth2User.getAttribute("email");
            name = oAuth2User.getAttribute("name");
        } else if (clientName.equals("Kakao")) {
            HashMap<String, String> map = oAuth2User.getAttribute("kakao_account");
            HashMap<String, String> profile = oAuth2User.getAttribute("properties");
            email = map.get("email");
            name = profile.get("nickname");
        }

        log.info("EMAIL: " + email);
        log.info("NAME: " + name);

        Member member = saveSocialMember(email, name);

        SsafyOAuth2UserDetails ssafyOauth2Member = new SsafyOAuth2UserDetails(
                member.getEmail(),
                member.getPassword(),
                member.getRoleSet()
                        .stream()
                        .map(role -> new SimpleGrantedAuthority("ROLE_" + role.name()))
                        .collect(Collectors.toList()),
                oAuth2User.getAttributes()
        );
        ssafyOauth2Member.setName(member.getName());

        return ssafyOauth2Member;

    }

    private Member saveSocialMember(String email, String name) {

        Optional<Member> result = memberRepository.findByEmail(email);

        if (result.isPresent()) {
            return result.get();
        }

        String password = email + UUID.randomUUID().toString();

        Member member = Member.builder()
                .email(email)
                .name(name)
                .password(new BCryptPasswordEncoder().encode(password))
                .build();

        member.addMemberRole(MemberRoleEnum.USER);

        memberRepository.save(member);

        return member;
    }

}
