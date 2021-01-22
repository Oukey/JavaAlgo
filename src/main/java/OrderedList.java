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

    //Дополнительный вариант ->>
    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            insertAfter(null, newNode);
        } else {
            Node<T> node = _ascending ? this.head : this.tail;
            while (node != null) {
                if (compare(node.value, value) <= 0) {
                    Node<T> comparingNode = _ascending ? node.next : node.prev;
                    if (comparingNode == null) {
                        Node<T> afterNode = _ascending ? tail : null;
                        insertAfter(afterNode, newNode);
                        break;
                    } else if (compare(comparingNode.value, value) > 0) {
                        Node<T> insertingAfterNode = _ascending ? node : comparingNode;
                        insertAfter(insertingAfterNode, newNode);
                        break;
                    } else if (compare(comparingNode.value, value) == 0) {
                        Node<T> insertingAfterNode = _ascending ? node.next : comparingNode;
                        insertAfter(insertingAfterNode, newNode);
                        break;
                    }
                } else {
                    Node<T> afterNode = _ascending ? null : tail;
                    insertAfter(afterNode, newNode);
                    break;
                }
                node = _ascending ? node.next : node.prev;
            }
        }
    }

    public void insertAfter(Node<T> nodeAfter, Node<T> nodeToInsert) {
        if (nodeAfter == null) {
            nodeToInsert.next = this.head;
            this.head = nodeToInsert;
            if (this.head.next != null) {
                this.head.next.prev = nodeToInsert;
            }
            if (this.tail == null) {
                this.tail = this.head;
            }
            len++;
        } else {
            Node<T> node = find(nodeAfter.value);
            if (node != null) {
                nodeToInsert.next = node.next;
                node.next = nodeToInsert;
                if (node == tail) {
                    this.tail = nodeToInsert;
                    this.tail.prev = node;
                } else {
                    node.next.next.prev = nodeToInsert;
                    nodeToInsert.prev = node;
                }
                len++;
            }
        }
    }


    public Node<T> find(T val) {
        // Метод поиска узла по значению
        Node<T> node = head;
        while (node != null) {
            if (node.value.equals(val)) return node;
            node = node.next;
        }
        return null;
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
        len = 0;
    }

    public int count() {
        // Метод подсчета количества элементов в списке
        return len;
    }

    ArrayList<Node<T>> getAll() {
        // Представление упорядоченного списка в виде стандартного
//        ArrayList<Node<T>> r = new ArrayList<Node<T>>();
        var r = new ArrayList<Node<T>>();
        Node<T> node = head;
        while (node != null) {
            r.add(node);
            node = node.next;
        }
        return r;
    }

    public void printList() {
        Node<T> node = head;
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }
}
