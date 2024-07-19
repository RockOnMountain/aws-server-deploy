package com.study.aws.server.deploy.friends.adapter.out.persistence;

import java.util.List;
import java.util.Optional;
import com.study.aws.server.deploy.friends.application.port.out.GetFriendOutPort;
import com.study.aws.server.deploy.friends.application.port.out.SaveFriendOutPort;
import com.study.aws.server.deploy.friends.domain.Friend;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
class FriendPersistenceAdapter implements SaveFriendOutPort, GetFriendOutPort {

    private final FriendRepository friendRepository;
    private final FriendMapper friendMapper;


    @Override
    public Friend save(Friend friend) {

        FriendEntity savedFriendEntity = friendRepository.save(friendMapper.toEntity(friend));
        return friendMapper.toDomain(savedFriendEntity);
    }


    @Override
    public List<Friend> saveAll(List<Friend> friends) {

        List<FriendEntity> savedFriendEntities = friendRepository.saveAll(friendMapper.toEntities(friends));
        return friendMapper.toDomains(savedFriendEntities);
    }


    @Override
    public Optional<Friend> getByName(String name) {
        return friendRepository.findByName(name).map(friendMapper::toDomain);
    }


    @Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
    interface FriendMapper {

        FriendEntity toEntity(Friend domain);

        List<FriendEntity> toEntities(List<Friend> domains);

        Friend toDomain(FriendEntity entity);

        List<Friend> toDomains(List<FriendEntity> entities);
    }
}
