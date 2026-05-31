n, w = map(int, input().split())

pesos = []
valor = []
for _ in range(n):
    p, v = map(int, input().split())
    pesos.append(p)
    valor.append(v)

dp = [0 for _ in range(w+1)]

for i in range(1, w+1):
    for j in range(n):
        if pesos[j] <= i:
            dp[i] = max(dp[i], dp[i-pesos[j]] + valor[j])
        else:
            dp[i] = dp[i]
        
print(dp[w])