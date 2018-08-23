package sort;

/**
 * @program: helloworld
 * @description: 快速排序
 * @author: wqdong
 * @create: 2018-08-22 20:17
 **/
public class QuickSort {

    public static void quicksort(int[] num,int begin,int end){
        if (begin>=end||num.length<=1){
            return;
        }
        int low = begin;
        int high = end;
        int mid = num[(low+high)/2];//基准
        while (low<=high){
            while (num[low]<mid){
                low++;
            }
            while (num[high]>mid){
                high--;
            }
            if (low<high){
                int temp = num[low];
                num[low] = num[high];
                num[high] = temp;
                low++;
                high--;
            }else if (low==high){
                low++;
            }
        }
        quicksort(num,begin,high);
        quicksort(num,low,end);
        show(num);
    }

    public static void show(int[] num){
        for (int i = 0;i<num.length;i++){
            System.out.print(num[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        int[] number = {100,-10,23,56,2,-4,9,15,15,17,100};
        quicksort(number,0,number.length-1);
    }
}
