package questions.Twin_Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TwinStrings {


    static boolean twinStrings(String a,String b){

        Map<Character,Integer> evenMap = new HashMap<>();
        Map<Character,Integer> oddMap = new HashMap<>();

        for(int i=0;i<a.length();i++){
            if(i%2==0){
                evenMap.put(a.charAt(i),evenMap.getOrDefault(a.charAt(i),0)+1);
            }
            else{
                oddMap.put(a.charAt(i),oddMap.getOrDefault(a.charAt(i),0)+1);
            }
        }

        for(int i=0;i<b.length();i++){

            if(i%2==0){
                evenMap.put(b.charAt(i),evenMap.getOrDefault(b.charAt(i),0)-1);
            }
            else{
                oddMap.put(b.charAt(i),oddMap.getOrDefault(b.charAt(i),0)-1);
            }
        }
        return evenMap.entrySet().stream().noneMatch(e -> e.getValue() != 0) && oddMap.entrySet().stream().noneMatch(e->e.getValue()!=0);

    }
    public static void main(String[] args) {
        System.out.println(twinStrings("abcd","cbad"));
        System.out.println(twinStrings("abcd","cdab"));
        System.out.println(twinStrings("abcd","acbd"));
    }
}
