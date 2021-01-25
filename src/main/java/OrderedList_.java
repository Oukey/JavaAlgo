import java.util.*;


class Node_<T> {
    public T value;
    public Node_<T> next, prev;

    public Node_(T _value) {
        value = _value;
        next = null;
        prev = null;
    }
}

public class OrderedList_<T> {
    public Node_ head;
    public Node_ tail;
    private boolean _ascending;
    public int len = 0;

    public OrderedList_(boolean asc) {
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
        Node_ newNode = new Node_(value);
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
                    Node_ node = this.tail;
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
                    Node_ node = this.tail;
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

    public Node_<T> find(T val) {
        // Метод поиска узла по значению
        Node_ node = this.head;
        while (node != null) {
            if (node.value.equals(val)) {
                return node;
            } else
                node = node.next;
        }
        return null;
    }

    public void delete(T val) {
        // Метод удаления узла по значению
        Node_ node = find(val);
        if (node != null) {
            if (node == this.head) {
                node.next.prev = null;
                this.head = node.next;
            } else if (node == this.tail) {
                node.prev.next = null;
                this.tail = node.prev;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
        }
    }

    public void clear(boolean asc) {
        // Метод очистки списка
        this.head = null;
        this.tail = null;
        _ascending = asc;
        len = 0;
    }

    public int count() {
        // Метод подсчета количества элементов в списке
        int len = this.len;
        return len;
    }

    ArrayList<Node_<T>> getAll()
    // Представление упорядоченного списка в виде стандартного
    {
        ArrayList<Node_<T>> r = new ArrayList<Node_<T>>();
        Node_<T> node = head;
        while (node != null) {
            r.add(node);
            node = node.next;
        }
        return r;
    }

    public void printList() {
        Node_ node = head;
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }
}