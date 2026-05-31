import java.util.*;

class A2{
    public static double solve(int[][] valorPeso, int w){
        double soma = 0;
        int espaco = w;
        for(int i = 0; i < valorPeso.length; i++){
            if(espaco <= 0) return soma;
            if(valorPeso[i][1] <= espaco){
                soma += valorPeso[i][0];
                espaco -= valorPeso[i][1];
            }else{
                soma += (double)(espaco * valorPeso[i][0] / valorPeso[i][1]);
                espaco -= (double)(espaco * valorPeso[i][0] / valorPeso[i][1]);
            }
        }

        return soma;
    }
    public static void main(String[] args) throws Exception{
        Scanner le = new Scanner(System.in);
        int n = le.nextInt();
        int w = le.nextInt();

        int[][] valorPeso = new int[n][2];
        for(int i = 0; i < n; i++){
            valorPeso[i][0] = le.nextInt();
            valorPeso[i][1] = le.nextInt();
        }
        le.close();
        Arrays.sort(valorPeso, (a, b) -> { return Double.compare(b[0] / b[1], a[0] / a[1]); });
        System.out.println(solve(valorPeso, w));
    }
}