n, w = map(int, input().split())

pesos = [0]
valor = [0]
for _ in range(n):
    p, v = map(int, input().split())
    pesos.append(p)
    valor.append(v)

dp = [[0 for _ in range(w+1)] for _ in range(n+1)]

for i in range(1, n+1):
    for j in range(1, w+1):
        if pesos[i] <= j:
            dp[i][j] = max(dp[i-1][j], dp[i-1][j-pesos[i]] + valor[i])
        else:
            dp[i][j] = dp[i-1][j]
        
print(dp[n][w])