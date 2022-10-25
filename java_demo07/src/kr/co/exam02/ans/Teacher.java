package kr.co.exam02.ans;

public class Teacher extends Person{

    // 메소드 오버로딩
    public String getSubject() {
        if(this.subject.length == 1) {
            return this.subject[0];
        }
        return null;
    }

    // 메소드 오버라이딩
    @Override
    public void setSubject(String subject) {
        if(this.subject.length == 0) {
            this.subject = new String[1];
            this.subject[0] = subject;
        }
    }

}
