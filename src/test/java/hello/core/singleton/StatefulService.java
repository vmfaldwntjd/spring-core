package hello.core.singleton;

public class StatefulService {

    //private int price; //상태를 유지하는 필드

    public int order(String name, int price) { //가격을 저장해놓는 메소드
        System.out.println("name = " + name + " price = " + price);
        //this.price = price; //여기가 문제가 된다!
        return price;
    }

//    public int getPrice() {
//        return price;
//    }
}
