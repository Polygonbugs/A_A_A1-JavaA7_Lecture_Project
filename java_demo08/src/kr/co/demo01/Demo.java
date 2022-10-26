package kr.co.demo01;

import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        /*
         *      String 관련 클래스
         *          - String : 문자열 클래스로 문자열 데이터를 다루기 위해 사용한다.
         *                     수정 불가능(불변타입)한 타입으로써 데이터 수정시 원본 데이터를
         *                     복사하여 새로운 데이터를 만드는 형태로 동작한다.
         *
         *          - StringBuilder : 문자열 클래스로 String의 불변타입을 변경가능으로
         *                            사용할 수 있게 만들어진 클래스이다.
         *                            (Thread safe 기능을 제공하지 않는다.)
         *
         *          - StringBuffer : StringBuilder 동일한 기능이 클래스로 유일한 차이는
         *                           Thread safe 기능을 제공하는 것이다.
         *                           Thread safe 기능은 다중 쓰레드 작업에 활용될 때 공유 자원에 대한
         *                           안정성을 높여 주기 위한 기능이다.
         */

        // 문자열 생성 방법
        String str1 = "문자열 리터럴을 사용하여 생성";
        String str2 = new String("new 연산자로 문자열 생성");

        char ch[] = new char[] {'문', '자', '배', '열'};
        String str3 = new String(ch);

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);

        // charAt(index) : 특정 위치에 있는 문자를 반환하는 메서드
        for(int i = 0; i < str1.length(); i++) {
            char c1 = str1.charAt(i);
            System.out.printf("str1.charAt(%d) -> %c\n", i, c1);
        }

        int count = 0;
        for(int i = 0; i < str1.length(); i++) {
            if(str1.charAt(i) == ' ') {
                count++;
            }
        }

        System.out.printf("이 문자열에는 공백이 %d개 있습니다.\n", count);

        // codePpintAt() : 문자 유니코드값을 반환하는 메서드
        int point = str1.codePointAt(0);
        System.out.printf("%d -> %c\n", point, (char)point);

        str1 = new String("가가나가");
        str2 = new String("가가가나");
        // str1.compareTo(str2) : str1, str2 문자열의 유니코드 값으로 두 문자열을 비교한다.
        // - 값이 나오면 str1이 사전적으로 앞에 있는 문자열이다.
        // + 값이 나오면 str2가 사전적으로 앞에 있는 문자열이다.
        // 문자열 정렬 할 때등에 사용가능하다.
        int compare = str1.compareTo(str2);
        System.out.println(compare);

        compare = str2.compareTo(str1);
        System.out.println(compare);

        compare = str2.compareTo(str2);
        System.out.println(compare);

        System.out.println(str1.codePointAt(0) + "-" + str2.codePointAt(0));
        System.out.println(str2.codePointAt(0) + "-" + str1.codePointAt(0));

        // str1.concat(str2) : str1 문자열을 str2와 결합하여 반환한다.
        str1 = new String("가");
        str2 = new String("나");
        str3 = str1.concat(str2);

        System.out.println(str3);

        // str1.contains(문자열) : 문자열 안에 매개변수로 전달한 문자열이 포함되어 있는지에 대한
        //                         유무를 반환하는 메서드
        str1 = new String("contains 메서드 예제");
        boolean res1 = str1.contains("메서드");
        boolean res2 = str1.contains("안녕하세요");
        System.out.println(res1 + "/" + res2);

        // contentEquals() : 동일한 문자열 내용을 가지고 있는지에 대한 유무를 반환하는 메서드
        //                   Thread safe 기능이 사용되고 있어서 성능 저하가 발생할 수 있다. (멀티쓰레드에서만 유용)
        str1 = new String("contentEquals 메서드 예제");
        res1 = str1.contentEquals("contentEquals 메서드 예제");
        res2 = str1.contentEquals("contentEquals");
        System.out.println(res1 + "/" + res2);

        // endsWith(), startsWith() : 문자열에서 특정 문자열로 끝(ends)나거나 시작(start)
        //                            하는지에 대한 유무를 반환하는 메서드.
        str1 = new String("endsWith(), startsWith() 메서드 예제");
        res1 = str1.endsWith("예제");
        res2 = str1.startsWith("end");
        System.out.println(res1 + "/" + res2);

        // equalsIgnoreCase() : 대소문자 구분을 무시하고 동일한 문자열이닞에 대한 유무를
        //                      반환하는 메서드
        str1 = new String("Hello");
        res1 = str1.equalsIgnoreCase("HELLO");
        res2 = str1.equalsIgnoreCase("hello");
        System.out.println(res1 + "/" + res2);

        // indexOf : 매개변수로 전달한 문자열의 위치를 찾아 해당하는 index 값을 반환하는 메서드
        str1 = new String("indexOf 메서드 메서드 메서드 메서드사용 예제로 이 메서드는 메서드 오버로딩이 되어있습니다.");
        int index = str1.indexOf("메서드");
        System.out.println(index);
        index = str1.indexOf("메서드", 9);
        System.out.println(index);
        index = str1.indexOf("메서드", 22);
        System.out.println(index);
        index = str1.indexOf("메서드", 27);
        System.out.println(index);

        // 문자열에서 특정 문자열이 몇개 존재하는지 찾으시오.

        int idx = 0;
        count = 0;
        while(true) {
            idx = str1.indexOf("메서드", idx);
            if(idx == -1) {
                break;
            }
            idx++; count++;
        }
        System.out.println("메서드 문자열은 총 " + count + " 개 있습니다.");

        // isBlank(), isEmpty() : 빈 문자열인지 유무를 반환하는 메서드
        //          isBlank()는 공백도 빈 문자열로 판단하지만
        //          isEmpty()는 공백은 빈 문자열로 판단하지 않는다.
        //
        str1 = new String("");
        res1 = str1.isBlank();
        res2 = str1.isEmpty();
        System.out.println(res1 + "/" + res2);

        str1 = new String(" ");
        res1 = str1.isBlank();
        res2 = str1.isEmpty();
        System.out.println(res1 + "/" + res2);

        str1 = new String("\n");
        res1 = str1.isBlank();
        res2 = str1.isEmpty();
        System.out.println(res1 + "/" + res2);

        // lines() : 문자열에서 개행을 기준으로 문자열을 분리하여 반환하는 메서드.
        //           운영체제에 따른 개행을 고려하지 않아도 된다.
        str1 = new String("11 버전에서\n새로 생긴\nline()\n메서드");
        Stream<String> stream = str1.lines();
        Object[] objArr = stream.toArray();
        for(int i = 0; i < objArr.length; i++) {
            String s = (String)objArr[i];
            System.out.println(i + 1 + " 번 줄\t" + s);
        }

        // split() : 문자열에서 특정 문자를 기준으로 분리하여 문자열 배열 반환하는 메서드
        str1 = new String("11 버전에서\n새로 생긴\nline()\n메서드");
        String[] strArr = str1.split("\\n");

        for(int i =0 ; i < strArr.length; i++) {
            System.out.println(i + 1 + " 번 줄\t" + strArr[i]);
        }

        // repeat() : 문자열을 반복해서 복사하여 문자열로 반환하는 메서드
        str1 = new String("Hello");
        str2 = str1.repeat(2);
        System.out.println(str2);

        // replace() : 문자열을 특정 문자열로 변경하여 반환하는 메서드
        str1 = new String("문자열을 변경하기 위해 사용하는 문자열 메서드");
        str2 = str1.replace("문자열", "String");
        System.out.println(str2);

        // strip() : 문자열을 기준으로 앞, 뒤의 공백을 삭제하여 문자열로 반환하는 메서드
        str1 = new String("     문자열 앞 뒤로 공백이 있으면 제거     ");
        str2 = str1.strip();
        System.out.println("|" + str2 + "|");
        str2 = str1.stripLeading();
        System.out.println("|" + str2 + "|");
        str2 = str1.stripTrailing();
        System.out.println("|" + str2 + "|");

        // trim()
        str2 = str1.trim();
        System.out.println("|" + str2 + "|");

        // substring() : 문자열 특정 부분만 잘라내어 문자열로 반환한다.
        str1 = new String("문자열 일부만 잘라내기");
        str2 = str1.substring(0, 3);
        System.out.println(str2);
        str2 = str1.substring(4, 7);
        System.out.println(str2);
        str2 = str1.substring(4);
        System.out.println(str2);

        // toLowrCase(), toUpperCase() : 소문자로 구성된 문자열을 반환하는 메서드, 대문자로 구성된 문자열을 반환하는 메서드
        str1 = new String("Hello");
        str2 = str1.toLowerCase();
        System.out.println(str2);
        str2 = str1.toUpperCase();
        System.out.println(str2);

        // String.format("포맷문자열", 값...);
        str1 = String.format("%s / %d / %f", "문자열 포맷", 30, 3.0);        // 정적 메서드(클래스 메서드) : 인스턴스를 사용하지 않아도 사용가능
        System.out.println(str1);

        // String.join("구문문자", 문자열배열);
        // String.join("구문문자", 문자열1, 문자열2, ...);
        str1 = String.join(",", new String[] {"A", "B", "C", "D"});
        System.out.println(str1);

        str1 = String.join("_", "A", "B", "C", "D");
        System.out.println(str1);

        // String.valueOf(다양한 데이터 값)
        str1 = String.valueOf(true);
        System.out.println(str1);
        str1 = String.valueOf(10);      // 이게 더 빠르게 동작할 수 있다.
        System.out.println(str1);
        str1 = "" + 10;
        System.out.println(str1);
    }
}
