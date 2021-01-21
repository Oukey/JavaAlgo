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
    public int len = 0;

    public OrderedList(boolean asc) {
        head = null;
        tail = null;
        _ascending = asc;
    }

    public int compare(T v1, T v2) {
        // Метод сравнения элементов по значению
        // -1 если v1 < v2
        // 0 если v1 == v2
        // +1 если v1 > v2
        if (v1 instanceof Integer) {
            return ((Integer) v1).compareTo((Integer) v2);
        }
        if (v1 instanceof String && v2 instanceof String) {
            if (((String) v1).compareTo((String) v2) > 0) return +1;
            if (((String) v1).compareTo((String) v2) < 0) return -1;
        }
        return 0;
    }

    public void add(T value) {
        // Метод автоматической вставка value в нужную позицию
        Node<T> newNode = new Node<>(value);
        // Если список был пуст сразу добавляется новый узел
        if (head == null) {
            head = newNode;
            tail = newNode;
            len++;
        } else {
            if (_ascending) {
                // Если список сортируется по возрастанию
                if (compare(value, head.value) != 1) {
                    // Если значение нового узла меньше чем значение головного
                    newNode.next = head;
                    head.prev = newNode;
                    head = newNode;
                    len++;
                } else if (compare(value, tail.value) != -1) {
                    // Иначе если значение нового узла больше значения хвостового
                    newNode.prev = tail;
                    tail.next = newNode;
                    tail = newNode;
                    len++;
                } else {
                    // для сравнения средних элементов
                    Node<T> node = tail;
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
                if (compare(value, head.value) != -1) {
                    // Если значение нового узла больше или равно значению головного
                    newNode.next = head;
                    head.prev = newNode;
                    head = newNode;
                    len++;
                } else if (compare(value, tail.value) != 1) {
                    // Если значение нового узла меньше или равно значению хвостового узла
                    newNode.prev = tail;
                    tail.next = newNode;
                    tail = newNode;
                    len++;
                } else {
                    // Для средних узлов
                    Node<T> node = tail;
                    // пока значение нового узла не меньше очередного
                    // перебор от головы к хвосту
                    while (compare(value, node.value) != -1) {
                        node = newNode.next;
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
        Node node = head;
        while (node != null) {
            if (node.value.equals(val)) {
                return node;
            }
            node = node.next;
        }
        return null; // здесь будет ваш код
    }

    public void delete(T val) {
        // Метод удаления узла по значению
        Node<T> node = find(val);
        if (node != null) {
            if (node == head) {
                node.next.prev = null;
                head = node.next;
                len--;
            } else if (node == tail) {
                node.prev.next = null;
                tail = node.prev;
                len--;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                len--;
            }
        }
    }

    public void clear(boolean asc) {
        _ascending = asc;
        // Метод очистки списка
        head = null;
        tail = null;
        _ascending = asc;
        len = 0;
    }

    public int count() {
        // Метод подсчета количества элементов в списке
        return len;
    }

    ArrayList<Node<T>> getAll() {
        // Представление упорядоченного списка в виде стандартного
        ArrayList<Node<T>> r = new ArrayList<Node<T>>();
        Node<T> node = head;
        while (node != null) {
            r.add(node);
            node = node.next;
        }
        return r;
    }

    public void printList() {
        Node node = head;
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }
}
