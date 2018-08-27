import javafx.beans.binding.ObjectExpression;

import java.lang.reflect.*;
import java.util.Arrays;

/**
 * 反射
 */

public class ReflectDemo {
    public static void main(String[] args){
        Person p = new Person();
        try {
            Class c = Class.forName("Person");
            Class c1 = p.getClass();
            Object o = c.newInstance();//动态地创建一个类的实例
            Object o1 = c1.newInstance();
            Method method = c.getMethod("fun", String.class, int.class);
            method.invoke(o, "小白", 10);

            printFields(c1);
            System.out.println();
            printMthods(c1);
            System.out.println();
            printConstructors(c1);


            System.out.println();
            int[] a = {1,2,3,4,5,6,7,8,9,0};
            a = (int[]) goodCopyOf(a,15);

            for (int i : a){
                System.out.print(i+" ");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object goodCopyOf(Object a,int newLength){
        Class c1 = a.getClass();
        if(c1.isArray()!=true){
            return null;
        }
        Class componenType = c1.getComponentType();
        int length = Array.getLength(a);
        Object newArray = Array.newInstance(componenType,newLength);
        System.arraycopy(a,0,newArray,0,Math.min(length,newLength));
        return  newArray;
    }

    public static void printFields(Class c1){
        Field[] fields = c1.getDeclaredFields();
        for (Field f : fields) {
            Class type = f.getType();
            String name = f.getName();
            System.out.print(" ");
            String modifiers = Modifier.toString(f.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.println(type.getName()+";");
        }

    }

    public static void printMthods(Class c1){
        Method[] methods = c1.getDeclaredMethods();
        for (Method m : methods){
            Class retTyoe = m.getReturnType();
            String name = m.getName();

            System.out.print(" ");
            String modifiers = Modifier.toString(m.getModifiers());
            if (modifiers.length()>0){
                System.out.print(modifiers+" ");
            }
            System.out.print(retTyoe.getName()+" "+name+"(");
            Class[] paramTypes = m.getParameterTypes();

            for (int j=0;j<paramTypes.length;j++){
                if (j>0){
                    System.out.print(", ");
                }
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }

    public static void printConstructors(Class c1){
        Constructor[] constructors = c1.getConstructors();

        for (Constructor c : constructors){
            String name = c.getName();
            System.out.print(" ");
            String modifiers = Modifier.toString(c.getModifiers());
            if(modifiers.length()>0){
                System.out.print(modifiers+" ");
            }
            System.out.print(name+"(");

            Class[] paramTypes = c.getParameterTypes();
            for (int j=0;j<paramTypes.length;j++){
                if(j>0){
                    System.out.print(",");
                }
                System.out.print(paramTypes[j].getName());
            }
            System.out.print(");");
        }
    }
}