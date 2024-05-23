package algorithms;

import java.util.HashMap;
import java.util.Map;

public class LongestSubString {

    public static int lengthOfLongestSubstring(String str){
        Map<Character, Integer> m = new HashMap<>();
        int maxLength = 0;
        int left = 0;

        for(int right = 0; right < str.length(); right++){
            char ch = str.charAt(right);
            if(m.containsKey(ch)){
                left = Math.max(left, m.get(ch) + 1);
            }
            m.put(ch, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String[] str = { "abcabccbb", "bbbb", "pwwkew" };

        for(String s : str){
            System.out.println(lengthOfLongestSubstring(s));
        }
    }

}
