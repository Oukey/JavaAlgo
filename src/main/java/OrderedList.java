import java.util.*;


class Node<T> {
    public T value;
    public Node<T> next, prev;

    public Node(T _value) {
        value = _value;
        next = null;
        prev = null;
    }
}

public class OrderedList<T> {
    public Node<T> head, tail;
    private boolean _ascending;

    public OrderedList(boolean asc) {
        head = null;
        tail = null;
        _ascending = asc;
    }

    public int compare(T v1, T v2) {
        return 0;
        // -1 если v1 < v2
        // 0 если v1 == v2
        // +1 если v1 > v2
    }

    public void add(T value) {
        // Метод автоматической вставка value в нужную позицию
    }

    public Node<T> find(T val) {
        // Метод поиска узла по значению
        return null;
    }

    public void delete(T val) {
        // Метод удаления узла по значению
    }

    public void clear(boolean asc) {
        _ascending = asc;
        // здесь будет ваш код
    }

    public int count() {
        // Метод подсчета количества элементов в списке
        return 0;
    }

    ArrayList<Node<T>> getAll()
    // Представление упорядоченного списка в виде стандартного
    {
        ArrayList<Node<T>> r = new ArrayList<Node<T>>();
        Node<T> node = head;
        while (node != null) {
            r.add(node);
            node = node.next;
        }
        return r;
    }
}