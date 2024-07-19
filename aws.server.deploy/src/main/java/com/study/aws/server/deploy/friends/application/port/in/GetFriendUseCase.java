package com.study.aws.server.deploy.friends.application.port.in;

import java.util.Optional;
import com.study.aws.server.deploy.friends.domain.Friend;

public interface GetFriendUseCase {

    Optional<Friend> getByName(String name);
}
