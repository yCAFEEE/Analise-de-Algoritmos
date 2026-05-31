import java.io.*;
import java.util.*;

class B{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] inicioFim = new int[n][2];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            inicioFim[i][0] = Integer.parseInt(st.nextToken());
            inicioFim[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(inicioFim, (a, b) -> Integer.compare(a[1], b[1]));
        int k = -1;
        int cont = 0;
        for(int i = 0; i < n; i++){
            if(inicioFim[i][0] > k){
                cont++;
                k = inicioFim[i][1];
            }
        }

        System.out.println(cont);
    }
}