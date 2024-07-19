package com.study.aws.server.deploy.friends.adapter.in;

import com.study.aws.server.deploy.friends.application.port.in.GetFriendUseCase;
import com.study.aws.server.deploy.friends.domain.Friend;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/friends")
class FriendController {

    private final GetFriendUseCase getFriendUseCase;


    @GetMapping("/{name}")
    public ResponseEntity<String> getFriendExplanationByName(@PathVariable("name") String name) {

        String friendExplanation = getFriendUseCase.getByName(name).map(Friend::getExplanation)
                .orElse("해당 이름은 존재하지 않습니다. 이름을 제대로 입력해주세요.");

        return ResponseEntity.ok(friendExplanation);
    }
}
