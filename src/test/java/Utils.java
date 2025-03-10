import java.util.Random;

import static java.lang.Math.abs;

public class Utils {

    static Random random = new Random();

    static String randomEmail() {
        return "c_" + abs(random.nextInt()) + "@ya.ru";
    }

    static String randomName() {
        return "n_" + abs(random.nextInt());
    }

    static String randomPassword() {
        return "p_" + abs(random.nextInt());
    }
}
