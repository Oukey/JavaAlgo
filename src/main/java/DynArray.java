public class DynArray<T> {
    public T[] array;
    public int count;
    public int capacity;
    Class clazz;

    public DynArray(Class clz) {
        clazz = clz; // нужен для безопасного приведения типов
        // new DynArray<Integer>(Integer.class);

        count = 0;
        makeArray(16);
    }

    public void makeArray(int new_capacity) {
        // Формирование блока памяти заданного размера
        // array = (T[]) Array.newInstance(this.clazz, new_capacity);
        // ваш код
    }

    public T getItem(int index) {
        // Получение объекта по его индексу

        return null;
    }

    public void append(T itm) {
        // Добавление нового элемента itm в конец динамического массива

    }

    public void insert(T itm, int index) {
        // Вставка объекта itm в заданную позицию

    }

    public void remove(int index) {
        // Удаление элемента из заданной позиции
    }

}