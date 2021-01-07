import java.lang.reflect.Array;
import java.util.Arrays;

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
        if (capacity > 0) {

//            new_capacity = new_capacity < 16 ? 16 : new_capacity;
            new_capacity = Math.max(new_capacity, 16);

            array = Arrays.copyOf(array, new_capacity);
        } else {
            array = (T[]) Array.newInstance(this.clazz, new_capacity);
        }
        capacity = new_capacity;
    }

    public void display() {
        for (T t : array) System.out.print(t + " ");
//        for (int i = 0; i < array.length; i++)
//            System.out.print(this.array[i] + " ");
        System.out.println();
        System.out.println("capacity: " + capacity);
        System.out.println("count: " + count);
    }

    public T getItem(int index) {
        // Получение объекта по его индексу
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Некорректное обращение по индексу");
        }
        return array[index];
    }

    public void append(T itm) {
        // Добавление нового элемента itm в конец динамического массива
        if (count >= capacity) {
            makeArray(capacity * 2);
        }
        array[count] = itm;
        count++;
    }

    public void insert(T itm, int index) {
        // Вставка объекта itm в заданную позицию с учетом размера буфера
        if (index < 0 || index > count) {
            throw new ArrayIndexOutOfBoundsException("Некорректно указан индекс");
        }
        if (index == count) append(itm);
        else {
            if (count + 1 > capacity) {
                makeArray(capacity * 2);
            }
            System.arraycopy(array, index, array, index + 1, count - index);
            array[index] = itm;
            count++;
        }
    }

    public void remove(int index) {
        // Удаление элемента из заданной позиции

        if (count == 0) {
            throw new ArrayIndexOutOfBoundsException("Некорректная операция для пустого массива");
        }
        if (index < 0 || index > count - 1) {
            throw new ArrayIndexOutOfBoundsException("Некорректно указан индекс");
        }
        array[index] = null;

        if (count - 1 - index >= 0) System.arraycopy(array, index + 1, array, index, count - 1 - index);

        array[count - 1] = null;
        count--;

        if ((double) count / capacity < 0.5)
            makeArray((int) (capacity / 1.5));
    }
}