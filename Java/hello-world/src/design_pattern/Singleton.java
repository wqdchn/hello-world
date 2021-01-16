package design_pattern;

/**
 * @program: hello-world
 * @description: 单例模式
 * @author: wqdong
 * @create: 2020-03-22 19:41
 **/

// 懒汉模式
public class Singleton {

  private static Singleton instance = null;

  private Singleton() {

  }

  // 线程不安全
  public static Singleton getInstanceA() {
    if (instance == null) {
      instance = new Singleton();
    }
    return instance;
  }

  // 线程安全
  public static synchronized Singleton getInstanceB() {
    if (instance == null) {
      instance = new Singleton();
    }
    return instance;
  }
}

//// 懒汉模式
//public class Singleton {
//
//  private static volatile Singleton instance = null;
//
//  private Singleton() {
//
//  }
//
//  // 双重检验
//  public static Singleton getInstance() {
//    if (instance == null) {
//      synchronized (Singleton.class) {
//        if (instance == null) {
//          instance = new Singleton();
//        }
//      }
//    }
//    return instance;
//  }
//
//}
//
//// 饿汉模式，线程安全
//public class Singleton {
//
//  private static Singleton instance = new Singleton();
//
//  private Singleton() {
//
//  }
//
//  public static Singleton getInstance() {
//    return instance;
//  }
//
//}
//
//// 静态内部类实现
//public class Singleton {
//
//  private Singleton() {
//
//  }
//
//  private static class SingletonHolder {
//
//    private static final Singleton sInstance = new Singleton();
//  }
//
//  public static Singleton getInstance() {
//    return SingletonHolder.sInstance;
//  }
//}
//
//// 枚举实现
//
//public enum Singleton {
//  INSTANCE;
//
//  public void doSomeThing() {
//
//  }
//}
