def palavraFib(i):
    if i == 0:
        return 'b'
    elif i == 1:
        return 'a'
    else:
        return palavraFib(i/2)
    
n = int(input())
for _ in range(n):
    i = int(input())
    print(palavraFib(i))