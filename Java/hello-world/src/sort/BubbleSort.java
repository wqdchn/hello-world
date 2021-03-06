package sort;

/**
 * @program: hello-world
 * @description: 冒泡排序
 * @author: wqdong
 * @create: 2018-08-24 07:19
 **/
public class BubbleSort {

  public static void bubblesort(int[] nums) {//O（n^2）

    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = 0; j < nums.length - 1 - i; j++) {
        if (nums[j] > nums[j + 1]) {
          int temp = nums[j + 1];
          nums[j + 1] = nums[j];
          nums[j] = temp;
        }
        show(nums);
        System.out.println();
      }
    }
  }

  public static void bubblesort1_1(int[] nums) {//O（n^2）优化一

    for (int i = 0; i < nums.length - 1; i++) {
      boolean needswap = false;
      for (int j = 0; j < nums.length - 1 - i; j++) {
        if (nums[j] > nums[j + 1]) {
          int temp = nums[j + 1];
          nums[j + 1] = nums[j];
          nums[j] = temp;
          needswap = true;
        }
        show(nums);
        System.out.println();
      }
      if (needswap != true) {
        break;
      }
    }
  }

  public static void bubblesort1_2(int[] nums) {//O（n^2）优化一
    boolean needswap = false;
    int len = nums.length;
    do {
      len--;
      needswap = false;
      for (int i = 0; i < len; i++) {
        if (nums[i] > nums[i + 1]) {
          int temp = nums[i + 1];
          nums[i + 1] = nums[i];
          nums[i] = temp;
          needswap = true;
        }
        show(nums);
        System.out.println();
      }
    } while (needswap);
  }

  public static void bubblesort2(int[] nums) {//O（n^2）优化二

    int last_exchange_index = 0;
    int need_swap_border = nums.length - 1;
    for (int i = 0; i < nums.length - 1; i++) {
      boolean needswap = false;
      for (int j = 0; j < need_swap_border; j++) {
        if (nums[j] > nums[j + 1]) {
          int temp = nums[j + 1];
          nums[j + 1] = nums[j];
          nums[j] = temp;
          needswap = true;
          last_exchange_index = j;
        }
        show(nums);
        System.out.println();
      }
      need_swap_border = last_exchange_index;
      if (needswap != true) {
        break;
      }
    }
  }

  public static void show(int[] num) {
    for (int i = 0; i < num.length; i++) {
      System.out.print(num[i] + " ");
    }
  }

  public static void main(String[] args) {
    int[] nums = {2, 3, 1, 5, 4};
    bubblesort(nums);//冒泡排序

    System.out.println("#########################");

    nums = new int[]{2, 3, 1, 5, 4};
    bubblesort1_1(nums);//优化一

    System.out.println("#########################");

    nums = new int[]{2, 3, 1, 5, 4};
    bubblesort1_2(nums);//优化一

    System.out.println("#########################");

    nums = new int[]{2, 3, 1, 5, 4};
    bubblesort2(nums);//优化二
  }
}
