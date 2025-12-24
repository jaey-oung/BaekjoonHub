import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] heights = new int[9];

        for (int i = 0; i < 9; i++)
            heights[i] = Integer.parseInt(br.readLine());

        int[] dwarfs = new int[7];
        findSevenDwarfs(heights, dwarfs);
        insertionSort(dwarfs);

        for (int i = 0; i < 7; i++)
            bw.write(dwarfs[i] + "\n");
        bw.flush();
    }

    public static void findSevenDwarfs(int[] heights, int[] dwarfs) {
        int totalSum = 0;

        for (int i = 0; i < 9; i++)
            totalSum += heights[i];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < i; j++) {
                if (totalSum - heights[i] - heights[j] == 100) {
                    int index = 0;

                    for (int k = 0; k < 9; k++)
                        if (k != i && k != j)
                            dwarfs[index++] = heights[k];
                    return;
                }
            }
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) {
                    int current = arr[i];

                    for (int k = i - 1; k >= j; k--)
                        arr[k + 1] = arr[k];
                    arr[j] = current;
                    break;
                }
            }
        }
    }
}