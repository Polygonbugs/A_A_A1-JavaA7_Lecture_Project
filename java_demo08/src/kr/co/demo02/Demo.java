package kr.co.demo02;

public class Demo {
    public static void main(String[] args) {
        /*
         *      StringBuilder / StringBuffer
         *      성능적인 부분에서 좋다.
         */

        StringBuilder sb = new StringBuilder(128);
        sb.append("문자열");
        sb.append(" 추가");
        System.out.println(sb.toString());

        /*String str = "문자열";
        str += "추가";
        System.out.println(str);*/

        // capacity() : StringBuilder 내부에서 사용되는 배열 크기를 증가시킨다.
        int capacity = sb.capacity();
        System.out.println(capacity);

        // delete() : 문자열 삭제
        sb.delete(0, 3);
        System.out.println(sb.toString() + "/" + sb.capacity());

        // insert() : 지정한 위치의 문자열을 추가한다.
        sb.insert(0, "문자열");
        System.out.println(sb.toString());

        sb.insert(4, "insert()");
        System.out.println(sb.toString());

        // length() : 문자열 길이
        int length = sb.length();
        System.out.println(length);

        // reverse() : 문자열을 역순으로 나열하여 저장한다.
        sb.reverse();
        System.out.println(sb.toString());

        // setLength() : 문자열 길이를 임의로 늘린다.
        sb.setLength(30);
        sb.reverse();
        System.out.println(sb.toString());

        // trimToSize() : StringBuilder 내부에서 할당된 배열 크기에서 사용하지 않는 곳을 삭제한다.
        sb.trimToSize();
        System.out.println(sb.capacity());

        // sb.indexOf(), sb.replace(), sb.charAt(), sb.compareTo(), sb.substring()
        // 위 메서드는 기존 String 클래스에서 사용한 메서드와 동일한 기능을 수행
    }
}
