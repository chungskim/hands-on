package springhandson.handson.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import springhandson.handson.domain.Member;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 각 테스트가 종료될 때마다 실행
    @AfterEach
    public void afterEach() {
        repository.clearStore(); // 메모리 DB에 저장된 데이터 삭제
    }

    @Test
    void save() {
        // given
        Member member = new Member();
        member.setName("potato");

        // when
        repository.save(member);

        // then
        Member result = repository.findById(member.getId()).get();
        assertThat(result).isEqualTo(member);
    }

    @Test
    void findById() {
        //given
        Member member1 = new Member();
        member1.setName("potato1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("potato2");
        repository.save(member2);

        //when
        Member result = repository.findByName("potato1").get();

        //then
        assertThat(result).isEqualTo(member1);
    }

    @Test
    void findAll() {
        //given
        Member member1 = new Member();
        member1.setName("potato1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("potato2");
        repository.save(member2);

        //when
        List<Member> result = repository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    void findByName() {
    }

    @Test
    void clearStore() {
    }
}