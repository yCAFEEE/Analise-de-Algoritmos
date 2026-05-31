def expMatrizes(M, n):
    if n == 1:
        return M
    
    aux = expMatrizes(M, n//2)

    res = [
        [(aux[0][0]**2 + aux[0][1]*aux[1][0]) % (1000000000 + 7), (aux[0][0]*aux[0][1] + aux[0][1]*aux[1][1]) % (1000000000 + 7)],
        [(aux[1][0]*aux[0][0] + aux[1][1]*aux[1][0]) % (1000000000 + 7), (aux[1][0]*aux[0][1] + aux[1][1]**2) % (1000000000 + 7)]
    ]

    if n % 2 == 0:
        return res
    else:
        return [
            [(res[0][0]*M[0][0] + res[0][1]*M[1][0]) % (1000000000 + 7), (res[0][0]*M[0][1] + res[0][1]*M[1][1]) % (1000000000 + 7)],
            [(res[1][0]*M[0][0] + res[1][1]*M[1][0]) % (1000000000 + 7), (res[1][0]*M[0][1] + res[1][1]*M[1][1]) % (1000000000 + 7)]
        ]
    
n = int(input())
aiaiai = [[1,1],[1,0]]
aiaiai = expMatrizes(aiaiai, n)

print(aiaiai[0][1])