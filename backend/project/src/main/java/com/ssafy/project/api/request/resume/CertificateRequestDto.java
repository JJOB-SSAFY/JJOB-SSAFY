package com.ssafy.project.api.request.resume;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CertificateRequestDto {

    private String certificateName;

    private String certificateDate;

    private String certificateInstitution;
}
