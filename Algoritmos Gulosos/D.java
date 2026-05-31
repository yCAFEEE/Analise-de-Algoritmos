import java.util.*;

public class D {
    public static void main(String[] args){
        Scanner le = new Scanner(System.in);
        int n = le.nextInt();

        boolean valido = true;
        int cont = 0;
        for(int i = 0; i < n; i++){
            String str = le.nextLine();
            for(int j = 0; j < str.length(); j++){
                if(str.charAt(j) == '(') cont++;
                else cont--;
            }
        }
        
    }
}
