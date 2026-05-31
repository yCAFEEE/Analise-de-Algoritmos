import java.io.*;
import java.util.*;

class E{
    public static int resolve(int[] frames, int[] paginas, int[] ocorrencias){
        int cacheMisses = 0;
        for(int i = 0; i < paginas.length; i++){
            boolean cacheHit = false;
            for(int j = 0; j < frames.length; j++){
                if(frames[j] == paginas[i]){
                    cacheHit = true;
                    break;
                }
            }
            if(cacheHit) continue;
            
            boolean espacoPreenchido = false;
            for(int j = 0; j < frames.length; j++){
                if(frames[j] == 0){
                    frames[j] = paginas[i];
                    cacheMisses++;
                    espacoPreenchido = true;
                    break;
                }
            }
            if(espacoPreenchido) continue;

            boolean slaPraQueIssoServe = true;
            int reqMaisDistante = -1;
            int idxReqMD = -1;
            int idxSubstituto = -1;
            for(int j = 0; j < frames.length; j++){
                boolean noReq = true;
                for(int l = i; l < paginas.length; l++){
                    if(frames[j] == paginas[l]){
                        noReq = false;
                        if(ocorrencias[l] > reqMaisDistante){
                            reqMaisDistante = ocorrencias[l];
                            idxReqMD = l;
                            idxSubstituto = j;
                        }
                        break;
                    }
                }
                
                if(noReq){
                    frames[j] = paginas[i];
                    cacheMisses++;
                    slaPraQueIssoServe = false;
                    break;
                }
            }
            if(!slaPraQueIssoServe){
                frames[idxSubstituto] = paginas[idxReqMD];
                cacheMisses++;
            }
        }
        return cacheMisses;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        
        int[] frames = new int[k];
        int[] paginas = new int[n];
        int[] ocorrencias = new int[1000];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            paginas[i] = Integer.parseInt(st.nextToken());
            ocorrencias[i] = i+1;
        }

        System.out.println(resolve(frames, paginas, ocorrencias));
    }
}