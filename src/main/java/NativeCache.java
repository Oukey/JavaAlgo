import java.lang.reflect.Array;

class NativeCache<T> {
    public int size;
    public String[] slots;
    public T[] values;
    public int[] hits;

    public NativeCache(int size, Class clazz) {
        this.size = size;
        hits = new int[size];
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);
    }

    public int minHits() {
        // Метод возвращает индекс самого непопулярного элемента
        int index = 0;
        for (int i = 1; i < size; i++)
            if (hits[index] > hits[i]) {
                index = i;
            }
        return index;
    }

    public int hashFunc(String key) {
        int code = 0;
        byte[] arrayB = key.getBytes();
        for (byte i : arrayB) {
            code += i;
        }
        return code % this.size;
    }


    public int isKey(String key) {
        // Метод поиска свободного слота
        // при не неудаче возвращает -1
        int slot = hashFunc(key);
        int mark = slot;
        while (this.slots[slot] != null && !this.slots[slot].equals(key)) {
            slot = (slot + 1) % this.size;
            if (slot == mark) return -1;
        }
        return slot;
    }

    public void put(String key, T value) {
        // Метод записи ключа и значения
        // если нет свободных мест и ключ ранее не встречался -
        // перезаписываются элементы самого непопулярного слота
        int slot = this.isKey(key);
        if (slot == -1) {
            slot = this.minHits();
        }
        this.slots[slot] = key;
        this.values[slot] = value;
        this.hits[slot] = 1;
    }

    public T get(String key) {
        // Метод получения значения по запросу ключа
        // фиксируется количество запросов по ключу
        int slot = this.isKey(key);
        if (slot != -1) {
            this.hits[slot]++;
            return this.values[slot];
        }
        return null;
    }

    public void display() {
        System.out.println("Slots:");
        for (int i = 0; i < size; i++) {
            System.out.print("| " + slots[i] + " ");
        }
        System.out.println("|");
        System.out.println("Values");
        for (int i = 0; i < size; i++) {
            System.out.print("| " + values[i] + " ");
        }
        System.out.println("|");
    }


}