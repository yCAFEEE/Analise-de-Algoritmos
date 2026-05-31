n, m = map(int, input().split())

mat = []
for i in range(n):
    row = list(map(int, input().split()))
    mat.append(row)

dp = [[0 for _ in range(m)] for _ in range(n)]
dp[0][0] = mat[0][0]
for i in range(1, n):
    dp[i][0] = dp[i-1][0] + mat[i][0]
for j in range(1, m):
    dp[0][j] = dp[0][j-1] + mat[0][j]

for i in range(1, n):
    for j in range(1, m):
        dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + mat[i][j]
        
print(dp[n-1][m-1])