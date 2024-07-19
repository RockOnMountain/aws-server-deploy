package com.study.aws.server.deploy.friends.application.port.in;

import com.study.aws.server.deploy.friends.domain.Friend;
import lombok.Builder;
import lombok.Getter;

public interface SaveFriendUseCase {

    Friend save(Command command);

    @Builder
    @Getter
    class Command {

        String name;
        String explanation;
    }
}
