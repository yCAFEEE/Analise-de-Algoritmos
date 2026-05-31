import java.util.*;

class H{
    public static Integer[][] memo;
    public static int solve(String str1, String str2, int i, int j){
        if(i < 0 || j < 0)
            return 0;
        if(memo[i][j] != null)
            return memo[i][j];

        if(str1.charAt(i) == str2.charAt(j))
            return memo[i][j] = solve(str1, str2, i-1, j-1) + 1;
        else
            return memo[i][j] = Math.max(solve(str1, str2, i-1, j), solve(str1, str2, i, j-1));
    }

    public static StringBuilder resul;
    public static StringBuilder constroiString(String str1, String str2, int i, int j){
        if(i < 0 || j < 0)
            return resul;

        if(str1.charAt(i) == str2.charAt(j)){
            resul.append(str1.charAt(i));
            return constroiString(str1, str2, i-1, j-1);
        }else{
            if(i > 0 && j > 0){
                if(memo[i-1][j] > memo[i][j-1])
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

    public static void main(String[] args){
        Scanner le = new Scanner(System.in);
        int n = le.nextInt();
        int m = le.nextInt();

        String str1 = le.next();
        String str2 = le.next();
        le.close();

        memo = new Integer[n][m];
        int valLcs = solve(str1, str2, n-1, m-1);
        resul = new StringBuilder("");
        StringBuilder strLcs = constroiString(str1, str2, n-1, m-1);

        System.out.println(valLcs + "\n" + strLcs.reverse());
    }
}