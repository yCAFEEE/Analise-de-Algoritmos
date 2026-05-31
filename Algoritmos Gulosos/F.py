def main():
    n = int(input())

    lr = []
    for _ in range(n):
        row = list(map(int, input().split()))
        lr.append(row)

    lr.sort(key=lambda x: (x[0], -x[1]))

    cont = n
    max_r = -1
    for i in range(n):
        if lr[i][1] <= max_r:
            cont -= 1
        else:
            max_r = lr[i][1]
            
    print(cont)

if __name__ == '__main__':
    main()