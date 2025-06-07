package Functional;

import java.util.*;

public class HashMapFunctions {
    public static void main(String[] args) {
        // Map 생성 및 데이터 추가
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 100);
        map.put("banana", 200);
        map.put("cherry", 300);

        // 키와 값을 배열로 변환 (Object[] 사용)
        Object[] keys = map.keySet().toArray();
        Object[] values = map.values().toArray();

        // 출력
        System.out.println("Keys:");
        for (Object key : keys) {
            System.out.println(key);
        }

        System.out.println("\nValues:");
        for (Object value : values) {
            System.out.println(value);
        }
    }
}
