package com.study.aws.server.deploy.api;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public ResponseEntity<String> index() {

        String message = "안녕하세요 5am 박종혁입니다." + "<br>"
                + "주독주실 A 클래스 : 혁이, 나은이, 은서, 경민이" + "<br>"
                + "주독주실 B 클래스 : 한준이, 주원이, 동현이" + "<br>"
                + "선택과 집중 팀 : 지수, 희재 (우승 예정)";

        return ResponseEntity.ok(message);
    }
}
