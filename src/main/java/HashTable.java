import java.util.ArrayList;
import java.util.Arrays;

public class HashTable {
    public int size;
    public int step;
    public String[] slots;

    public HashTable(int sz, int stp) {
        size = sz;
        step = stp;
        slots = new String[size];
        for (int i = 0; i < size; i++) slots[i] = null;
    }

    public int hashFun(String value) {
        // Хэш-функция, которая возвращает корректный индекс слота
        return searchNull();
    }

    public int seekSlot(String value) {
        // Метод поиска индекса пустого слота для значения
        // Возвращает номер индекса или -1 при неудаче
        return searchNull();
    }

    public int put(String value) {
        // Метод записи значения по индексу от хэш-функции
        // возвращается индекс слота или -1
        // если из-за коллизий элемент не удаётся разместить
        int index = seekSlot(value);
        if (index != -1) {
            slots[index] = value;
            return index;
        }
        return -1;
    }

    public int find(String value) {
        // Метод проверки наличия указанного значения
        // Возвращает индекс или -1
        if (slots[0] == null) return -1;
        for (int i = 0; i < size; i++) {
            if (slots[i].equals(value)) {
                return i;
            }
        }
        return -1;
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
        System.out.print("[");
        for (int ind = 0; ind < size - 1; ind++) {
            System.out.print(slots[ind] + ", ");
        }
        System.out.println(slots[size - 1] + "]");
    }
}