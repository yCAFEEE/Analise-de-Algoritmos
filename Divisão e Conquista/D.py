#descobrir o tm que q está
#tamanho de tm(n) é 2^n-1. Logo, q pertence a um tm(n) que tenha tamanho maior ou igual a q 
import math

def encontraTm(q):
    return math.ceil(math.log2(q)) + 1

def zeroUm(q, i):
    if i == 1:
        return 0
    
    metade = 2**(i - 2)
    if q > metade:
        return 1 - zeroUm(q-metade, i-1)
    else:
        return zeroUm(q, i-1)

n = int(input())
for _ in range(n):
    q = int(input())
    i = encontraTm(q)
    print(zeroUm(q, i))
    