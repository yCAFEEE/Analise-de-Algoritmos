import sys

input = sys.stdin.readline

def solve(participantes):
    maior = 0
    for i in range(0, len(participantes), 2):
        if participantes[i+1] - participantes[i] > maior:
            maior = participantes[i+1] - participantes[i]

    return maior

t = int(input())

for _ in range(t):
    n = int(input())
    participantes = list(map(int, input().split()))
    participantes.sort()
    print(solve(participantes))
