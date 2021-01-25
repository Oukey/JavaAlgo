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
        return 0;
    }

    public int seekSlot(String value) {
        // Метод поиска индекса пустого слота для значения, или -1
        return -1;
    }

    public int put(String value) {
        // Метод записи значения по индексу от хэш-функции
        // возвращается индекс слота или -1
        // если из-за коллизий элемент не удаётся разместить
        return -1;
    }

    public int find(String value) {
        // Метод проверки наличия указанного значения
        // Возвращает индекс или -1
        return -1;
    }
}