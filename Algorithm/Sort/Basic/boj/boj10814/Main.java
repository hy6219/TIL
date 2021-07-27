package sorting.boj.boj10814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //key-value=>Map?-->21세로 같은 경우 등 불편
        //Object 배열로 가자
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.valueOf(br.readLine());
        Object[][] user = new Object[T][2];

        for(int i = 0 ; i <T ;i++){
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            user[i][0] = Integer.valueOf(st.nextToken());
            user[i][1] = st.nextToken();
        }
        
        Arrays.sort(user, new Comparator<Object[]>() {
            @Override
            public int compare(Object[] o1, Object[] o2) {
                //나이가 같으면 가입순(정렬x)
                if((int)o1[0]==(int)o2[0]){
                    return 0;//음수는 정렬! 0 &양수는 정렬x
                }
                return (int)o1[0]-(int)o2[0];//기본 기준
            }
        });

        for(int i = 0; i < T; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0 ; j < 2; j++){
                sb.append(user[i][j]);
                if(j!=1){
                    sb.append(" ");
                }
            }
            System.out.println(sb);
        }

    }
}
