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
        return searchNull();
    }

    public boolean isKey(String key) {
        // Метод проверяет наличие ключа
        for (int ind = 0; ind < size; ind++) {
            if (slots[ind] != null) {
                if (slots[ind].equals(key)) return true;
            }
        }
        return false;
    }

    public void put(String key, T value) {
        // Метод запись key и value в словарь
        if (!isKey(key)) {
            int index = hashFun(key);
            if (index >= 0 && index < size) {
                slots[index] = key;
                values[index] = value;
            }
        }
    }

    public T get(String key) {
        // Метод возврата value по заданному key
        // или null если ключ не найден
        if (isKey(key)) {
            int index = 0;
            while (index < size - 1) {
                if (slots[index].equals(key)) {
                    break;
                }
                index++;
            }
            return values[index];
        } else return null;
    }

    public int searchNull() {
        for (int i = 0; i < size; i++) {
            if (slots[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public void Show() {
        System.out.print("Key: [");
        for (int ind = 0; ind < size - 1; ind++) {
            System.out.print(slots[ind] + ", ");
        }
        System.out.println(slots[size - 1] + "]");

        System.out.print("Value: [");
        for (int ind = 0; ind < size - 1; ind++) {
            System.out.print(values[ind] + ", ");
        }
        System.out.println(values[size - 1] + "]");

    }
}