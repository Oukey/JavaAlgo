import java.util.ArrayList;

public class PowerSet {
    public ArrayList set;
    public int count;

    public PowerSet() {
        // реализация хранилища`
        set = new ArrayList();
//        count = 0;
    }

    public int size() {
        // Метод возвращает количество элементов в множестве
        return set.size();
//        return count;
    }

    public void put(String value) {
        // Метод добавления уникального нового элемента
        if (!get(value)) {
            set.add(value);
        }
    }

    public boolean get(String value) {
        // Метод проверки вхождения в множество
        // возвращает true если value имеется в множестве,
        // иначе false
//        return set.contains(value);
        for (Object elem : set) {
            if (elem.equals(value)) return true;
        }
        return false;
    }

    public Object getToIndex(int index) {
        // Вспомогательный метод возвращает значение элемента по индексу
        return set.get(index);
    }

    public boolean remove(String value) {
        // Метод удаления из множества
        // возвращает true если value удалено
        // иначе false
        return set.remove(value);
    }

    public PowerSet intersection(PowerSet set2) {
        // Метод пересечения текущего множества и set2
        PowerSet result = new PowerSet();
        for (Object elem : set) {
            if (set2.get((String) elem)) {
                result.put((String) elem);
            }
        }
        return result;
    }

    public PowerSet union(PowerSet set2) {
        // Метод объединяет текущее множество и set2
        PowerSet result = new PowerSet();
        for (Object elem : set) {
            result.put((String) elem);
        }
        for (int ind = 0; ind < set2.size(); ind++) {
            result.put((String) set2.getToIndex(ind));
        }
        return result;
    }

    public PowerSet difference(PowerSet set2) {
        // Метод возвращают разницу текущего множества и set2
        PowerSet result = new PowerSet();
        for (Object elem : set) {
            if (!set2.get((String) elem)) result.put((String) elem);
        }
        return result;
    }

    public boolean isSubset(PowerSet set2) {
        // Метод проверки вхождения подмножества
        // возвращает true, если set2 есть
        // подмножество текущего множества,
        // иначе false
        for (int ind = 0; ind < set2.size(); ind++) {
            if (!set.contains(set2.getToIndex(ind))) return false;
        }
        return true;
    }

    public void show() {
        System.out.print("[");
        for (Object elem : set) {
            System.out.print(" " + elem);
        }
        System.out.println(" ]");
    }
}