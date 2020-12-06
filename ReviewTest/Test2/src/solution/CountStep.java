package solution;

public class CountStep {
    public static int countWays(int x, int y) {
        int[][] arr = new int[x][y];
        for(int i = 0; i<x ; i++){
            arr[i][0]=1;
        }
        for(int j = 0; j<y ; j++){
            arr[0][j]=1;
        }
        for (int i = 1; i<x ; i++) {
            for(int j = 1; j<y ; j++){
                arr[i][j] = arr[i-1][j] + arr[i][j-1];
            }
        }
        return arr[x-1][y-1];
    }

    public static void main(String[] args) {
        int x = 2;
        int y = 2;
        System.out.println(countWays(x, y));
    }
}
