package hash;

import java.util.HashSet;
import java.util.Set;

public class Duplicates {

    public boolean containsDuplicate(int[] nums){
        Set<Integer> s = new HashSet<>();
        for(int val : nums){
            if(s.contains(val)){
                return true;
            }
            s.add(val);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 1 };
        Duplicates d = new Duplicates();
        System.out.println(d.containsDuplicate(arr));
    }
}
