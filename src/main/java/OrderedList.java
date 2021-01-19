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
    public Node head;
    public Node tail;
    private boolean _ascending;
    public int len = 0;

    public OrderedList(boolean asc) {
        head = null;
        tail = null;
        _ascending = asc;
    }

    public int compare(T v1, Object v2) {
        // Метод сравнения элементов по значению
        // -1 если v1 < v2
        // 0 если v1 == v2
        // +1 если v1 > v2
        if (v1 instanceof Integer) return ((Integer) v1).compareTo((Integer) v2);
        if (v1 instanceof String && v2 instanceof String) {
            return ((String) v1).compareTo((String) v2);
        }
        return 0;
    }

    public void add(T value) {
        // Метод автоматической вставка value в нужную позицию
        Node newNode = new Node(value);
        // Если список был пуст сразу добавляется новый узел
        if (len == 0) {
            this.head = newNode;
            this.tail = newNode;
            len++;
        } else {
            if (_ascending) {
                // Если список сортируется по возрастанию
                if (compare(value, this.head.value) != 1) {
                    // Если значение нового узла меньше чем значение головного
                    newNode.next = this.head;
                    this.head.prev = newNode;
                    this.head = newNode;
                    len++;
                } else if (compare(value, this.tail.value) != -1) {
                    // Иначе если значение нового узла больше значения хвостового
                    newNode.prev = this.tail;
                    this.tail.next = newNode;
                    this.tail = newNode;
                    len++;
                } else {
                    // для сравнения средних элементов
                    Node node = this.tail;
                    // Пока значение нового узла не меньше очередного
                    // (перебор от хвоста к голове
                    while (compare(value, node.value) != 1) {
                        node = node.prev;
                    }
                    newNode.prev = node.next;
                    newNode.next = node.next;
                    node.next.prev = newNode;
                    node.next = newNode;
                    len++;
                }

            } else {
                // Если список сортируется по убыванию
                if (compare(value, this.head.value) != -1) {
                    // Если значение нового узла больше или равно значению головного
                    newNode.next = this.head;
                    this.head.prev = newNode;
                    this.head = newNode;
                    len++;
                } else if (compare(value, this.tail.value) != 1) {
                    // Если значение нового узла меньше или равно значению хвостового узла
                    newNode.prev = this.tail;
                    this.tail.next = newNode;
                    this.tail = newNode;
                    len++;
                } else {
                    // Для средних узлов
                    Node node = this.tail;
                    // пока значение нового узла не меньше очередного
                    // перебор от головы к хвосту
                    while (compare(value, node.value) != -1) {
                        node = node.next;
                    }
                    newNode.prev = node;
                    newNode.next = node.next;
                    node.next.prev = newNode;
                    node.next = newNode;
                    len++;
                }
            }
        }
    }

    public Node<T> find(T val) {
        // Метод поиска узла по значению
        return null;
    }

    public void delete(T val) {
        // Метод удаления узла по значению
    }

    public void clear(boolean asc) {
        // Метод очистки списка
        this.head = null;
        this.tail = null;
        _ascending = asc;
    }

    public int count() {
        // Метод подсчета количества элементов в списке
        if (this.head == null) {
            int len = 0;
            Node node = this.head;
            while (node != null) {
                len++;
                node = node.next;
            }
            return len;
        } else return 0;
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