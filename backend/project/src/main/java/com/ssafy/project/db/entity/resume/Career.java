package com.ssafy.project.db.entity.resume;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class Career {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "career_id")
    private Long id;

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String careerPeriod;

    @Column(nullable = false)
    private String careerContent;

}
