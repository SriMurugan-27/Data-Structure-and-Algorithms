package algorithms;

import java.util.HashMap;
import java.util.Map;
public class FirstNonRepeatingCharacter {

    public static int firstNonRepeat(String str){
        Map<Character, Integer> m = new HashMap<>();
        char[] chars = str.toCharArray();

        for(char ch : chars){
            m.put(ch, m.getOrDefault(ch, 0) + 1);
        }

        for(int i = 0; i < chars.length; i++){
            char ch = chars[i];

            if(m.get(ch) == 1){
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String[] str = { "codeforcode", "aabb" };

        for(String s : str){
            System.out.println(firstNonRepeat(s));
        }
    }
}
