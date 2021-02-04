public class PowerSet {

    public PowerSet() {
        // реализация хранилища
    }

    public int size() {
        // Метод возвращает количество элементов в множестве
        return 0;
    }

    public void put(String value) {
        // Метод добавления уникального нового элемента
    }

    public boolean get(String value) {
        // Метод проверки вхождения в множество
        // возвращает true если value имеется в множестве,
        // иначе false
        return false;
    }

    public boolean remove(String value) {
        // Метод удаления из множества
        // возвращает true если value удалено
        // иначе false
        return false;
    }

    public PowerSet intersection(PowerSet set2) {
        // Метод пересечения текущего множества и set2
        return null;
    }

    public PowerSet union(PowerSet set2) {
        // Метод объединяет текущее множество и set2
        return null;
    }

    public PowerSet difference(PowerSet set2) {
        // Метод возвращают разницу текущего множества и set2
        return null;
    }

    public boolean isSubset(PowerSet set2) {
        // Метод проверки вхождения подмножества
        // возвращает true, если set2 есть
        // подмножество текущего множества,
        // иначе false
        return false;
    }
}