package springhandson.handson;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springhandson.handson.aop.TimeTraceAop;
import springhandson.handson.repository.JpaMemberRepository;
import springhandson.handson.repository.MemberRepository;
import springhandson.handson.repository.MemoryMemberRepository;
import springhandson.handson.service.MemberService;

//Annotation 대신 Java 코드로 Bean 등록
//Controller 는 Java 코드로 대신할 수 없음
@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;
    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //private EntityManager em;
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

    @Bean
    public TimeTraceAop() {
        return new TimeTraceAop();
    }

    /*@Bean
    public MemberRepository memberRepository() {
        // return new MemoryMemberRepository();
        //return new JpaMemberRepository(em);

    }*/
}
