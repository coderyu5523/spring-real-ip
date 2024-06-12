package com.example.docker_header;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@Controller
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

        System.out.println("X-Real-IP :" + realIp);
        System.out.println("X-Forwarded-For :" + forwardedFor);
        return "ok";
    }

}
