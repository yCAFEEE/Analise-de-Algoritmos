#include <iostream>
#include <vector>

using namespace std;

typedef vector<vector<long long>> Matriz;

const long long MOD = 1000000007;

Matriz matrizIdentidade(int k) {
    Matriz I(k, vector<long long>(k, 0));
    for (int i = 0; i < k; i++) {
        I[i][i] = 1;
    }
    return I;
}

Matriz multiplicaMatriz(const Matriz& A, const Matriz& B, int n) {
    Matriz matrizResul(n, vector<long long>(n, 0));
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                matrizResul[i][j] = (matrizResul[i][j] + A[i][k] * B[k][j]) % MOD;
            }
        }
    }
    return matrizResul;
}

Matriz expMatrizes(Matriz M, int k, int n) {
    if (n == 0) return matrizIdentidade(k);
    if (n == 1) return M;

    Matriz aux = expMatrizes(M, k, n / 2);

    if (n % 2 == 0) {
        return multiplicaMatriz(aux, aux, k);
    } else {
        aux = multiplicaMatriz(aux, aux, k);
        return multiplicaMatriz(aux, M, k);
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int k, n;
    if (!(cin >> k >> n)) return 0;

    Matriz oii(k, vector<long long>(k));

    for (int i = 0; i < k; i++) {
        for (int j = 0; j < k; j++) {
            cin >> oii[i][j];
        }
    }

    oii = expMatrizes(oii, k, n);

    for (int i = 0; i < k; i++) {
        for (int j = 0; j < k; j++) {
            cout << oii[i][j] << (j == k - 1 ? "" : " ");
        }
        cout << "\n";
    }

    return 0;
}