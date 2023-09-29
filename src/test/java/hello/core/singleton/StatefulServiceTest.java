package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Testconfig.class);
        StatefulService statefulService1= ac.getBean(StatefulService.class);
        StatefulService statefulService2= ac.getBean(StatefulService.class);

        // Thread A : A사용자 1만원 주문
        int userA = statefulService1.order("userA", 10000);
        // Thread B : B사용자 2만원 주문
        int userB = statefulService2.order("userB", 20000);

        // Thread A : 사용자A 주문 금액 조회
//        int price = statefulService1.getPrice();
        System.out.println("price = " + userA);

        Assertions.assertThat(userA).isEqualTo(10000);

    }

    static class Testconfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }



}