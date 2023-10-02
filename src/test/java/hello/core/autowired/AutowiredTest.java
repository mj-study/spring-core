package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
//        ac.getBean()
    }

    static class TestBean{
        // Member는 springBean이 아님
        @Autowired(required = false)     // 호출 x
        public void setNoBean1(Member member) {
            System.out.println("member = " + member);
        }

        @Autowired
        public void setNoBean2(@Nullable Member member2) { // 없으면 null로 반환
            System.out.println("member2 = " + member2);
        }

        @Autowired
        public void setNoBean3(Optional<Member> member3) { // 없으면 Optional.empty로 반환
            System.out.println("member3 = " + member3);
        }

    }

}
