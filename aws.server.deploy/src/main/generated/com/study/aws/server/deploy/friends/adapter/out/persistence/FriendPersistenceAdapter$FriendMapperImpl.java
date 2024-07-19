package com.study.aws.server.deploy.friends.adapter.out.persistence;

import com.study.aws.server.deploy.friends.domain.Friend;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-19T11:19:19+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
class FriendPersistenceAdapter$FriendMapperImpl implements FriendPersistenceAdapter.FriendMapper {

    @Override
    public FriendEntity toEntity(Friend domain) {
        if ( domain == null ) {
            return null;
        }

        FriendEntity.FriendEntityBuilder friendEntity = FriendEntity.builder();

        friendEntity.id( domain.getId() );
        friendEntity.name( domain.getName() );
        friendEntity.explanation( domain.getExplanation() );
        friendEntity.createdAt( domain.getCreatedAt() );
        friendEntity.updatedAt( domain.getUpdatedAt() );

        return friendEntity.build();
    }

    @Override
    public List<FriendEntity> toEntities(List<Friend> domains) {
        if ( domains == null ) {
            return null;
        }

        List<FriendEntity> list = new ArrayList<FriendEntity>( domains.size() );
        for ( Friend friend : domains ) {
            list.add( toEntity( friend ) );
        }

        return list;
    }

    @Override
    public Friend toDomain(FriendEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Friend.FriendBuilder friend = Friend.builder();

        friend.id( entity.getId() );
        friend.name( entity.getName() );
        friend.explanation( entity.getExplanation() );
        friend.createdAt( entity.getCreatedAt() );
        friend.updatedAt( entity.getUpdatedAt() );

        return friend.build();
    }

    @Override
    public List<Friend> toDomains(List<FriendEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<Friend> list = new ArrayList<Friend>( entities.size() );
        for ( FriendEntity friendEntity : entities ) {
            list.add( toDomain( friendEntity ) );
        }

        return list;
    }
}
