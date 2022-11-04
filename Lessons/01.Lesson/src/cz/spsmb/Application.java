package cz.spsmb;

import cz.spsmb.source.DeclaredMethodList;
import cz.spsmb.source.LicenceServer;
import cz.spsmb.source.PrivateField;
import cz.spsmb.source.Singleton;
import java.lang.reflect.*;

public class Application {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        privateorpublic();
        takePass();
        singletonMoment();
        LicenceHackMoment();

    }

    public static void privateorpublic(){
        Method[] methods = DeclaredMethodList.class.getDeclaredMethods();
        for (Method method : methods) {
            if (Modifier.isPublic(method.getModifiers())) {
                System.out.println("public metoda:" + method.getName());
            } else {
                System.out.println("Private methods:" + method.getName());
            }
        }
    }

    public static void takePass() {
        try {
            PrivateField test = new PrivateField();
            Field[] fields = PrivateField.class.getDeclaredFields();
            for(Field field : fields) {
                field.setAccessible(true);

                String value = (String) field.get(test);
                System.out.println("Name: " + value);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }


    }

    public static void singletonMoment() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Constructor<Singleton> field = Singleton.class.getDeclaredConstructor();
        field.setAccessible(true);
        field.newInstance();
        field.newInstance();
        Singleton.getSingleton();
        Singleton.getSingleton();
        Singleton.getSingleton();

        //Singleton single = new

    }

    public static void LicenceHackMoment(){
        try {
            LicenceServer test = new LicenceServer();

            Method method = LicenceServer.class.getDeclaredMethod("checkValidLicense", String.class);

            method.setAccessible(true);

            method.invoke(test, "https://www.google.com");

            LicenceServer.startGame();
        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }
}
