package algorithms;

public class SubSequence {

    public static boolean isSubSeq(String word, String target){
        int i = 0;
        int j = 0;

        while(i < word.length() && j < target.length()){
            if(word.charAt(i) == target.charAt(j)){
                j++;
            }
            i++;
        }

        return j == target.length();
    }

    public static void main(String[] args) {
        String str = "abcde";
        String sequence = "ace";

        System.out.println(isSubSeq(str, sequence));
    }
}
