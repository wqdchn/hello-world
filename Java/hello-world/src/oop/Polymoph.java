package oop;

/**
 **/

class animal{
    private  String name;

    animal(String name){
       this.name = name;
    }

    public String getName(){
        return  name;
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
        System.out.println("动物的名字是："+name);
    }

}
public class Polymoph {
    public static void main(String[] args){
        cat c = new cat("小橘","blue");
        animal d = new animal("小白");
        d = new dog("小黑","black");

        lady l1 = new lady(c.getName(),c);
        lady l2 = new lady(d.getName(),d);

        l1.ladyfun();
        l2.ladyfun();


    }


}
