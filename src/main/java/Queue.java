import java.util.*;
import java.util.LinkedList;

public class Queue<T> {
    private int size;
    private LinkedList<Object> queue;

    public Queue() {
        // инициализация внутреннего хранилища очереди
        size = 0;
        queue = new LinkedList<>();
    }

    public void enqueue(T item) {
        // Метод добавления элемента в хвост очереди
        queue.addLast((T) item);
        size++;
    }

    public T dequeue() {
        // Метод возвращает элемент из головы очереди и удаляет его
        if (queue.isEmpty()) return null;
        else {
            size--;
            return (T) queue.pollFirst();
        }
    }

    public int size() {
        // Метод возвращает текущий размер очереди
        return size;
    }

//    public Queue<T> rotate(Queue<T> queue, int elem) {
//        // Метод "проворачивает" очередь на заданное количество элементов
//        if (queue.size() == 0 || elem > queue.size()) return null;
//        else {
//            int step = 0;
//            while (step < elem) {
//                queue.enqueue(queue.dequeue());
//                step++;
//            }
//            return queue;
//        }
//    }

}