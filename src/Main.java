public class Main {

    //一些语法实验
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int x = Integer.MAX_VALUE ;
        double y = 20.2002 ;
        long z = 10L;
        System.out.println(x+2);
        String str = "" + x + y * z ;
        System.out.println(str) ;
        System.out.println(String.format("%.2f",1.1*1.1));
        short s1 = 1;
        long t = 10L;
        String a = new String("A");

        String aa = new String("A");

        System.out.println(a.hashCode()+""+aa.hashCode());

        if(a==aa){
            System.out.println("true");
        }
        switch (a){
            case "A":
                System.out.println(a+1);
        }

        if(0.1+0.2==0.3){
            System.out.println("yes");
        }
    }
}
