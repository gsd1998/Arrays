package interviewQA;

import java.util.*;
import java.util.stream.*;
import java.util.Map;

public class MappingStream {

    public static void main(String[] args) {

        /*
         * Nth Highest salary from a group of employees using Streams
         * where n = 1,2,3 etc...
         */

        Map<String, Integer> mapper = new HashMap<>();

        mapper.put("anil", 1000);
        mapper.put("bhavna", 1300);
        mapper.put("micael", 1500);
        mapper.put("tom", 1600);
        mapper.put("jerry", 1600);
        mapper.put("ankit", 1200);
        mapper.put("daniel", 1700);
        mapper.put("james", 1400);

        int n=2;

        /* In case if the map doesn't have duplicate values */
        Map.Entry<String, Integer> stringIntegerEntry = mapper.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(Collectors.toList()).get(n - 1);
        System.out.println(stringIntegerEntry);
        //output -> tom=1600

        /* In case if the map has duplicate values
        Note: In the case of duplicate values, the output will be a list of employees with the nth highest salary.
        */
        Map.Entry<Integer, List<String>> integerListEntry = mapper.entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
                .entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .collect(Collectors.toList()).get(n-1);
        System.out.println(integerListEntry);
        //output -> 1600=[tom, jerry]

    }
}
