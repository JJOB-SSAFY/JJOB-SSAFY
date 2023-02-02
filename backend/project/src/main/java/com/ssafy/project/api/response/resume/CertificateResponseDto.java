package com.ssafy.project.api.response.resume;

import com.ssafy.project.db.entity.resume.Certificate;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CertificateResponseDto {

    private String certificateName;

    private String certificateDate;

    private String certificateInstitution;

    public CertificateResponseDto(Certificate certificate) {
        this.certificateName = certificate.getCertificateName();
        this.certificateDate = certificate.getCertificateDate();
        this.certificateInstitution = certificate.getCertificateInstitution();
    }

}
