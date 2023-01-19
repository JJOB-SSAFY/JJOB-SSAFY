package com.ssafy.project.db.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class Conference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "conference_id")
    private Long id;

    @Column(nullable = false)
    private String conferenceTitle;

    @Column(nullable = false)
    private LocalDateTime callEndTime;

    @Column(nullable = false)
    private LocalDateTime callStartTime;

}
