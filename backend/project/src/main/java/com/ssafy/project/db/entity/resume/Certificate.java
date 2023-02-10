package com.ssafy.project.db.entity.resume;

import com.ssafy.project.api.request.resume.CertificateRequestDto;
import lombok.*;

import javax.persistence.*;

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

    private String certificateName;

    private String certificateDate;

    private String certificateInstitution;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id")
    private Resume resume;

    public Certificate(Resume resume, CertificateRequestDto requestDto){
        this.resume = resume;
        this.certificateName = requestDto.getCertificateName();
        this.certificateDate = requestDto.getCertificateDate();
        this.certificateInstitution = requestDto.getCertificateInstitution();

    }

    public void updateCertificate(CertificateRequestDto requestDto){
        this.certificateName = requestDto.getCertificateName();
        this.certificateDate = requestDto.getCertificateDate();
        this.certificateInstitution = requestDto.getCertificateInstitution();
    }

}
