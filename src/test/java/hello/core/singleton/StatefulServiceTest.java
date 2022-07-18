package hello.core.singleton;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //ThreadA: A사용자 10000원을 주문
        int userAPrice = statefulService1.order("userA", 10000);
        //ThreadB: B사용자 20000원을 주문
        int userBPrice = statefulService2.order("userB", 20000);

        //ThreadA: 사용자 주문 금액을 조회
//        int price = statefulService1.getPrice();
        System.out.println("price = " + userAPrice); //예상은 10000원이 나와야 하는데 20000원이 나왔다!

//        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(10000);
        Assertions.assertThat(statefulService1).isSameAs(statefulService2);
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}