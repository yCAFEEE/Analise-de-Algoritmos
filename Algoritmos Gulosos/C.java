import java.io.*;
import java.util.*;

class C{
    public static int stringParaSeg(String input){
        int tempoSeg = (Integer.parseInt(input.substring(0, 2)) * 3600) 
        + (Integer.parseInt(input.substring(3, 5)) * 60)
        + (Integer.parseInt(input.substring(6, 8)));
        return tempoSeg;
    }

    public static int resolve(int[] chegada, int[] saida){
        int cont = 0;
        int maxCont = Integer.MIN_VALUE;
        int i = 0, j = 0;
        while(i < chegada.length){
            if(chegada[i] <= saida[j]){
                cont++;
                i++;
            }else{
                cont--;
                j++;
            }
            maxCont = Math.max(cont, maxCont);
        }
        return maxCont;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[][] tempos = new String[n][2];
        int[] chegada = new int[n];
        int[] saida = new int[n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            tempos[i][0] = st.nextToken();
            tempos[i][1] = st.nextToken();
            chegada[i] = stringParaSeg(tempos[i][0]);
            saida[i] = stringParaSeg(tempos[i][1]);
        }

        Arrays.sort(chegada);
        Arrays.sort(saida);
        
        System.out.println(resolve(chegada, saida));
    }
}