package com.study.aws.server.deploy.friends.application.port.out;

import java.util.Optional;
import com.study.aws.server.deploy.friends.domain.Friend;

public interface GetFriendOutPort {

    Optional<Friend> getByName(String name);
}
