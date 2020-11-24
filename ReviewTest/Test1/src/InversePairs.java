public class InversePairs {

    public int InversePairs(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }

        return InversePairsCore(array, copy, 0, array.length - 1);
    }

    public int InversePairsCore(int[] array, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = array[start];
            return 0;
        }

        int length = (end - start) / 2;
        int left = InversePairsCore(array, copy, start, start + length) % 1000000007;
        int right = InversePairsCore(array, copy, start + length + 1, end) % 1000000007;

        int i = start + length;
        int j = end;
        int indexCopy = end;
        int count = 0;
        while (i >= start && j >= start + length + 1) {
            if (array[i] > array[j]) {
                copy[indexCopy--] = array[i--];
                count += j - start - length;
                if (count >= 1000000007)//数值过大求余
                {
                    count %= 1000000007;
                }

            } else {
                copy[indexCopy--] = array[j--];
            }
        }

        for (; i >= start; i--) {
            copy[indexCopy--] = array[i];
        }
        for (; j >= start + length + 1; j--) {
            copy[indexCopy--] = array[j];
        }
        for (int s = start; s <= end; s++) {
            array[s] = copy[s];
        }
        return (left + right + count) % 1000000007;
    }
}
