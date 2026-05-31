#include <iostream>
#include <cmath>

int encontraTm(long long q){
    return std::ceil(std::log2(q)) + 1;
}

int zeroUm(long long q, long long i){
    if(i == 1) return 0;

    long long metade = std::pow(2, i - 2);
    if(q > metade) return 1 - zeroUm(q-metade, i-1);
    else return zeroUm(q, i-1);
}

int main(){
    int n;
    std::cin >> n;

    for(int _ = 0; _ < n; _++){
        long long q, i;
        std::cin >> q;
        i = encontraTm(q);
        std::cout << zeroUm(q, i) << "\n";
    }
}