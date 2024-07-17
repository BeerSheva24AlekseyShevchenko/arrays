package telran.util.test;

import java.nio.charset.Charset;
import java.util.Random;

public class RandomArray {
    private final static int STRING_VALUE_LENGTH = 20;

    private int length;

    public RandomArray(int length) {
        this.length = length;
    }

    public int[] createInt() {
        return createInt(length);
    }

    public int[] createInt(int length) {
        int[] res = new int[length];

        Random random = new Random();

        for(int i = 0; i < length; i++) {
            res[i] = random.nextInt();
        }

        return res;
    }

    public Integer[] createInteger() {
        return createInteger(length);
    }

    public Integer[] createInteger(int length) {
        Integer[] res = new Integer[length];

        Random random = new Random();

        for(int i = 0; i < length; i++) {
            res[i] = Integer.valueOf(random.nextInt());
            
        }
    
        return res;
    }

    public String[] createString() {
        return createString(length);
    }

    public String[] createString(int length) {
        String[] res = new String[length];

        Random random = new Random();

        for(int i = 0; i < length; i++) {
            byte[] chars = new byte[STRING_VALUE_LENGTH];
            random.nextBytes(chars);
            res[i] = new String(chars, Charset.forName("UTF-8"));
            
        }

        return res;
    }
}
