package kr.co.demo03;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        /*
         *      Map 계열 컬렉션
         *          - 키(Key)와 값(Value)으로 구성되어 있으며, 키와 값 모두 객체이다.
         *          - 키에 대해서는 중복 저장을 허용하지 않으며, 값은 중복 저장이 가능하다.
         *          - 구현 클래스로 HashMap, HashTable, Properties 등이 있다.
         *
         *      HashMap
         *          - 키 객체는 hashCode()와 equals()를 재정의해 동등 객체가 될 조건을 정해야 한다.
         *          - 키는 주로 String 객체를 사용한다.
         *
         *      HashTable
         *          - HashMap과 동일하고 Thread Safe 기능을 지원한다.
         *
         *      Properties
         *          - 키와 값을 String 타입으로 제한한 Map 컬렉션.
         *          - 주로 프로퍼티 파일을 읽어 그 안의 속성을 프로그램에서 사용할 수 있게
         *            만들기 위해 쓰인다.
         *          - 프로퍼티 파일은 주로 어플리케이션이 동작하는 과정에서 어플리케이션 초기
         *            동작에 필요한 값이나 설정갑을 변경하여 내부 동작이 다르게 이루어 질 수 있도록
         *            하기 위한 용도로 사용하는 파일이다.
         *            (어플리케이션이 처음 동작할 때 데이터베이스 연결과 관련된 프로퍼티 파일을
         *             읽어서 연결을 시도.)
         */

        HashMap<String, Integer> aMap = new HashMap<String, Integer>();

        // 데이터를 추가
        aMap.put("A", Integer.valueOf(10));
        aMap.put("B", Integer.valueOf(20));
        aMap.put("C", Integer.valueOf(30));
        aMap.put("D", Integer.valueOf(40));
        System.out.println(aMap);

        aMap.put("A", Integer.valueOf(50));
        System.out.println(aMap);

        aMap.put("E", Integer.valueOf(50));
        System.out.println(aMap);

        // 데이터 검색
        Integer i1 = aMap.get("A");
        System.out.println(i1);

        boolean isExists = aMap.containsKey("A");
        System.out.println(isExists);

        isExists = aMap.containsValue(Integer.valueOf(60));
        System.out.println(isExists);

        // 컬렉션에 저장된 데이터 수
        int size = aMap.size();
        System.out.println(size);

        // 모든 키 반환
        Set<String> keyset = aMap.keySet();
        System.out.println(keyset);

        // 모든 값 반환
        Collection<Integer> values = aMap.values();
        System.out.println(values);

        // 키와 값의 쌍을 모두 반환 : EntrySet
        Set<Map.Entry<String, Integer>> entrySet = aMap.entrySet();
        System.out.println(entrySet);

        for(Map.Entry<String, Integer> e : aMap.entrySet()) {
            System.out.print(e.getKey() + ":");
            System.out.print(e.getValue() + "\t");
        }
        System.out.println();
        // 데이터 삭제
        aMap.remove("A");
        System.out.println(aMap);

    }
}
