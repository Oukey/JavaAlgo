import java.lang.reflect.Array;

class NativeDictionary<T> {
    public int size;
    public String[] slots;
    public T[] values;

    public NativeDictionary(int sz, Class clazz) {
        size = sz;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);
    }

    public int hashFun(String key) {
        // Метод возвращает корректный индекс слота
        return 0;
    }

    public boolean isKey(String key) {
        // Метод проверяет наличие ключа
        return false;
    }

    public void put(String key, T value) {
        // Метод запись key и value в словарь
    }

    public T get(String key) {
        // Метод возврата value по заданному key
        // или null если ключ не найден
        if (isKey(key)) return null;
        else return null;
    }
}