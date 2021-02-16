import java.lang.reflect.Array;

class NativeCache<T> {
    public int size;
    public String[] slots;
    public T[] values;
    public int[] hits;

    public NativeCache(int size, Class clazz) {
        this.size = size;
        hits = new int[size];
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);
    }
}