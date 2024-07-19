package com.study.aws.server.deploy.friends.adapter.out.persistence;

import java.time.LocalDateTime;
import com.study.aws.server.deploy.common.jpa.BaseTimeEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Table(name = "friends")
@Entity
class FriendEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String explanation;


    @Builder
    public FriendEntity(Long id, String name, String explanation, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.explanation = explanation;
    }
}
