package com.study.aws.server.deploy.integration;

import java.util.List;
import com.study.aws.server.deploy.friends.application.port.out.SaveFriendOutPort;
import com.study.aws.server.deploy.friends.domain.Friend;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FriendPersistenceTest {

    @Autowired
    SaveFriendOutPort saveFriendOutPort;


    @Test
    void saveAll() {

        // given
        Friend hyuk =
                this.createFriend("hyuk", "소속: 5am 운영자<br>활동: 창업 활동 중<br>비고: 평소 누구와도 연락이 잘 안되나 여자친구와는 연락이 굉장히 잘되는 편");
        Friend naeun =
                this.createFriend("naeun", "소속: 주독주실 A 클래스 멤버<br>활동: 취업 활동 중<br>비고: 스스로 귀엽다고 말할 정도로 귀여움에 굉장한 자신감을 보임");
        Friend eunseo = this.createFriend("eunseo",
                "소속: 주독주실 A 클래스 멤버<br>활동: 2학기 복학 예정<br>비고: mbti를 굉장히 신뢰함. 함부로 mbti를 밝히지 말 것");
        Friend gyungmin = this.createFriend("gyungmin",
                "소속: 주독주실 A 클래스 멤버<br>활동: 세무사 수험생활 중<br>비고: 놀리면 타격감이 굉장히 좋으며 루피로 변신함. 요즘 혁이랑 휴전 중");
        Friend hanjoon = this.createFriend("hanjoon",
                "소속: 주독주실 B 클래스 멤버<br>활동: 가상공간 프로그래머 도전 중<br>비고: 나에겐 한준이가 한 없이 F로 보이나 놀랍게도 T라는 사실");
        Friend joowon = this.createFriend("joowon",
                "소속: 주독주실 B 클래스 멤버<br>활동: 페스티벌 기획 회사원<br>비고: 남자들 사이에선 의리 넘치는 bro 이자 자신의 여자에겐 로맨틱한 남자. 그러나 맨날 밤샘 야근함");
        Friend donghyun = this.createFriend("donghyun",
                "소속: 주독주실 B 클래스 멤버<br>활동: 사이버 보안 담당 회사원<br>비고: 자주 쓰는 말 - 럭키비키 자나~ & 기질대로 살아야 해 애들아");
        Friend heejae =
                this.createFriend("heejae", "소속: 선택과 집중 팀장<br>활동: 미술 업계 프리랜서<br>비고: 우리나라 군인 수 60만명 - 희재 카톡 수 60만개");
        Friend jisoo =
                this.createFriend("jisoo", "소속: 선택과 집중 팀원<br>활동: 대학원 진학 준비 중<br>비고: 아재개그 좋아하는 흔치 않은 여자. 애착인형 - 루피");
        List<Friend> friends = List.of(hyuk, naeun, eunseo, gyungmin, hanjoon, joowon, donghyun, heejae, jisoo);

        // when
        List<Friend> savedFriends = saveFriendOutPort.saveAll(friends);

        // then
        System.out.println(savedFriends);
    }


    private Friend createFriend(String name, String explanation) {
        return Friend.builder().name(name).explanation(explanation).build();
    }

}
