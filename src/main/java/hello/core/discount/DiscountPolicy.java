package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {

    /**
     *
     * @return 할인 대상 금액 -> 할인된 가격을 리턴
     */
    int discount(Member member, int price);
}
