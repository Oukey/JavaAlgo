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