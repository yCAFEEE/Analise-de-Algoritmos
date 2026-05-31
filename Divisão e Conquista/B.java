import java.util.Scanner;

class B{
    public static long[][] matrizIdentidade(int k){
        long[][] I = new long[k][k];
        for(int i = 0; i < k; i++) I[i][i] = 1;
        return I;
    }

    public static long[][] multiplicaMatriz(long[][] A, long[][] B, int n){
        long[][] matrizResul = new long[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    matrizResul[i][j] = (matrizResul[i][j] + A[i][k] * B[k][j]) % (1000000000 + 7);
                }
            }
        }
        return matrizResul;
    }

    public static long[][] expMatrizes(long[][] M, int k, int n){
        if(n == 0) return matrizIdentidade(k);
        if(n == 1) return M;

        long[][] aux = expMatrizes(M, k, n/2);

        if(n % 2 == 0){
            return multiplicaMatriz(aux, aux, k);
        }else{
            aux = multiplicaMatriz(aux, aux, k);
            return multiplicaMatriz(aux, M, k);
        }
    }
    public static void main(String[] args){
        Scanner le = new Scanner(System.in);
        int k = le.nextInt();
        int n = le.nextInt();
        long[][] oii = new long[k][k];

        for(int i = 0; i < k; i++){
            for(int j = 0; j < k; j++){
                oii[i][j] = le.nextLong();
            }
        }

        oii = expMatrizes(oii, k, n);

        for(int i = 0; i < k; i++){
            for(int j = 0; j < k; j++){
                System.out.print(oii[i][j] + " ");
            }
            System.out.println();
        }
        
        le.close();
    }
}