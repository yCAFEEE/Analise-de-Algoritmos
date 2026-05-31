import java.util.Scanner;

class A{
    public static long fastExp(int x, int n){
        if(n == 0){
            return 1;
        }

        if(n % 2 == 0){
            long aux = fastExp(x, n/2);
            return (aux * aux) % (1000000000 + 7);
        }
        else{
            long aux = fastExp(x, n/2);
            return (x * aux * aux) % (1000000000 + 7);
        }
    }

    public static void main(String[] arg){
        Scanner le = new Scanner(System.in);
        int x;
        int n;
        x = le.nextInt();
        n = le.nextInt();
        System.out.println(fastExp(x, n));
        le.close();
    }
}