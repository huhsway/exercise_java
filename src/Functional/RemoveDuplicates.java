package Functional;

import java.util.*;
public class RemoveDuplicates {
    public static void main(String[] args) {
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(Arrays.asList(1, 2, 3));
        answer.add(Arrays.asList(1, 2, 3));

        List<List<Integer>> uniqueLists = removeDuplicates(answer);
        System.out.println(uniqueLists);
    }

    public static List<List<Integer>> removeDuplicates(List<List<Integer>> lists) {
        Set<List<Integer>> set = new HashSet<>(lists);
        return new ArrayList<>(set);
    }
}
