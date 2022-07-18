package hello.core.singleton;

public class SingletonService {
    //static 지정에 의해서 딱 하나만 자기 자신의 객체가 생성된다. instance에 저장된 상태.
    private static final SingletonService instance = new SingletonService();
    //자기 자신 인스턴스 조회용 -> 다른 인스턴스에서 조회하려면 이 메서드만 호출해서 조회하도록 설정
    public static SingletonService getInstance() {
        return instance;
    }
    //다른 클래스에서 이 객체를 생성 못하도록 하기 위해서 private지정.
    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
