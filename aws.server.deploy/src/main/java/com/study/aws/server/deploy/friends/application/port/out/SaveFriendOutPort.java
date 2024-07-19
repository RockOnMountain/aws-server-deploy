package com.study.aws.server.deploy.friends.application.port.out;

import com.study.aws.server.deploy.friends.domain.Friend;

public interface SaveFriendOutPort {

    Friend save(Friend friend);
}
