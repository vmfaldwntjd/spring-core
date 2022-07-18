package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void autowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {

        @Autowired(required = false) //스프링 컨테이너가 관리하고 있지 않은 객체를 넣어주었다.
        public void setNoBean1(Member noBean1) {
            System.out.println("noBean1 = " + noBean1);
        } //이 메서드는 의존관계가 아예 없으므로 호출을 아예 안한다.

        @Autowired //이건 호출이 된다. 대신 null로 들어온다.
        public void setNoBean2(@Nullable Member noBean2) {
            System.out.println("noBean2 = " + noBean2);
        }

        @Autowired //자바 파일에서 제공해주는 문법이다. 값이 없으면 Optional.empty가 출력된다.
        public void setNoBean3(Optional<Member> noBean3) {
            System.out.println("noBean3 = " + noBean3);
        }
    }

}
