#include <bits/stdc++.h>

using namespace std;

long resolve(vector<long> entrada, vector<long> saida, long n){
    long cont = 0;
    long maxCont = LONG_MIN;
    int i = 0, j = 0;
    while(i < n){
        if(entrada[i] <= saida[j]){
            cont++;
            i++;
        }else{
            cont--;
            j++;
        }

        maxCont = max(cont, maxCont);
    }

    return maxCont;
}

long stringParaSeg(string input){
    long tempoSeg = (stoi(input.substr(0, 2)) * 3600)
    + (stoi(input.substr(3, 5)) * 60)
    + stoi(input.substr(6, 8));

    return tempoSeg;
}

int main(){
    long n;
    cin >> n;

    vector<pair<string, string>> tempos(n);
    vector<long> entrada(n);
    vector<long> saida(n);
    for(int i = 0; i < n; i++){
        cin >> tempos[i].first;
        cin >> tempos[i].second;
        entrada[i] = stringParaSeg(tempos[i].first);
        saida[i] = stringParaSeg(tempos[i].second);
    }

    sort(entrada.begin(), entrada.end());
    sort(saida.begin(), saida.end());

    cout << resolve(entrada, saida, n) << "\n";
}