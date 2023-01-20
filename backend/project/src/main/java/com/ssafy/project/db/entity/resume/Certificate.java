package com.ssafy.project.db.entity.resume;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "certificate_id")
    private Long id;

    @Column(nullable = false)
    private String certificateName;

    @Column(nullable = false)
    private LocalDateTime certificateDate;

    @Column(nullable = false)
    private String certificateInstitution;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id")
    private Resume resume;

}
