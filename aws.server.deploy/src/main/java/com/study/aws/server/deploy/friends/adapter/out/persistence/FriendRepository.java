package com.study.aws.server.deploy.friends.adapter.out.persistence;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

interface FriendRepository extends JpaRepository<FriendEntity, Long> {

    Optional<FriendEntity> findByName(String name);
}
