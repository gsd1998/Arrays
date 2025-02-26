package interviewQA;

import java.util.HashMap;
import java.util.Map;

public class DuplicateCharacters {
    public static void main(String[] args) {

        String str = "hello world";
        String spaceRemovedStr = str.replaceAll("\\s+","");
        System.out.println(spaceRemovedStr);
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        char[] chArr = spaceRemovedStr.toCharArray();
        for(char ch : chArr) {
            Integer count = map.put(ch, 1);
            if(count != null){
                map.put(ch, (count+1));
            }
        }
        System.out.println(map); //{r=1, d=1, e=1, w=1, h=1, l=3, o=2}
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            if(entry.getValue() > 1){
                System.out.print(entry.getKey() + " ");
            }
        }
        //helloworld => l o  `duplicate characters in the String`
    }
}
