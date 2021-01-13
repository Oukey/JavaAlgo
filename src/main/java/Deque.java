import java.util.LinkedList;
import java.util.*;

public class Deque<T> {

    LinkedList<T> data;


    public Deque() {
        // Конструктор внутреннего хранилища
        data = new LinkedList<>();
    }

    public void addFront(T item) {
        // Метод добавления в голову
        data.addFirst(item);
    }

    public void addTail(T item) {
        // Метод добавления в хвост
        data.addLast(item);
    }

    public T removeFront() {
        // Метод удаления из головы
        return data.pollFirst();
    }

    public T removeTail() {
        // Метод удаления из хвоста
        return data.pollLast();
    }

    public int size() {
        // размер очереди
        return data.size();
    }

    public void show() {
        for (int x = 0; x < this.size(); x++) {
            System.out.print(data.get(x).toString() + "; ");
        }
    }
}