package sort;

/**
 * @program: hello-world
 * @description: 归并排序
 * @author: wqdong
 * @create: 2018-08-28 21:13
 **/
public class MergeSort {

  public static void mergesort(int[] arr) {//O(nlogn) 迭代
    int len = arr.length;
    int[] result = new int[len];
    int block, start;

    // 原版代码的迭代次数少了一次，没有考虑到奇数列数组的情况
    for (block = 1; block < len; block *= 2) {
      for (start = 0; start < len; start += 2 * block) {

        int low = start;
        int mid = (start + block) < len ? (start + block) : len;
        int high = (start + 2 * block) < len ? (start + 2 * block) : len;

        //两个块的起始下标及结束下标
        int start1 = low, end1 = mid;
        int start2 = mid, end2 = high;

        //开始对两个block进行归并排序
        while (start1 < end1 && start2 < end2) {
          result[low++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        }
        while (start1 < end1) {
          result[low++] = arr[start1++];
        }
        while (start2 < end2) {
          result[low++] = arr[start2++];
        }
      }
      int[] temp = arr;
      arr = result;
      result = temp;
      show(result);
    }
    result = arr;
  }

  public static void mergesort1_sort(int[] nums, int low, int high) {//O(nlogn) 递归，分治
    int mid = (low + high) / 2;
    if (low < high) {
      mergesort1_sort(nums, low, mid);
      mergesort1_sort(nums, mid + 1, high);
      mergesort1_merge(nums, low, mid, high);
    }
  }

  private static void mergesort1_merge(int[] nums, int low, int mid, int high) {
    int[] temp = new int[high - low + 1];
    int i = low;
    int j = mid + 1;
    int k = 0;

    while (i <= mid && j <= high) {
      if (nums[i] <= nums[j]) {
        temp[k++] = nums[i++];
      } else {
        temp[k++] = nums[j++];
      }
    }

    while (i <= mid) {
      temp[k++] = nums[i++];
    }
    while (j <= high) {
      temp[k++] = nums[j++];
    }

    for (int k2 = 0; k2 < temp.length; k2++) {
      nums[k2 + low] = temp[k2];
    }
    show(nums);
  }

  public static void show(int[] num) {
    for (int i = 0; i < num.length; i++) {
      System.out.print(num[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int[] nums = {2, 3, 1, 5, 4, 6, 8, 0, 7, 9, 10};
    mergesort(nums);

    System.out.println("#########################");

    nums = new int[]{2, 3, 1, 5, 4, 6, 8, 0, 7, 9, 10};
    mergesort1_sort(nums, 0, nums.length - 1);
  }
}
