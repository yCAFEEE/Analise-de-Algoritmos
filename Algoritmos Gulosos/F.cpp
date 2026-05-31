#include <bits/stdc++.h>

using namespace std;

int main(){
    int n;

    cin >> n;
    vector<pair<int, int>> lr(n);

    for(int i = 0; i < n; i++){
        cin >> lr[i].first;
        cin >> lr[i].second;
    }

    sort(lr.begin(), lr.end(), [](const pair<int,int>& a, const pair<int,int>& b){ if(a.first != b.first){return a.first < b.first;} return a.second > b.second; });

    int max_r = -1;
    int cont = n;
    for(int i = 0; i < n; i++){
        if(lr[i].second <= max_r){
            cont--;
        }else{
            max_r = lr[i].second;
        }
    }

    cout << cont << "\n";
    return 0;
}