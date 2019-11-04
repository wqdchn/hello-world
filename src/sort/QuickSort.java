package sort;

/**
 * @program: helloworld
 * @description: 快速排序
 * @author: wqdong
 * @create: 2018-08-22 20:17
 **/
public class QuickSort {

  public static void quicksort(int[] nums, int begin, int end) {// O(nlogn)
    if (begin >= end || nums.length <= 1) {
      return;
    }
    int low = begin;
    int high = end;
    int mid = (low + high) / 2;

    while (low <= high) {
      while (nums[low] < nums[mid]) {
        low++;
      }
      while (nums[high] > nums[mid]) {
        high--;
      }
      if (low < high) {
        int temp = nums[low];
        nums[low] = nums[high];
        nums[high] = temp;
        low++;
        high--;
      } else if (low == high) {
        low++;
      }
    }
    show(nums);
    System.out.print("|| low = " + low + " high = " + high + " || " +
        " begin = " + begin + " end = " + end + " || " +
        " mid = " + nums[mid]);
    System.out.println();
    quicksort(nums, begin, high);
    quicksort(nums, low, end);
  }

  public static void show(int[] num) {
    for (int i = 0; i < num.length; i++) {
      System.out.print(num[i] + " ");
    }
  }

  public static void main(String[] args) {
    int[] nums = {2, 3, 1, 5, 4, 6, 8, 0, 7, 10, 9};
    quicksort(nums, 0, nums.length - 1);

//    2 3 1 5 4 0 8 6 7 10 9 || low = 6 high = 5 ||  begin = 0 end = 10 ||  mid = 0
//    0 1 3 5 4 2 8 6 7 10 9 || low = 2 high = 1 ||  begin = 0 end = 5 ||  mid = 3
//    0 1 3 5 4 2 8 6 7 10 9 || low = 1 high = 0 ||  begin = 0 end = 1 ||  mid = 0
//    0 1 3 2 4 5 8 6 7 10 9 || low = 4 high = 3 ||  begin = 2 end = 5 ||  mid = 2
//    0 1 2 3 4 5 8 6 7 10 9 || low = 3 high = 2 ||  begin = 2 end = 3 ||  mid = 2
//    0 1 2 3 4 5 8 6 7 10 9 || low = 5 high = 4 ||  begin = 4 end = 5 ||  mid = 4
//    0 1 2 3 4 5 7 6 8 10 9 || low = 8 high = 7 ||  begin = 6 end = 10 ||  mid = 8
//    0 1 2 3 4 5 6 7 8 10 9 || low = 7 high = 6 ||  begin = 6 end = 7 ||  mid = 6
//    0 1 2 3 4 5 6 7 8 9 10 || low = 10 high = 9 ||  begin = 8 end = 10 ||  mid = 9
//    0 1 2 3 4 5 6 7 8 9 10 || low = 9 high = 8 ||  begin = 8 end = 9 ||  mid = 8
  }
}
