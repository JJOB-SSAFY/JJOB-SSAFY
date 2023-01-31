package com.ssafy.project.common.auth;

import com.ssafy.project.api.service.MemberService;
import com.ssafy.project.db.entity.Member;
import com.ssafy.project.db.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Component
@RequiredArgsConstructor
public class SsafyUserDetailService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<Member> findMember = memberRepository.findByEmail(email);

        if (!findMember.isPresent()) throw new UsernameNotFoundException("Check User Email or from Social ");

        Member member = findMember.get();

        SsafyUserDetails userDetails = new SsafyUserDetails(member);
        userDetails.setAuthorities(member.getRoleSet()
                .stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.name()))
                .collect(toList()));
        return userDetails;
    }
}

