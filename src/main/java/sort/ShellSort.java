package sort;

import java.util.Comparator;

public class ShellSort<T> implements ISorted<T> {
    @Override
    public Object[] sort(Object[] array, Comparator<T> comparator)
    {
        int i, j, k, n = array.length;
        T t;
        for (k = n / 2; k > 0; k /= 2)
            for (i = k; i < n; i++)
            {
                t = (T)array[i];
                for (j = i; j >= k; j -= k)
                {
                    if (comparator.compare(t, (T)array[j-k]) == -1)
                        array[j] = array[j - k];
                    else
                        break;
                }
                array[j] = t;
            }
        return array;
    }
}