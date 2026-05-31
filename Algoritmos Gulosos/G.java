import java.io.*;
import java.util.*;

class G{
    public static int solve(int[] participantes){
        int max = 0;
        for(int i = 0; i < participantes.length; i += 2){
            max = Math.max(max, Math.abs(participantes[i] - participantes[i+1]));
        }
        return max;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++){

            int n = Integer.parseInt(br.readLine());
            int[] participantes = new int[n];
            String linha = br.readLine();
            StringTokenizer st = new StringTokenizer(linha);
            for(int j = 0; j < n; j++){
                participantes[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(participantes);
            System.out.println(solve(participantes));
        }
    }
}