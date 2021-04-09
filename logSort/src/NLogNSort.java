public class NLogNSort {
    public void sort(int[] data)
    {
        quickSort(data, 0, data.length - 1);
    }
    public void quickSort(int[] data, int left, int right){
        if (data.length == 0)
            return;

        if (left >= right)
            return;

        int baseIndex = left + (right - left) / 2;
        int base = data[baseIndex];

        int i = left;
        int j = right;
        while (i <= j) {
            while (data[i] < base) {
                i++;
            }

            while (data[j] > base) {
                j--;
            }

            if (i <= j) {
                int temp = data[i];
                data[i] = data[j];
                data[j] = temp;
                i++;
                j--;
            }
        }

        if (left < j)
            quickSort(data, left, j);

        if (right > i)
            quickSort(data, i, right);
    }
}
