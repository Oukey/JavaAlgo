import java.util.BitSet;

public class BloomFilter {
    public int filter_len;
    public BitSet bitSet;
//    public int bitAr;

    public BloomFilter(int f_len) {
        filter_len = f_len;
        // Создание битового массива длиной f_len ...
        bitSet = new BitSet(f_len);
//        bitAr = 0;
    }

    // хэш-функции
    public int hash1(String str1) {
        // 17
        int result = 0;
        for (int i = 0; i < str1.length(); i++) {
            int code = (int) str1.charAt(i);
            result = (code * 17 + code) % filter_len;
        }
//        return 1 << result;
        return result;
    }

    public int hash2(String str1) {
        // 223
        int result = 0;
        for (int i = 0; i < str1.length(); i++) {
            int code = (int) str1.charAt(i);
            result = (code * 223 + code) % filter_len;
        }
//        return 1 << result;
        return result;
    }

    public void add(String str1) {
        // Метод добавления строки str1 в фильтр
        bitSet.set(hash1(str1));
        bitSet.set(hash2(str1));
//        bitAr = bitAr | hash1(str1) | hash2(str1);
    }

    public boolean isValue(String str1) {
        // Метод проверки наличия строка str1 в фильтре
        return bitSet.get(hash1(str1)) && (bitSet.get(hash2(str1)));
//        int mask = hash1(str1) | hash2(str1);
//        return mask == (bitAr & mask);
    }
}
