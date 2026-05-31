#include <bits/stdc++.h>

using namespace std;

using llu = long long unsigned int;
vector<llu> fib;
void calculaFibs(){
    fib.push_back(1);
    fib.push_back(1);
    while(true){
        llu proximo = fib[fib.size() - 1] + fib[fib.size() - 2];
        fib.push_back(proximo);
        if(proximo > 1e18) break;
    }
}

char palavraFib(long n){
    if(n == 0) return 'b';
    if(n == 1) return 'a';

    long fibAux = 1;
    for(int i = fib.size() - 1; i >= 0; i--){
        if(fib[i] <= n){
            fibAux = fib[i];
            break;
        }
    }

    return palavraFib(n - fibAux);
}

int main(){
    calculaFibs();

    int n;
    cin >> n;

    for(int i = 0; i < n; i++){
        llu aux;
        cin >> aux;
        cout << palavraFib(aux) << "\n";
    }
}
