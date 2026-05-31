n = int(input())

precos = list(map(int, input().split()))

dp = [0 for _ in range(n+1)]
cut = [0 for _ in range(n+1)]
for i in range(1, n+1):
    maxDp = 0
    for j in range(1, i+1):
        if precos[j-1] + dp[i-j] > maxDp:
            maxDp = precos[j-1] + dp[i-j]
            cut[i] = j
    dp[i] = maxDp
  
print(dp[n])
i = n
pedacos = []
while i > 0:
    j = cut[i]
    pedacos.append(j)
    i -= j

print(*pedacos)