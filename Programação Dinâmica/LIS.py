n = int(input())

v = list(map(int, input().split()))

dp = [1 for _ in range(n)]

for i in range(n):
    for j in range(i):
        if v[j] < v[i]:
            print(dp[i])
            dp[i] = max(dp[i], dp[j] + 1)

print(dp)
print(max(dp))