public class MergeSort {
    public static int steps = 0;

    // Public helper to reset steps and call recursive sort
    public static void sort(int[] arr) {
        steps = 0;
        if (arr == null || arr.length < 2) return;
        sortRec(arr, 0, arr.length - 1);
    }

    private static void sortRec(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            sortRec(arr, left, mid);
            sortRec(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            steps++;
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }
}
