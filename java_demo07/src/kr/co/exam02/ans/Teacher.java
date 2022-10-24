package kr.co.exam02.ans;

public class Teacher extends Person{

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        super.setSubject(subject, 1);
    }

}
