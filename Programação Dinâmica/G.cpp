#include <bits/stdc++.h>

using namespace std;

using llu = long long unsigned int;

int main(){
    int n, w;
    cin >> n >> w;

    vector<int> pesos(n+1);
    vector<int> valor(n+1);
    for(int i = 1; i <= n; i++){
        cin >> pesos[i] >> valor[i];
    }
    vector<vector<llu>> dp(n+1, vector<llu>(w+1, 0));

    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= w; j++){
            if(pesos[i] <= j)
                dp[i][j] = max(dp[i-1][j], dp[i-1][j-pesos[i]] + valor[i]);
            else
                dp[i][j] = dp[i-1][j];
        }
    }

    cout << dp[n][w] << "\n";
}