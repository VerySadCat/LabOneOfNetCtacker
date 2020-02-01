package sort;

import java.util.Comparator;

public class GnomSort<T> implements ISorted<T> {
    @Override
    public Object[] sort(Object[] array, Comparator<T> comparator) {
        int i = 1;
        int j = 2;
        int n = array.length;
        T buff;
        while (i < n)
            if (comparator.compare((T) array[i - 1], (T) array[i]) == -1) {
                i = j;
                j++;
            } else {
                buff = (T) array[i - 1];
                array[i - 1] = array[i];
                array[i] = buff;
                i--;
                if (i == 0) {
                    i = j;
                    j++;
                }
            }
        return array;
    }
}