import java.io.*;
import java.util.*;

class A{
    public static double solve(int[][] valorPeso, int w){
        double soma = 0;
        int espaco = w;
        for(int i = 0; i < valorPeso.length; i++){
            if(espaco <= 0) return soma;
            if(valorPeso[i][1] <= espaco){
                soma += valorPeso[i][0];
                espaco -= valorPeso[i][1];
            }else{
                double valor = valorPeso[i][0];
                double peso = valorPeso[i][1];
                double fracao = peso / valor;
                soma += espaco / fracao;
                espaco -= espaco / fracao;
            }
        }

        return soma;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[][] valorPeso = new int[n][2];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            valorPeso[i][0] = Integer.parseInt(st.nextToken());
            valorPeso[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(valorPeso, (a, b) -> { return Double.compare(b[0] / b[1], a[0] / a[1]); });
        System.out.println(solve(valorPeso, w));
    }
}