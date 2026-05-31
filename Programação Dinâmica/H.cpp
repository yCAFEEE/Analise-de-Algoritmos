#include <bits/stdc++.h>

using namespace std;

vector<vector<int>> dp;

int resolve(const string &str1, const string &str2, int i, int j){
    if(i < 0 || j < 0) return 0;

    if(dp[i][j] != -1)
        return dp[i][j];

    if(str1[i] == str2[j])
        return dp[i][j] = resolve(str1, str2, i-1, j-1) + 1;
    else
        return dp[i][j] = max(resolve(str1, str2, i-1, j), resolve(str1, str2, i, j-1));
}

string resul = "";
string constroiString(const string &str1, const string &str2, int i, int j){
    if(i < 0 || j < 0)
        return resul;
    
    if(str1[i] == str2[j]){
        resul += str1[i];
        return constroiString(str1, str2, i-1, j-1);
    }else{
        if(i > 0 && j > 0){
            int cima = (dp[i-1][j] == -1) ? 0 : dp[i-1][j];
            int esquerda = (dp[i][j-1] == -1) ? 0 : dp[i][j-1];
            if(cima > esquerda)
                return constroiString(str1, str2, i-1, j);
            else
                return constroiString(str1, str2, i, j-1);
        }else if(i == 0){
            return constroiString(str1, str2, i, j-1);
        }else{
            return constroiString(str1, str2, i-1, j);
        }
    }
}

int main(){
    int n, m;
    string str1, str2;

    cin >> n >> m;
    cin >> str1 >> str2;

    dp.assign(n, vector<int>(m, -1));
    int tamLcs = resolve(str1, str2, n-1, m-1);
    string outroResul = constroiString(str1, str2, n-1, m-1);
    reverse(outroResul.begin(), outroResul.end());
    cout << tamLcs << "\n" << outroResul << "\n";
}
