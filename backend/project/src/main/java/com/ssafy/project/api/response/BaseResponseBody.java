package com.ssafy.project.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponseBody {

    String message = null;

    Integer statusCode = null;

}
