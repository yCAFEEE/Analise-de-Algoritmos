# esse código é bem ruim
def main():
    k, n = map(int, input().split())
    oii = []

    for _ in range(k):
        linha = list(map(int, input().split()))
        oii.append(linha)

    oii = expMatrizes(oii, k, n)

    for _ in oii:
        print(*_)

def matrizIdentidade(k):
    I = [[0 for _ in range(k)] for _ in range(k)]
    for i in range(k):
        I[i][i] = 1

    return I

def multiplicaMatriz(A, B, n):
    matResul = [[0 for _ in range(n)] for _ in range(n)]
    for i in range(n):
        for j in range(n):
            for k in range(n):
                matResul[i][j] = (matResul[i][j] + A[i][k] * B[k][j]) % (1000000000 + 7)
                
    return matResul

def expMatrizes(M, k, n):
    if n == 0:
        M = matrizIdentidade(k)
        return M
    if n == 1:
        return M
    
    aux = expMatrizes(M, k, n//2)

    if n % 2 == 0:
        return multiplicaMatriz(aux, aux, k)
    else:
        aux = multiplicaMatriz(aux, aux, k)
        return multiplicaMatriz(aux, M, k)

if __name__ == "__main__":
    main()