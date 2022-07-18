package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService(); //여기서 뭘 달라고 할지 정해진다.

        //이 코드에 의해서 AppConfig에서 스프링 적용한 내용들이 스프링 컨테이너에 들어가게 된다. 그리고 appConfig에서 memberService를 호출하는 방식을 썼는데
        //이제 스프링 컨테이너에서 찾아서 쓸 것이다.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);//appConfig에 있는 메서드 이름을 첫 인자로 넣어주고, 두 번째는 타입을 넣어준다.

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}
