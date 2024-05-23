package algorithms;

import java.util.Set;

public class RemoveVowels {

    public static String remove(String str){
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();

        for(char ch : chars){
            if(!vowels.contains(ch)){
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(remove("what is your name?"));
    }
}
