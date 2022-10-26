package kr.co.demo05;

public class MemberStaff extends Person implements Staff {
    @Override
    public void notice() {
        System.out.println("notice 동작");
    }

    @Override
    public void block() {
        System.out.println("block 동작");
    }

    @Override
    public void write() {
        System.out.println("write 동작");
    }

    @Override
    public void view() {
        System.out.println("view 동작");
    }

    @Override
    public void update() {
        System.out.println("update 동작");
    }

    @Override
    public void remove() {
        System.out.println("remove 동작");
    }
}
