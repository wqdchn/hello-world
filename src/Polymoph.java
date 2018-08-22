/**
 * @program: helloworld
 * @description: 多态
 * @author: wqdong
 * @create: 2018-08-17 20:38
 **/

class animal{
    private  String name;

    animal(String name){
       this.name = name;
    }

    public void fun(){
        System.out.println("动物的叫声.....");
    }

}

class cat extends animal{
    private String eyecolor;

    cat(String n,String c){
        super(n);
        eyecolor = c;
    }

    @Override
    public void fun() {
        System.out.println("动物的叫声...喵喵喵");
    }
}

class dog extends animal{
    private  String furcolor;

    dog(String n,String f){
        super(n);
        furcolor = f;
    }

    @Override
    public void fun() {
        System.out.println("动物的叫声...汪汪汪");
    }
}

class lady {
    private String name;
    private animal pet;

    lady(String name,animal pet){
        this.name = name;
        this.pet = pet;
    }

    public void ladyfun(){
        pet.fun();
    }

}
public class Polymoph {
    public static void main(String[] args){
        cat c = new cat("小橘","blue");
        dog d = new dog("小黑","black");

        lady l1 = new lady("bai",c);
        lady l2 = new lady("li",d);

        l1.ladyfun();
        l2.ladyfun();


    }


}
