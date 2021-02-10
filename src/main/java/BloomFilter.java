public class BloomFilter {
    public int filter_len;
    byte[] bits;

    public BloomFilter(int f_len) {
        filter_len = f_len;
        // Создание битового массива длиной f_len ...
        bits = new byte[f_len];
    }

    // хэш-функции
    public int hash1(String str1) {
        // 17
        int result = 0;
        for (int i = 0; i < str1.length(); i++) {
            int code = (int) str1.charAt(i);
            result = (result * 17 + code) % filter_len;
        }
        return result;
    }

    public int hash2(String str1) {
        // 223
        int result = 0;
        for (int i = 0; i < str1.length(); i++) {
            int code = (int) str1.charAt(i);
            result = (code + result) * 223 % filter_len;
        }
        return result;
    }

    public void add(String str1) {
        // Метод добавления строки str1 в фильтр
        bits[hash1(str1)] = 1;
        bits[hash2(str1)] = 1;
    }

    public boolean isValue(String str1) {
        // Метод проверки наличия строка str1 в фильтре
        return bits[hash1(str1)] == 1 && bits[hash2(str1)] == 1;
    }
}