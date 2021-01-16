package design_pattern;

/**
 * @program: hello-world
 * @description: ����ģʽ
 * @author: wqdong
 * @create: 2020-03-22 19:41
 **/

// ����ģʽ
public class Singleton {

  private static Singleton instance = null;

  private Singleton() {

  }

  // �̲߳���ȫ
  public static Singleton getInstanceA() {
    if (instance == null) {
      instance = new Singleton();
    }
    return instance;
  }

  // �̰߳�ȫ
  public static synchronized Singleton getInstanceB() {
    if (instance == null) {
      instance = new Singleton();
    }
    return instance;
  }
}

//// ����ģʽ
//public class Singleton {
//
//  private static volatile Singleton instance = null;
//
//  private Singleton() {
//
//  }
//
//  // ˫�ؼ���
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
//// ����ģʽ���̰߳�ȫ
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
//// ��̬�ڲ���ʵ��
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
//// ö��ʵ��
//
//public enum Singleton {
//  INSTANCE;
//
//  public void doSomeThing() {
//
//  }
//}
