import java.util.*;

public class LinkedList2 {
    public NodeL2 head;
    public NodeL2 tail;

    public LinkedList2() {
        head = null;
        tail = null;
    }

    public void addInTail(NodeL2 _item) {
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

    public NodeL2 find(int _value) {
        // Поиск первого элемента с заданным значением
        NodeL2 node = this.head;
        while (node != null) {
            if (node.value == _value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public ArrayList<NodeL2> findAll(int _value) {
        // Поиск всех узлов по заданному значению
        // Возвращает массив элементов
        ArrayList<NodeL2> nodes = new ArrayList<NodeL2>();
        NodeL2 node = this.head;
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
        NodeL2 node = this.find(_value);
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
        NodeL2 node = this.head;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    public void insertAfter(NodeL2 _nodeAfter, NodeL2 _nodeToInsert) {
        // Вставка узла после заданного узла
        if (this.head == null || _nodeAfter == this.tail) {
            this.addInTail(_nodeToInsert);
        } else if (_nodeAfter == null) {
            _nodeToInsert.next = this.head;
            this.head.prev = _nodeToInsert;
            this.head = _nodeToInsert;
        } else {
            _nodeToInsert.next = _nodeAfter.next;
            _nodeToInsert.prev = _nodeAfter;
            _nodeAfter.next.prev = _nodeToInsert;
            _nodeAfter.next = _nodeToInsert;
        }
    }

//    public void showList() {
//        ArrayList<Integer> showL = new ArrayList<>();
//        Node node = this.head;
//        while (node != null) {
//            showL.add(node.value);
//            node = node.next;
//        }
//        System.out.println(showL);
//    }

//    public void showTail() {
//        System.out.println("Tail: " + this.tail.value);
//    }
}

class NodeL2 {
    public int value;
    public NodeL2 next;
    public NodeL2 prev;

    public NodeL2(int _value) {
        value = _value;
        next = null;
        prev = null;
    }
}