package sort;

/**
 * @program: hello-world
 * @description: 插入排序
 * @author: wqdong
 * @create: 2018-08-25 16:40
 **/
public class InsertSort {

    public static void insertsort(int[] n){
        for (int i=1;i<n.length;i++){
            int temp = n[i];
            int j = i-1;
            while(j>=0&&n[j]>temp){
                n[j+1] = n[j];
                j--;
            }
            n[j+1] = temp;
            show(n);
            System.out.println();
        }
    }

    public static void show(int[] num){
        for (int i = 0;i<num.length;i++){
            System.out.print(num[i]+" ");
        }
    }
    public static void main(String[] args){
        int[] nums = {2,3,-2,11,40,23,-56,23,21};
        insertsort(nums);
    }
}
