package sort;

/**
 * @program: hello-world
 * @description: 归并排序
 * @author: wqdong
 * @create: 2018-08-28 21:13
 **/
public class MergeSort {

    public static void mergesort(int[] arr){
        int len = arr.length;
        int[] result = new int[len];
        int block, start;

        // 原版代码的迭代次数少了一次，没有考虑到奇数列数组的情况
        for(block = 1; block < len; block *= 2) {
            for(start = 0; start <len; start += 2 * block) {
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
                while(start1 < end1) {
                    result[low++] = arr[start1++];
                }
                while(start2 < end2) {
                    result[low++] = arr[start2++];
                }
            }
            int[] temp = arr;
            arr = result;
            result = temp;
        }
        result = arr;

        show(result);
    }

    public static void show(int[] num){
        for (int i = 0;i<num.length;i++){
            System.out.print(num[i]+" ");
        }
    }

    public static void main(String[] args){

        int[] nums = {2,3,-2,11,40,23,-56,23,21};
        mergesort(nums);
    }
}
