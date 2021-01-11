import java.util.*;

public class Stack<T> {

    private int size;
    private java.util.Stack<Object> structure;

    public Stack() {
        // конструктор внутреннего хранилища стека
        structure = new java.util.Stack<>();
        size = 0;
    }

    public int size() {
        // Метод возвращает размер текущего стека
        return size;
    }

    public T pop() {
        // Метод удаляет и возвращает очередной элемент из стека;
        if (structure.isEmpty()) return null;  // если стек пустой
        else {
            size--;
            return (T) structure.pop();
        }
    }

    public void push(T val) {
        // Метод добавляет новый элемент в стек
        structure.push((T) val);
        size++;
    }

    public T peek() {
        // Метод возвращает очередной элемент без удаления из стека
        if (structure.isEmpty()) return null;
        else {
            return (T) structure.peek();
        }
    }

}

//import java.util.*;
//
//public class Stack<T> {
//
//    //    private LinkedList<Object> structure;
////    private LinkedList<Object> structure;
////    private Stack structure;
////    java.util.Stack stack = new java.util.Stack();
//    private int size;
//
//    public Stack() {
//        // конструктор внутреннего хранилища стека
////        structure = new LinkedList<>();
//        java.util.Stack structure = new java.util.Stack();
//        size = 0;
//    }
//
//    public int size() {
//        // Метод возвращает размер текущего стека
//        return size;
//    }
//
//    public T pop() {
//        // Метод удаляет и возвращает очередной элемент из стека;
//        if (size > 0) {
//            size--;
////            return (T) structure.pollFirst();
//            return (T) structure.pop();
//        } else return null;
//    }
//
//    public void push(T val) {
//        // Метод добавляет новый элемент в стек
////        structure.addFirst((Objects) val);
//        structure.push((Objects) val);
//        size++;
//        // ваш код
//    }
//
//    public T peek() {
//        // Метод возвращает очередной элемент без удаления из стека
//        if (size > 0) return (T) structure.peekFirst();
//        else return null;
//    }
//}