package com.example.test.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {
    /**
     * @deprecated
     */
    @Override
    public String getErrorPath() {
        return null;
    }

    @GetMapping("/error")
    public String handleError(HttpServletRequest request, Map<String, Object> map){
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());

            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                map.put("message", "404 Error\nBad request");
            }
            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                map.put("message", "505 Error\nErrors in the server");
            }
        }
        return "error";
    }

}
