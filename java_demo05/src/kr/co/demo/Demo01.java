package kr.co.demo;

public class Demo01 {
    public static void main(String[] args) {
        /*
         *    배열(Array)
         *      동일한 자료형을 변수 공간에 담아서 사용할 수 있게 만들어주는 것
         *      저장된 값마다 인덱스가 부여되며, 인덱스 번호는 0 부터 시작한다.
         *
         *    배열 선언
         *      int 변수명[];
         *      int[] 변수명;
         *
         *    배열 초기화
         *      int[] 변수명 = new int[배열크기];
         *      int[] 변수명 = {값1, 값2, 값3};
         *
         *    배열크기는 변수 공간에 담을 데이터의 수로 작성하면 된다.
         *
         *    배열 공간만 생성하는 경우 모든 공간은 기본값으로 초기화 되어 있다.
         *      정수 -> 0
         *      실수 -> 0.0
         *      불린 -> false
         *      문자열 -> null
         *
         *    배열 공간의 크기를 알기 위해서는 length 속성을 사용한다.
         *
         *    배열에 저장된 값을 추출하거나 할당하기 위해서 인덱스를 활용한다.
         *      변수명[인덱스]
         *
         *    배열은 한 번 크기가 정해지면 변경할 수 없다. (고정 크기 배열)
         *
         *    동적으로 배열의 크기를 변경하기 위해서는 동적 배열을 사용해야 한다.
         *    (동적 배열은 기존 배열을 새로운 배열로 대체하는 형태로 만들어 사용)
         */

        int arr1[] = new int[3];        // 배열 공간만 생성
        int arr2[] = {1, 2, 3, 4, 5, 6};         // 공간 생성 후 지정된 값으로 초기화
        int arr3[] = new int[] {1, 2, 3, 4};     // 공간 생성 후 지정된 값으로 초기화

        double arr4[] = new double[3];
        boolean arr5[] = new boolean[3];
        String arr6[] = new String[3];

        System.out.println(arr2.length);

        // 배열의 모든 값을 10으로 초기화
        for(int i = 0; i < arr2.length; i++) {
            arr2[i] = 10;
        }

        // 배열의 모든 값을 탐색하여 출력
        for(int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + "\t");
        }
        System.out.println();

        System.out.println(arr3);

        /*
         *      배열 복사
         *          - 얕은 복사 : 참조 주소만을 복사하여 사용하는 형태
         *                      참조 주소만 복사를 했기 때문에 실제로 사용하는 데이터는 동일하다.
         *
         *          - 깊은 복사 : 참조 주소 위치에 있는 값을 새로운 공간을 만들어서
         *                      복사를 하고 새로 만들어진 공간의 주소를 사용하는 형태
         */

        int arr7[] = new int[3];
        int arr8[] = arr7;
        int arr9[] = new int[3];

        // 얕은 복사 후 arr7 값 변경
        arr7[0] = 10;
        System.out.println(arr7[0]);
        System.out.println(arr8[0]);

        // 깊은 목사
        for(int i = 0; i < arr9.length; i++) {
            arr9[i] = arr7[i];
        }

        // 깊은 복사 후 arr7 값 변경
        arr7[0] = 20;
        System.out.println(arr7[0]);
        System.out.println(arr9[0]);



    }
}
