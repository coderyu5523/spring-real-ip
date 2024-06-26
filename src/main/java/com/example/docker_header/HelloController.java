package com.example.docker_header;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/server1")
    public String getHeaders(HttpServletRequest request,
                             @RequestHeader(value = "X-Real-IP", required = false) String realIp,
                             @RequestHeader(value = "X-Forwarded-For", required = false) String forwardedFor) {
        if (realIp == null) {
            realIp = request.getRemoteAddr();
        }
        if (forwardedFor == null) {
            forwardedFor = request.getHeader("X-Forwarded-For");
        }

        return "X-Real-IP: " + realIp + ", X-Forwarded-For: " + forwardedFor;
    }


}
