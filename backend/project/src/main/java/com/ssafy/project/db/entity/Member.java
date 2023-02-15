package com.ssafy.project.db.entity;

import com.ssafy.project.api.request.MemberJoinPostReq;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id")
    private Card card;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @ElementCollection(fetch = FetchType.LAZY)
    @Builder.Default
    private Set<MemberRoleEnum> roleSet = new HashSet<>();

    public static Member from(MemberJoinPostReq memberInfo, Card card) {
        return Member.builder()
                .email(memberInfo.getEmail())
                .password(new BCryptPasswordEncoder().encode(memberInfo.getPassword()))
                .name(memberInfo.getName())
                .card(card)
                .build();
    }

    public void addMemberRole(MemberRoleEnum memberRole) {
        roleSet.add(memberRole);
    }

    public void changePassword(String newPassword) {
        this.password = newPassword;
    }

    public void createCard(Card newCard){
        this.card= newCard;
    }

    public void addCompany(Company company) {
        this.company = company;
    }

}
