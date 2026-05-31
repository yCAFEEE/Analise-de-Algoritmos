def fastExp(x, n):
    if n == 0:
        return 1
    
    if n % 2 == 0:
        aux = fastExp(x, n//2)
        return (aux * aux) % (1000000000 + 7)
    else:
        aux = fastExp(x, n//2)
        return (x * aux * aux) % (1000000000 + 7)

x, n = map(int, input().split())
resul = fastExp(x, n)
print(resul)