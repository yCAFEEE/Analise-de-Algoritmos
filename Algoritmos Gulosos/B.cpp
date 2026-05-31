#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(){
    long n;
    cin >> n;

    vector<pair<long, long>> inicioFim(n);
    for(long i = 0; i < n; i++){
        cin >> inicioFim[i].first >> inicioFim[i].second;
    }

    sort(inicioFim.begin(), inicioFim.end(), [](const pair<long, long>& a, const pair<long, long>& b){ return a.second < b.second; });
    long k = -1;
    long cont = 0;
    for(long i = 0; i < n; i++){
        if(inicioFim[i].first > k){
            cont++;
            k = inicioFim[i].second;
        }
    }
    cout << cont << "\n";
}