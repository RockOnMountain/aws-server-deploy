package com.study.aws.server.deploy.friends.application.service;

import java.util.Optional;
import com.study.aws.server.deploy.friends.application.port.in.GetFriendUseCase;
import com.study.aws.server.deploy.friends.application.port.out.GetFriendOutPort;
import com.study.aws.server.deploy.friends.domain.Friend;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
class GetFriendService implements GetFriendUseCase {

    private final GetFriendOutPort getFriendOutPort;


    @Override
    public Optional<Friend> getByName(String name) {
        return getFriendOutPort.getByName(name);
    }
}
