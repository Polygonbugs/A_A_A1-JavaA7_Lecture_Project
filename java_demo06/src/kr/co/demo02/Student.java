package kr.co.demo02;

class Student {
    private String name;
    private int age;
    private int grade = 1;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;

        if(age == 14) {
            this.grade = 1;
        } else if(age == 15) {
            this.grade = 2;
        } else if(age == 16) {
            this.grade = 3;
        } else {
            this.grade = -1;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public int getGrade() {
        return this.grade;
    }



}
