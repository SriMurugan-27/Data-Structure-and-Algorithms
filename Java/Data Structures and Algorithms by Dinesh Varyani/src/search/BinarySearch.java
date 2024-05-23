package search;

public class BinarySearch {
    private int search(int[] nums, int x){
        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            /*int mid = (low + high) / 2;*/
            int mid = low + ((high - low) / 2);
            if(nums[mid] == x)  return mid;
            if(nums[mid] < x){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 10, 20, 47, 59, 65, 75, 88, 99 };
        BinarySearch bs = new BinarySearch();
        System.out.println(bs.search(nums, 65));
    }
}
