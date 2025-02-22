package cz.spsmb.source;

public class Singleton {

    private static int instanceCount;
    private static Singleton singleton;

    public static Singleton getSingleton() {
        if (singleton == null){
            Singleton.singleton = new Singleton();
        }
        return singleton;
    }

    public static int getInstanceCount() {
        return instanceCount;
    }

    private Singleton() {
        if (singleton != null){
            throw new RuntimeException("Bruh");
        }
        Singleton.instanceCount++;
        System.out.println(instanceCount);
    }

    public String getMessage() {
        return "Hello";
    }

}
