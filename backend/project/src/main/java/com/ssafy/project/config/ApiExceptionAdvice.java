package com.ssafy.project.config;

import com.ssafy.project.common.exception.ApiException;
import com.ssafy.project.common.exception.ApiExceptionEntity;
import com.ssafy.project.common.exception.ExceptionEnum;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.AccessDeniedException;

@RestControllerAdvice
public class ApiExceptionAdvice {

    /**
     * API 에러 핸들링입니다.
     * 아래의 경우로 에러를 발생하면 해당 예외처리기에서 클라이언트로 응답합니다.
     *
     * ex)
     * throw new ApiException(ExceptionEnum.RUNTIME_EXCEPTION);
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler({ApiException.class})
    public ResponseEntity<ApiExceptionEntity> apiExceptionHandler(HttpServletRequest request, final ApiException e) {

        return new ResponseEntity<ApiExceptionEntity>(
                new ApiExceptionEntity(
                        e.getError().getCode(),
                        e.getError().getMessage()
                ),
                e.getError().getStatus()
        );

    }

    /**
     * 존재하지 않는 API에 대한 기본 메세지 처리입니다.
     * @param exception
     * @return
     */
    @ExceptionHandler({NoHandlerFoundException.class})
    public ResponseEntity<ApiExceptionEntity> notFoundExceptionHandler(final Exception exception) {

        ApiException e = new ApiException(ExceptionEnum.API_NOT_EXIST_EXCEPTION);
        return new ResponseEntity<ApiExceptionEntity>(
                new ApiExceptionEntity(
                        e.getError().getCode(),
                        e.getError().getMessage()
                ),
                e.getError().getStatus()
        );
    }

    /**
     * 런타임 예외에 대한 처리입니다.
     * @param request
     * @param exception
     * @return
     */
    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<ApiExceptionEntity> runTimeExceptionHanlder(HttpServletRequest request, final Exception exception) {

        ApiException e = new ApiException(ExceptionEnum.RUNTIME_EXCEPTION);
        return new ResponseEntity<ApiExceptionEntity>(
                new ApiExceptionEntity(
                        e.getError().getCode(),
                        e.getError().getMessage()
                ),
                e.getError().getStatus()
        );
    }

    /**
     * 경로는 있으나 메서드가 다를 경우 405 예외를 리턴합니다.
     * @param request
     * @param exception
     * @return
     */
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public ResponseEntity<ApiExceptionEntity> methodNotSupportExceptionHandler(HttpServletRequest request, final Exception exception) {

        ApiException e = new ApiException(ExceptionEnum.API_METHOD_NOT_ALLOWED_EXCEPTION);
        return new ResponseEntity<ApiExceptionEntity>(
                new ApiExceptionEntity(
                        e.getError().getCode(),
                        e.getError().getMessage()
                ),
                e.getError().getStatus()
        );
    }

    /**
     * 전체 예외에 대한 기본 처리입니다.
     * @param request
     * @param exception
     * @return
     */
    @ExceptionHandler({Exception.class})
    public ResponseEntity<ApiExceptionEntity> internalServerExceptionHandler(HttpServletRequest request, final Exception exception) {

        ApiException e = new ApiException(ExceptionEnum.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<ApiExceptionEntity>(
                new ApiExceptionEntity(
                        e.getError().getCode(),
                        e.getError().getMessage()
                ),
                e.getError().getStatus()
        );
    }

    /**
     * 파라미터 검증에서 실패했을 경우 기본 처리입니다.
     * @param request
     * @param exception
     * @return
     */
    @ExceptionHandler(value = {
            MethodArgumentNotValidException.class,
            MissingServletRequestParameterException.class
    })
    public ResponseEntity<ApiExceptionEntity> parameterException(HttpServletRequest request, final Exception exception) {

        ApiException e = new ApiException(ExceptionEnum.API_PARAMETER_EXCEPTION);
        return new ResponseEntity<ApiExceptionEntity>(
                new ApiExceptionEntity(
                        e.getError().getCode(),
                        e.getError().getMessage()
                ),
                e.getError().getStatus()
        );
    }

    @ExceptionHandler({AccessDeniedException.class})
    public ResponseEntity<ApiExceptionEntity> accessDeniedException(HttpServletRequest request, final Exception exception) {

        ApiException e = new ApiException(ExceptionEnum.MEMBER_ACCESS_EXCEPTION);
        return new ResponseEntity<ApiExceptionEntity>(
                new ApiExceptionEntity(
                        e.getError().getCode(),
                        e.getError().getMessage()
                ),
                e.getError().getStatus()
        );
    }

}

