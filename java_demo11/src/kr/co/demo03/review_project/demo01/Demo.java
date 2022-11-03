package kr.co.demo03.review_project.demo01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Demo {
    public static void main(String[] args) {
        /*
         *      컬렉션
         *          - 자바에서 제공하는 자료구조를 담당하는 프레임워크
         *          - 배열에 데이터를 담아 관리하는 방법에서 좀 더 편하게 데이터를
         *            추가/수정/삭제 할 수 있는 방법을 제공
         *          - 구현된 자료 구조 종류에 따라 List, Set, Map으로 분류하여 제공
         *
         *      배열 vs 컬렉션
         *      - 배열의 특징
         *          - 한 번 크기를 정하면 변경할 수 없다.
         *          - 배열에 저장된 데이터의 추가 / 수정이 불편하다
         *          - 한 가지 타입에 대해서만 저장할 수 있다. (객체 형태 제외)
         *
         *      - 컬렉션의 특징
         *          - 언제든 크기를 늘리거나 줄일 수 있다.
         *          - 컬렉션에 저장된 데이터의 추가 / 수정 / 삭제 등의 작업이
         *            컬렉션에서 제공하는 기본 메서드에 의해 처리된다.
         *          - 여러 타입에 대한 데이터 저장이 가능하다.
         */

        /*
         *      List 컬렉션
         *          - 데이터를 순차적으로 나열한 자료구조로 인데스를 통해 관리한다.
         *          - 중복 데이터 저장이 가능하다
         *          - 구현 클래스로 ArrayList, Vector, LinkedList가 있다.
         *
         *      - ArrayList
         *          - List의 구현체로 초기 저장 용량 10에서 데이터가 추가/삭제 될 때마다
         *           자동으로 늘어나면서 데이터를 관리한다.
         *          - Thread Safe 기능을 제공하지 않는다. (단일 쓰레드 작업시에 좋다)
         *
         *      - Vector
         *          - List의 구현체로 ArrayList와 동일하다
         *          - Thread Safe 기능을 제공한다. (멀티쓰레드 사용할 때는 이용하면 좋다, 단일 쓰레드를 쓸 경우 느리다)
         *
         *      - LinkedList
         *          - List의 구현체로 특정 위치에서 객체를 추가하거나 제거를 하면 앞/뒤
         *            노드의 링크 정보만 변경하는 형태로 동작하기 때문에 빈번한 데이터 추가
         *            삭제 작업이 이루어지는 경우 성능이 가장 우수한 컬렉션이다.
         */

        ArrayList<Integer> aList = new ArrayList<Integer>(); // <>(제네릭 타입) : 컬렉션으로 관리할 데이터 타입을 작성한다.

        // 데이터 추가 : 가장 마지막 순서에 추가.
        aList.add(10); aList.add(20); aList.add(30);
        aList.add(40); aList.add(50); aList.add(60);
        System.out.println(aList);

        // 데이터 추가 : 원하는 위치에 추가
        aList.add(1, 40);
        System.out.println(aList);

        // 데이터 변경 : 지정한 위치의 데이터 변경
        aList.set(2, 25);
        System.out.println(aList);

        // 데이터 삭제 : 지정한 위치의 데이터 삭제
        aList.remove(2);
        System.out.println(aList);

        // 데이터 삭제 : 지정한 객체와 동일한 데이터 삭제. 객체를 찾아서 지울 수 있다.
        aList.remove(Integer.valueOf(40));
        System.out.println(aList);

        // 데이터 검색 : 지정한 위치의 데이터 반환
        Integer i = aList.get(2);
        System.out.println(i + " | " + aList);

        // 데이터 검색 : 지정한 객체와 동일한 객체가 있는지 검사
        boolean isExists = aList.contains(Integer.valueOf(60));
        System.out.println(isExists + " | " + aList);

        // 데이터 검색 : 지정한 객체와 동일한 객체의 위치 반환
        int index = aList.indexOf(Integer.valueOf(60));
        System.out.println(index + " | " + aList);

        // 저장된 데이터 갯수 확인
        int size = aList.size();
        System.out.println(size + " | " + aList);

        // 데이터 추가 : 컬렉션에 컬렉션 데이터를 추가
        ArrayList<Integer> bList = new ArrayList<Integer>();
        bList.add(100); bList.add(200); bList.add(300);

        aList.addAll(bList);
        System.out.println(aList);

        bList.set(0, 150); bList.set(1, 250); bList.set(2, 350);
        System.out.println(aList);

        // 데이터 삭제 : 전부 삭제
        bList.clear();
        System.out.println(bList);

        // 데이터 존재 유무 확인
        boolean isEmpty = aList.isEmpty();
        System.out.println(isEmpty + " | " + aList);

        isEmpty = bList.isEmpty();
        System.out.println(isEmpty + " | " + bList);

        // 전체 탐색
        // 기존 for 문 이용 : 하나 하나 배열의 형태로 확인 하는
        for(int n = 0; n < aList.size(); n++) {
            System.out.print(aList.get(n) + "\t");
            aList.set(n, aList.get(n)+10);
        }

        System.out.println();
        System.out.println(aList);

        // for-each 형태로 전체 탐색
        // 리스트 자체를 받아서 저장
        // 접근은 가능하지만 수정은 할 수 없다.
        for(Integer n : aList) {
            System.out.print(n + "\t");
            n = n + 10;
        }

        System.out.println();
        System.out.println(aList);

        // 리스트를 분리하여 새로운 리스트로 반환
        ArrayList<Integer> subList = new ArrayList<Integer>(aList.subList(2, 5));
        System.out.println(subList);

        // 리스트를 제공한 배열로 반환
        Integer iArr[] = new Integer[aList.size()];
        iArr = aList.toArray(iArr);
        System.out.println(Arrays.toString(iArr));

        // 정렬 - reverse - 역정렬하여 저장
        Collections.reverse(aList);
        System.out.println(aList);

        // 정렬 - sort - 오름차순으로 정렬하여 저장
        Collections.sort(aList);
        System.out.println(aList + "test");

        // 정렬 - sort후 revers하면 내림차순으로 저장
        // Collections.sort(aList);
        // Collections.reverse(aList);
        // System.out.println(aList);

        // 직접 정렬 위한 로직 구현
        Collections.sort(aList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 > o2) {
                    return -1;
                } else if(o1 < o2) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        System.out.println(aList);

        ArrayList<Subject> sList = new ArrayList<Subject>();

        sList.add(new Subject("과학", 78.5));
        sList.add(new Subject("국어", 94.2));
        sList.add(new Subject("수학", 89.3));
        sList.add(new Subject("영어", 88.5));

        System.out.println(sList);

        Collections.sort(sList);
        Collections.reverse(sList);

        System.out.println(sList);
    }
}
