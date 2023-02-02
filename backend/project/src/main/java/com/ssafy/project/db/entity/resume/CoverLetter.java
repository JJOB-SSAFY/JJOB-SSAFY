package com.ssafy.project.db.entity.resume;

import com.ssafy.project.api.request.resume.CoverLetterRequestDto;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class CoverLetter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cover_letter_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id")
    private Resume resume;

    public CoverLetter(Resume resume, CoverLetterRequestDto requestDto){
        this.resume = resume;
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
    }

    public void updateCoverLetter(CoverLetterRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
    }

}
