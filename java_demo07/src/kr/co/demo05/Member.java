package kr.co.demo05;

public interface Member {

    String ROLE = "MEMBER";     // 필드명을 모두 대문자로 적으면 static final로 잡힌다.

    void write();       // public abstract는 작성하지 않아도 public abstract로 설정된다.
    void view();
    void update();
    void remove();
}
