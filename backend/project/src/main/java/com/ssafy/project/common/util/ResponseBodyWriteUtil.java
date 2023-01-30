package com.ssafy.project.common.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
import com.ssafy.project.api.response.BaseResponseBody;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public class ResponseBodyWriteUtil {

    public static void sendApiResponse(HttpServletResponse response, BaseResponseBody apiResponse) throws IOException {
        response.setStatus(HttpStatus.OK.value());
        response.setContentType(APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("UTF-8");
        response.getOutputStream().write(new ObjectMapper().writeValueAsString(apiResponse).getBytes());
    }

    public static void sendError(HttpServletRequest request, HttpServletResponse response, Exception ex, HttpStatus httpStatus) throws IOException {
        response.setStatus(httpStatus.value());
        response.setContentType(APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("UTF-8");
        String message = ex.getMessage();
        message = message == null ? "" : message;
        Map<String, Object> data = ImmutableMap.of(
                "timestamp", Calendar.getInstance().getTime(),
                "status", httpStatus.value(),
                "error", ex.getClass().getSimpleName(),
                "message", message,
                "path", request.getRequestURI()
        );
        PrintWriter pw = response.getWriter();
        pw.print(new ObjectMapper().writeValueAsString(data));
        pw.flush();
    }

    public static void sendError(HttpServletRequest request, HttpServletResponse response, Exception ex) throws IOException {
        sendError(request, response, ex, HttpStatus.UNAUTHORIZED);
    }
}
