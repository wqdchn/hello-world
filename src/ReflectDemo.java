import java.lang.reflect.Method;

public class ReflectDemo {
    public static void main(String[] args){
        Person P = new Person();
        try {
            Class c = Class.forName("Person");
            Object o = c.newInstance();
            Method method = c.getMethod("fun", String.class, int.class);
            method.invoke(o, "tengj", 10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}