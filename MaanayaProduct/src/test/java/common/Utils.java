package common;

public class Utils {

    public static String generateUniqueEmail() {
        long timestamp = System.currentTimeMillis();
        return "Panda" + timestamp + "@gmail.com";
    }
}
