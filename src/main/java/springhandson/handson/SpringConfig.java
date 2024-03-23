package springhandson.handson;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springhandson.handson.repository.MemberRepository;
import springhandson.handson.repository.MemoryMemberRepository;
import springhandson.handson.service.MemberService;


//Annotation 대신 Java 코드로 Bean 등록
//Controller 는 Java 코드로 대신할 수 없음
@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
