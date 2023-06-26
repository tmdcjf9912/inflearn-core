package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan( //@Component 애너테이션이 붙은 클래스를 찾아서 자동으로 스프링빈으로 등록해줌
        basePackages = "hello.core.member",  //hello.core.member 이 위치부터 찾아보기 시작함(탐색할 패키지 시작위치 지정, 여러개 지정가능)
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)   //그중에서 뺄거를 미리 지정해줌
)
public class AutoAppConfig {

    @Bean(name = "memoryMemberRepository")
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

}
