package search;

/**
 * @program: hello-world
 * @description: 二分查找
 * @author: wqdong
 * @create: 2020-02-20 17:25
 **/
public class bin_search {

  public static void main(String[] args) {
    int[] nums = {1, 2, 5, 6, 7, 9, 13, 16, 23, 25};
    int key = 13;

    System.out.println(bin_search(nums, key));

    nums = new int[]{1, 2, 5, 6, 7, 9, 9, 13, 13, 16, 23, 25};
    key = 13;
    System.out.println(bin_search_first_index(nums, key));
    System.out.println(bin_search_last_index(nums, key));

    key = 15;
    System.out.println(bin_search_close_index(nums, key));
  }

  // 若有则返回数组下标，若无则返回-1
  public static int bin_search(int[] nums, int key) {
    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {
      int mid = left + ((right - left) / 2);
      if (nums[mid] > key) {
        right = mid - 1;
      } else if (nums[mid] < key) {
        left = mid + 1;
      } else {
        return mid;
      }
    }
    return -1;
  }

  // 返回第一次出现的时候的数组下标，若无则返回-1
  public static int bin_search_first_index(int[] nums, int key) {
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = left + ((right - left) / 2);
      if (nums[mid] >= key) {
        right = mid - 1;
      } else if (nums[mid] < key) {
        left = mid + 1;
      }
    }
    return nums[right + 1] == key ? right + 1 : -1;
  }

  // 返回最后一次出现的时候的数组下标，若无则返回-1
  public static int bin_search_last_index(int[] nums, int key) {
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = left + ((right - left) / 2);
      if (nums[mid] > key) {
        right = mid - 1;
      } else if (nums[mid] <= key) {
        left = mid + 1;
      }
    }
    return nums[left - 1] == key ? left - 1 : -1;
  }

  // 返回最接近key且大于key数组下标，若无则返回-1
  public static int bin_search_close_index(int[] nums, int key) {
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = left + ((right - left) / 2);
      if (nums[mid] > key) {
        right = mid - 1;
      } else if (nums[mid] <= key) {
        left = mid + 1;
      }
    }
    return nums[right + 1] > key ? right + 1 : -1;
  }
}
