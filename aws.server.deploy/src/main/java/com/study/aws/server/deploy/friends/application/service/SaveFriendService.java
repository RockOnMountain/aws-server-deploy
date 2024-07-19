package com.study.aws.server.deploy.friends.application.service;

import com.study.aws.server.deploy.friends.application.port.in.SaveFriendUseCase;
import com.study.aws.server.deploy.friends.application.port.out.SaveFriendOutPort;
import com.study.aws.server.deploy.friends.domain.Friend;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
class SaveFriendService implements SaveFriendUseCase {

    private final SaveFriendOutPort saveFriendOutPort;


    @Override
    public Friend save(Command command) {
        return saveFriendOutPort.save(
                Friend.builder().name(command.getName()).explanation(command.getExplanation()).build());
    }
}
