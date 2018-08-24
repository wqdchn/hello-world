package sort;

/**
 * @program: hello-world
 * @description: 冒泡排序
 * @author: wqdong
 * @create: 2018-08-24 07:19
 **/
public class BubbleSort {

    public static void bubblesort(int[] nums){//O（n^2）

        for (int i=0;i<nums.length-1;i++){
            for (int j=0;j<nums.length-1-i;j++){
                if(nums[j]>nums[j+1]){
                    int temp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = temp;
                 }
                 show(nums);
                 System.out.println();
            }
        }
    }

    public static void bubblesort2(int[] nums){
        boolean needswap = false;
        int len = nums.length;
        do {
            len --;
            needswap = false;
            for (int i=0;i<len;i++){
                if(nums[i]>nums[i+1]){
                    int temp = nums[i+1];
                    nums[i+1] = nums[i];
                    nums[i] = temp;
                    needswap = true;
                }
                show(nums);
                System.out.println();
            }
        }while (needswap);
    }

    public static void show(int[] num){
        for (int i = 0;i<num.length;i++){
            System.out.print(num[i]+" ");
        }
    }

    public static void main(String[] args){
        int[] nums = {2,3,-2,11,40,23,-56,23,21};
        bubblesort(nums);
        System.out.println("#########################");
        int[] nums2 = {2,3,-2,11,40,23,-56,23,21};
        bubblesort2(nums2);
    }
}
