package sort;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @program: hello-world
 * @description: Õ∞≈≈–Ú
 * @author: wqdong
 * @create: 2020-03-19 14:07
 **/
public class BucketSort {

  public static void bucket_sort(int[] nums) {

    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    for (int num : nums) {
      max = Math.max(max, num);
      min = Math.min(min, num);
    }

    int bucketSize = (max - min) / nums.length + 1;

    ArrayList<ArrayList<Integer>> buckets = new ArrayList<>();
    for (int i = 0; i < bucketSize; i++) {
      buckets.add(new ArrayList<Integer>());
    }

    for (int i = 0; i < nums.length; i++) {
      int num = (nums[i] - min) / nums.length;
      buckets.get(num).add(nums[i]);
    }

    for (int i = 0; i < buckets.size(); i++) {
      Collections.sort(buckets.get(i));
    }

    System.out.println(buckets.toString());

    int idx = 0;
    for (int i = 0; i < bucketSize; i++) {
      ArrayList<Integer> bucket = buckets.get(i);
      for (int k : bucket) {
        nums[idx] = k;
        idx++;
      }
    }

  }

}
