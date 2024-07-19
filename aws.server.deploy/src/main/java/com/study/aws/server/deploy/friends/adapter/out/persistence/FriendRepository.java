package com.study.aws.server.deploy.friends.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

interface FriendRepository extends JpaRepository<FriendEntity, Long> {}
