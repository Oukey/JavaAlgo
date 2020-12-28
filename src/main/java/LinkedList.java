import java.util.*;

public class LinkedList {
    public NodeLL head;
    public NodeLL tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public void addInTail(NodeLL item) {
        if (this.head == null)
            this.head = item;
        else
            this.tail.next = item;
        this.tail = item;
    }

    public NodeLL find(int value) {
        NodeLL node = this.head;
        while (node != null) {
            if (node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<NodeLL> findAll(int _value) {
        ArrayList<NodeLL> nodes = new ArrayList<NodeLL>();
        // Поиск всех элементов по заданному значению
        NodeLL node = this.head;
        while (node != null) {
            if (node.value == _value)
                nodes.add(node);
            node = node.next;
        }
        return nodes;
    }

    public boolean remove(int _value) {
        // Удаления одного узла по заданному значению
        if (this.head != null) {
            NodeLL node = this.head;
            if (node.value == _value && node.next == null) {
                this.clear();
                return true;
            }
            while (node.next != null) {
                if (node.next.value == _value && node.next.next != null) {
                    node.next = node.next.next;
                    return true;
//                    break;
                } else if (node.next.value == _value && node.next.next == null) {
                    this.tail = node;
                    node.next = null;
//                    break;
                    return true;

                } else if (this.head.value == _value) {
                    this.head = node.next;
//                    break;
                    return true;
                }
                node = node.next;
            }
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
        // Очистка всего списка
        this.head = null;
        this.tail = null;
    }

    public int count() {
        // Подсчёт количества элементов в списке
        NodeLL node = this.head;
        int count = 0;
        while (node != null) {
            count += 1;
            node = node.next;
        }
        return count;
    }

    public void insertAfter(NodeLL _nodeAfter, NodeLL _nodeToInsert) {
        // Вставка узла после заданного
        // Если список пуст и _nodeAfter равен null
        if (this.head == null && _nodeAfter == null) {
            this.head = _nodeToInsert;
            this.tail = _nodeToInsert;
        } else if (this.head != null) {
            // Если _nodeAfter последний элемент в списке
            if (_nodeAfter == this.tail) {
                _nodeAfter.next = _nodeToInsert;
                this.tail = _nodeToInsert;
                // где то посередине
            } else {
                _nodeToInsert.next = _nodeAfter.next;
                _nodeAfter.next = _nodeToInsert;
            }
        }
    }

//    public void showList() {
//        ArrayList<Integer> showL = new ArrayList<> ();
//        Node node = this.head;
//        while (node != null) {
//            showL.add(node.value);
//            node = node.next;
//        }
//        System.out.println(showL);
//    }

}

class NodeLL {
    public int value;
    public NodeLL next;

    public NodeLL(int _value) {
        value = _value;
        next = null;
    }
}