package sort;

/**
 * @program: hello-world
 * @description: 希尔排序
 * @author: wqdong
 * @create: 2018-08-26 20:54
 **/
public class ShellSort {

    public static void shellsort(int[] n){
        int step = n.length / 2;
        int i = 0;
        int j = 0;
        int temp = 0;
        while (step >= 1) {//步长大于1时
            for (i = step; i < n.length; i++) {
                temp = n[i];//当前位置的值
                j = i - step;
                while (j >= 0 && n[j] > temp) {//距离当前位置步长为step的值
                    n[j + step] = n[j];
                    j = j - step;
                }
                n[j + step] = temp;
                show(n);
                System.out.println();
            }
            step = step / 2;
        }

    }

    public static void show(int[] num){
        for (int i = 0;i<num.length;i++){
            System.out.print(num[i]+" ");
        }
    }

    public static void main(String[] args){
        int[] nums = {2,3,-2,11,40,23,-56,23,21};
        shellsort(nums);
    }
}
