package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {

    //items:물건 표, wLimit:무게제한
    public static double knapSackFunc(int[][] items, double wLimit){
        //물건을 쪼개기 때문에 소수점으로 계산될 것
        //최대 가치
        double maxValue=0.0;
        //물건의 몇 프로가 저장되었는지 저장
        double fraction=0.0;

        Arrays.sort(items, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                double item1=o1[1]/(double)o1[0];
                double item2=o2[1]/(double)o2[0];

                if(item1<item2){
                    return 1;//정렬대상!(기준=내림차순)
                }
                return -1;

            }
        });

        //정렬된 배열을 가지고 순회하면서
        // 각 물건의 무게값보다 무게제한이 크면 쪼개지 않고 넣고
        //아니라면, 가능한 만큼만 넣기
        for(int idx=0; idx<items.length;idx++){
            double weight=(double)items[idx][0];
            double value=(double)items[idx][1];

            if(wLimit>weight){
                //쪼개지 않아도 될 것
                wLimit-=weight;
                maxValue+=value;
                System.out.println("자르지 않은 물건의 무게: "+weight+", 가치: "+value);
            }else{
                //쪼개야 할 경우
                //전체 하중 제한을 지금 물건의 하중으로 나누어 쪼갤 수 있는 비율 구하기
                fraction=wLimit/weight;
                maxValue+=value*fraction;
                //하중 변경은 변경이 0이나 마찬가지
                System.out.println("자른 물건의 무게: "+weight+", 가치: "+value+", 자른 비율: "+fraction);
                //그런데 위와 같이 부분만 넣었다는 것은, 어차피 더이상은
                //못넣는다는 것이기 때문에 종료하기
                break;
            }
        }
        return maxValue;
    }

    public static void main(String[] args){
        //물건
        int[][] knapSack={
                {10,10},
                {15,12},
                {20,10},
                {25,8},
                {30,5}
        };

        for(int i=0; i< 5; i++){
            for(int j=0; j<2;j++){
                System.out.print(knapSack[i][j]+" ");
            }
            System.out.println();
        }

        double value=knapSackFunc(knapSack,50.0);
        System.out.println("무게제한 50에서 총 담을 수 있는 총 가치: "+value);


    }
}
