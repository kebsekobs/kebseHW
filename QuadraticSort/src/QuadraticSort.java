import java.util.Arrays;

public class QuadraticSort {
    public void sort(int[] data)
    {
        int N;
        for(int i = 1; i < data.length; i++){
            N = data[i];
            for(int j = i - 1; j > -1; j--){
                if(N < data[j]){
                    data[j + 1] = data[j];
                    if(j == 0){data[j] = N;}
                }
                else {
                    data[j + 1] = N;
                    j = -1;
                }
            }
        }
    }
}
