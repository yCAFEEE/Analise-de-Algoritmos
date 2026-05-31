import java.io.*;
import java.util.*;

class G{
    public static List<Long> fib = new ArrayList<>();
    public static void calculaFibs(){
        fib.add(1L);
        fib.add(1L);
        while(true){
            long proximo = fib.get(fib.size() - 1) + fib.get(fib.size() - 2);
            fib.add(proximo);
            if(proximo > 1e18) break;
        }
    }


    public static char palavraFib(long n){
        if(n == 0) return 'b';
        if(n == 1) return 'a';

        long fibAux = 1;
        for(int i = fib.size() - 1; i >= 0; i--){
            if(fib.get(i) <= n){
                fibAux = fib.get(i);
                break;
            }
        }

        return palavraFib(n - fibAux);
    }

    public static void main(String[] args) throws Exception{
        calculaFibs();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            long aux = Long.parseLong(br.readLine());
            System.out.println(palavraFib(aux));
        }
    }
}