n, m = map(int, input().split())
s1, s2 = input().split()

dp = [[0 for _ in range(m+1)] for _ in range(n+1)]

for i in range(n):
    dp[i][m-1] = n - i
for j in range(m):
    dp[m-1][j] = m - j

for row in dp:
    print(row)

for i in range(n-1, -1, -1):
    for j in range(m-1, -1, -1):
        if s1[i] != s2[j]:
            dp[i][j] = min(dp[i+1][j], dp[i+1][j+1], dp[i][j+1]) + 1
        else:
            dp[i][j] = dp[i+1][j+1]

print("=======================")
for row in dp:
    print(row)
print(dp[0][0])