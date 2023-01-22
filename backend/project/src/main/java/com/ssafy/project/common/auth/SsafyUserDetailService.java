package com.ssafy.project.common.auth;

import com.ssafy.project.api.service.MemberService;
import com.ssafy.project.db.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class SsafyUserDetailService implements UserDetailsService {
    @Autowired
    MemberService memberService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member member = memberService.getMemberByEmail(email);
        if (member != null) {
            SsafyUserDetails userDetails = new SsafyUserDetails(member);
            return userDetails;
        }
        return null;
    }
}

