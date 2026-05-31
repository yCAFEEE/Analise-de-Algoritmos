#include <bits/stdc++.h>

using namespace std;

double solve(vector<pair<long, long>> valorPeso, long w, long n){
    double soma = 0;
    long espaco = w;

    for(int i = 0; i < n; i++){
        if(espaco <= 0) return soma;
        if(valorPeso[i].second <= espaco){
            soma += valorPeso[i].first;
            espaco -= valorPeso[i].second;
        }else{
            double valor = valorPeso[i].first;
            double peso = valorPeso[i].second;
            double fracao = peso / valor;
            soma += espaco / fracao;
            espaco -= espaco / fracao;
        }
    }
    return soma;
}

int main(){
    long n;
    long w;

    cin >> n;
    cin >> w;

    vector<pair<long, long>> valorPeso(n);
    for(long i = 0; i < n; i++){
        cin >> valorPeso[i].first;
        cin >> valorPeso[i].second;
    }

    sort(valorPeso.begin(), valorPeso.end(), [](const pair<long, long>& a, const pair<long, long>& b){ return (double)b.first / b.second < (double)a.first / a.second; });
    cout << solve(valorPeso, w, n) << "\n";
}