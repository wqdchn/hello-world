package sort;

/**
 * @program: hello-world
 * @description: 选择排序
 * @author: wqdong
 * @create: 2018-08-23 20:19
 **/
public class SelectSort {

    public static void selectsort(int[] nums){//选择排序，每次把最小值放到当前轮的第一位
        for (int i=0;i<nums.length;i++){
            int min = i;
            for (int j=i+1;j<nums.length;j++){
                if(nums[min]>nums[j]){
                    min = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;
            show(nums);
            System.out.println("第"+i+"趟结果");
        }
    }

    public static void show(int[] num){
        for (int i = 0;i<num.length;i++){
            System.out.print(num[i]+" ");
        }
    }

    public static void main(String[] args){

        int[] nums = {2,3,-2,11,40,23,-56,23,21};
        selectsort(nums);
    }
}
