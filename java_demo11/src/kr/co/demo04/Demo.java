package kr.co.demo04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Demo {
    public static void main(String[] args) {
        /*
         *  컬렉션에 컬렉션을 넣어서 사용하기
         */

        ArrayList<HashMap<String, Double>> datas = new ArrayList<HashMap<String, Double>>();
        Random rand = new Random();

        for(int i = 0; i < 5; i++) {
            HashMap<String, Double> hashData = new HashMap<String, Double>();
            hashData.put("국어", Double.valueOf((double)rand.nextInt(40) + 60));
            hashData.put("영어", Double.valueOf(rand.nextInt(40) * 1.0 + 60));
            hashData.put("수학", Double.valueOf(rand.nextInt(40) * 1.0 + 60));
            hashData.put("사회", Double.valueOf(rand.nextInt(40) * 1.0 + 60));
            hashData.put("과학", Double.valueOf(rand.nextInt(40) * 1.0 + 60));
            hashData.put("체육", Double.valueOf(rand.nextInt(40) * 1.0 + 60));
            hashData.put("미술", Double.valueOf(rand.nextInt(40) * 1.0 + 60));
            datas.add(hashData);
        }

        System.out.println(datas);

        /*
         *  ArrayList를 전체 탐색하면서 HashMap에 있는 모든 Key, Value에 접근하여
         *  평균 및 총점을 구하고 해당하는 HashMap에 추가하기.
         */

        for(HashMap<String, Double> map : datas) {
            double sum = 0;
            double avg = 0;
            for(Map.Entry<String, Double> e : map.entrySet()) {
                sum += e.getValue();
            }
            avg = sum / map.size();
            map.put("총합", Double.valueOf(sum));
            map.put("평균", Double.valueOf(avg));
        }
        System.out.println(datas);
    }
}
