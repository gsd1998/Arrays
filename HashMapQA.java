package interviewQA;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapQA {
    public static void main(String[] args) {

        // Print the frequency of each word in the sentence
        String sentence = "this is a is is is a a a a sentence this";
        Map<String,Integer> map = wordFrequencies(sentence);
        iterateMapForLoop(map);
        iterateMapWhileLoop(map);
        System.out.println(map);
    }

    public static Map<String, Integer> wordFrequencies(String sentence) {
        HashMap<String, Integer> map = new HashMap<>();
        String[] stringArr = sentence.split("\\s+");
        for(String word : stringArr) {
            Integer wordCount = map.put(word, 1);
            if (wordCount != null){
                wordCount++;
                map.put(word, wordCount);
            }
        }
        return map;
    }

    private static void iterateMapForLoop(Map<String, Integer> map) {

        for(Map.Entry<String,Integer> entry: map.entrySet()){
             System.out.println(entry.getKey() + " :: " + entry.getValue());
        }
    }

    private static void iterateMapWhileLoop(Map<String, Integer> map) {
        Iterator<Map.Entry<String,Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String,Integer> entry = iterator.next();
            System.out.println(entry.getKey() + " :: " + entry.getValue());
        }
    }
    /*
        sentence :: 1
        a :: 5
        this :: 2
        is :: 4

        {sentence=1, a=5, this=2, is=4}
     */

}
