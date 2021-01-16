
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void  swap(int a,int b){
        int x = a;
        a = b;
        b = x;

    }

    //一些语法实验
    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");
        int x = Integer.MAX_VALUE;
        double y = 20.2002;
        long z = 10L;
        System.out.println(x + 2);
        String str = "" + x + y * z;
        System.out.println(str);
        System.out.println(String.format("%.2f", 1.1 * 1.1));
        short s1 = 1;
        long t = 10L;
        String a = new String("A");

        String aa = new String("A");

        System.out.println(a.hashCode() + "" + aa.hashCode());

        if (a == aa) {
            System.out.println("true");
        }
        switch (a) {
            case "A":
                System.out.println(a + 1);
        }


        int q = 1;
        int p = 2;
        swap(q,p);
        System.out.println("q ="+q+" p ="+p);

        if (0.1 + 0.2 == 0.3) {
            System.out.println("yes");
        }

        System.out.println(400 >> 2);

        String getting = "你好啊";

        getting = "Not Good";

        System.out.println(getting);
        System.out.println(getting.charAt(2));
        System.out.println(getting.codePointCount(1, 4));

        StringBuilder bu = new StringBuilder();

        bu.append("测试");
        bu.append("工程师");

        System.out.println(bu);

        File f = new File("F:\\Documents\\testfile.txt");

        Scanner in = new Scanner(f, "UTF-8");

        while (in.hasNext()) {
            bu.append(in.next());
        }
        System.out.println(bu);

/*        check:
        for(int i=0;i<20;i++){
            if(i>18){
                break check;
            }
        }*/
        String[] trs = {"bus", "bike", "airport", "car"};
        for (String s : trs) {
            System.out.println(s);
        }

        //不规则数组
        int NMAX = 2;
        int[][] odds = new int[NMAX + 1][];
        for (int n = 0; n <= NMAX; n++) {
            odds[n] = new int[n + 1];
        }

        for (int n = 0; n < odds.length; n++) {
            for (int k = 0; k < odds[n].length; k++) {
                odds[n][k] = 1;
                for (int[] row : odds) {
                    for (int odd : row)
                        System.out.printf("%4d", odd);
                        System.out.println();
                }
            }
        }
    }
}