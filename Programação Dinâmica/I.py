n = int(input())

seq = list(map(int, input().split()))

dp = [1 for _ in range(n+1)]
p = [-1 for _ in range(n+1)]
for i in range(n):
    for j in range(i):
        if seq[j] < seq[i]:
            if(dp[j] + 1 > dp[i]):
                dp[i] = dp[j] + 1
                p[i] = j

pos = dp.index(max(dp))
resulSeq = []
while pos != -1:
    resulSeq.append(seq[pos])
    pos = p[pos]

resulSeq.reverse()
print(max(dp))
print(*resulSeq)