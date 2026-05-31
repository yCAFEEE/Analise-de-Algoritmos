#include <stdio.h>
#include <stdlib.h>

#define MOD 1000000007

int** alocarMatriz(int k) {
    int** m = (int**)malloc(k * sizeof(int*));
    for (int i = 0; i < k; i++) {
        m[i] = (int*)calloc(k, sizeof(int));
    }
    return m;
}

void liberarMatriz(int** m, int k) {
    for (int i = 0; i < k; i++) free(m[i]);
    free(m);
}

int** matrizIdentidade(int k) {
    int** I = alocarMatriz(k);
    for (int i = 0; i < k; i++) I[i][i] = 1;
    return I;
}

int** multiplicaMatriz(int** A, int** B, int n) {
    int** matrizResul = alocarMatriz(n);
    for (int i = 0; i < n; i++) {
        for (int k = 0; k < n; k++) {
            for (int j = 0; j < n; j++) {
                long long produto = (long long)A[i][k] * B[k][j];
                matrizResul[i][j] = (int)((matrizResul[i][j] + produto) % MOD);
            }
        }
    }
    return matrizResul;
}

int** expMatrizes(int** M, int k, int n) {
    if (n == 0) return matrizIdentidade(k);
    if (n == 1) {
        int** copia = alocarMatriz(k);
        for(int i=0; i<k; i++) for(int j=0; j<k; j++) copia[i][j] = M[i][j];
        return copia;
    }

    int** aux = expMatrizes(M, k, n / 2);
    int** res = multiplicaMatriz(aux, aux, k);
    liberarMatriz(aux, k);

    if (n % 2 != 0) {
        int** temp = multiplicaMatriz(res, M, k);
        liberarMatriz(res, k);
        res = temp;
    }
    return res;
}

int main() {
    int k, n;
    if (scanf("%d %d", &k, &n) != 2) return 1;

    int** oii = alocarMatriz(k);
    for (int i = 0; i < k; i++) {
        for (int j = 0; j < k; j++) {
            scanf("%d", &oii[i][j]);
        }
    }

    int** resultado = expMatrizes(oii, k, n);

    for (int i = 0; i < k; i++) {
        for (int j = 0; j < k; j++) {
            printf("%d ", resultado[i][j]);
        }
        printf("\n");
    }

    liberarMatriz(oii, k);
    liberarMatriz(resultado, k);
    return 0;
}