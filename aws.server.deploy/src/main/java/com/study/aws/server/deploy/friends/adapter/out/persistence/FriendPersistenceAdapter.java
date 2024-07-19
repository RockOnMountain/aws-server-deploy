package com.study.aws.server.deploy.friends.adapter.out.persistence;

import com.study.aws.server.deploy.friends.application.port.out.SaveFriendOutPort;
import com.study.aws.server.deploy.friends.domain.Friend;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
class FriendPersistenceAdapter implements SaveFriendOutPort {

    private final FriendRepository friendRepository;
    private final FriendMapper friendMapper;


    @Override
    public Friend save(Friend friend) {

        FriendEntity savedFriendEntity = friendRepository.save(friendMapper.toEntity(friend));
        return friendMapper.toDomain(savedFriendEntity);
    }


    @Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
    interface FriendMapper {

        FriendEntity toEntity(Friend domain);

        Friend toDomain(FriendEntity entity);
    }
}
