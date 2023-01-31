package com.ssafy.project.db.entity;

import com.ssafy.project.api.request.MemberJoinPostReq;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    private String phone;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id")
    private Card card;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    public void changePassword(String newPassword) {
        this.password = newPassword;
    }

    public static Member from(MemberJoinPostReq memberInfo) {
        return Member.builder()
                .email(memberInfo.getEmail())
                .password(new BCryptPasswordEncoder().encode(memberInfo.getPassword()))
                .name(memberInfo.getName())
                .phone(memberInfo.getPhone())
                .build();
    }
    public void createCard(Card newCard){
        this.card= newCard;
    }

}
