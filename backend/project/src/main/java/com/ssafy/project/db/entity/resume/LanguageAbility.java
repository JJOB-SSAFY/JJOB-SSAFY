package com.ssafy.project.db.entity.resume;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class LanguageAbility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_ability_id")
    private Long id;

    @Column(nullable = false)
    private String language;

    @Column(nullable = false)
    private String testName;

    @Column(nullable = false)
    private String grade;

    @Column(nullable = false)
    private String testDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id")
    private Resume resume;

}
