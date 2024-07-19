package com.study.aws.server.deploy.friends.application.port.out;

import java.util.List;
import com.study.aws.server.deploy.friends.domain.Friend;

public interface SaveFriendOutPort {

    Friend save(Friend friend);

    List<Friend> saveAll(List<Friend> friends);
}
