package com.study.aws.server.deploy.api;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HealthCheckController {

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {

        String message = "Health Check!" + "<br>" + "요즘 감기 많이 걸린다고 하네. 모두들 건강하자";
        return ResponseEntity.ok(message);
    }
}
