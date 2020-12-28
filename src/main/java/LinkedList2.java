import java.util.*;

public class LinkedList2 {
    public Node head;
    public Node tail;

    public LinkedList2() {
        head = null;
        tail = null;
    }

    public void addInTail(Node _item) {
        if (head == null) {
            this.head = _item;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = _item;
            _item.prev = tail;
        }
        this.tail = _item;
    }

    public Node find(int _value) {
        // Поиск первого элемента с заданным значением
        Node node = this.head;
        while (node != null) {
            if (node.value == _value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        // Поиск всех узлов по заданному значению
        // Возвращает массив элементов
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node node = this.head;
        while (node != null) {
            if (node.value == _value) {
                nodes.add(node);
            }
            node = node.next;
        }
        return nodes;
    }

    public boolean remove(int _value) {
        // Удаление первого узла по заданному значению
        Node node = this.find(_value);
        if (node != null) {
            // Если в списке один узел
            if (this.count() == 1) {
                this.clear();
            } else if (node == this.head) {    // если найден узел в начеле
                node.next.prev = null;
                this.head = node.next;
            } else if (node == this.tail) {    // если найден узел в конце
                node.prev.next = null;
                this.tail = node.prev;
            } else {    // Если найден средний узел
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            return true;
        }
        return false;
    }

    public void removeAll(int _value) {
        // Удаление всех узлов по заданному значению
        while (find(_value) != null) {
            remove(_value);
        }
    }

    public void clear() {
        // здесь будет ваш код очистки всего списка
        this.head = null;
        this.tail = null;
    }

    public int count() {
        // Подсчёт количества элементов в списке
        int count = 0;
        Node node = this.head;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
        // здесь будет ваш код вставки узла после заданного узла

        // если _nodeAfter = null
        // добавьте новый элемент первым в списке
        if (_nodeAfter == null) {
            if (this.count() > 0) {
                this.head.prev = _nodeToInsert;
                _nodeToInsert.next = this.head;
            }
            this.head = _nodeToInsert;
        } else if (_nodeAfter != null) {
            if (this.count() > 1) {
                _nodeToInsert.next = _nodeAfter.next;
                _nodeAfter.next.prev = _nodeToInsert;
            }
            _nodeToInsert.prev = _nodeAfter;
            _nodeAfter.next = _nodeToInsert;
        }
    }
        public void showList() {
        ArrayList<Integer> showL = new ArrayList<> ();
        Node node = this.head;
        while (node != null) {
            showL.add(node.value);
            node = node.next;
        }
        System.out.println(showL);
    }
}

class Node
{
    public int value;
    public Node next;
    public Node prev;

    public Node(int _value)
    {
        value = _value;
        next = null;
        prev = null;
    }
}