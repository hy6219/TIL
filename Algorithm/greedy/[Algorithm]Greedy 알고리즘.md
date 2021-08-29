# 탐욕 알고리즘 Greedy algorithm

- 최적의 해에 가까운 값을 구하기 위해서 사용됨
- 여러 경우 중 하나를 결정해야할 때마다, `매순간 최적이라고 생각되는 경우를 선택`하는 방식으로 진행해서, 최종적인 값을 구하는 방식
- 동적계획법이나 분할정복과 같은 일종의 "전략"

## *탐욕 알고리즘 예시*

### 문제1. 동전문제

- 지불해야 하는 값이 4720원일 때, 1원 50원 100원 500원 동전으로 동전의 수가 가장 적게 지불하시오

→ 단위금액이 가장 큰 동전부터 갯수를 큰 경우부터 대입해서 매 순간 최적이라고 생각되는 경우를 선택

(생각 정리)(쪼개서 생각)

1. 4720원=500원*9개+220원
2. →220원=100원*2개+20원=100원*2개+1원*20개→총 31개
3. 220원=100원*1개+120원=100원*1개+50원*2개+1원*20개→32개
4. 220원=100원*0개+50원*4개+1원*20개→33개

따라서! 2번 케이스가 베스트!

(정리)

1. 단위가 큰 순으로 금액으로 가질 수 있는 최대 갯수를 몫을 이용해서 찾고 더하기
2. 금액은 1로 구해지는 금액을 제한 금액으로 업데이트
- 혹시 몰라서 입력으로 들어온 동전 단위는 내림차순 정렬을 해주었다

```java
package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Coin {

    //금액과 코인 종류를 넣기
    public static int best(int price, ArrayList<Integer> coinList){
        //최종 동전 갯수
        Integer total=0;
        //각각의 동전이 지불 금액을 맞출 때의 갯수
        Integer coinNum=0;
        //실제 동작
        ArrayList<Integer> details=new ArrayList<>();

        //내림차순 정렬
        Collections.sort(coinList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1<o2){
                    return 1;
                }
                return -1;
            }
        });
        for(int idx=0; idx<coinList.size();idx++){
            **coinNum=price/coinList.get(idx);
            total+=coinNum;
            //다음에 타깃이 될 금액이 변동됨
            price-=coinNum*coinList.get(idx);
						System.out.println(coinList.get(idx)+"원 갯수: "+coinNum+" 개");**
        }

        return total;
    }

    public static void main(String[] args){

        ArrayList<Integer> coins=new ArrayList<>(Arrays.asList(1,50,100,500));
        System.out.println("동전 종류: "+coins);

        int totalCnt=best(4720,coins);
        System.out.println("최적 갯수: "+totalCnt+" 개");

    }
}
```

```java
동전 종류: [1, 50, 100, 500]
500원 갯수: 9 개
100원 갯수: 2 개
50원 갯수: 0 개
1원 갯수: 20 개
최적 갯수: 31 개
```

### 문제 2. 부분 배낭 문제 Fractional Knapsack Problem

- 무게 제한이 k인 베낭에 최대 가치를 가지도록 물건을 넣는 문제
- 각 물건은 무게(w)와 가치(v)로 표현
- **물건은 쪼갤 수 있으므로(현실적으로는 생각하지 않기)** 물건의 일부분이 베낭에 넣어질 수 있어서 Fractional Knapsack Problem으로 불림
- 0/1  Knapsack Problem: 이와 반대되는 개념으로 ,물건을 쪼개서 넣을 수 없는 배낭 문제

![https://github.com/hy6219/TIL/blob/main/Algorithm/greedy/%EB%B6%80%EB%B6%84%20%EB%B0%B0%EB%82%AD%20%EB%AC%B8%EC%A0%9C.PNG?raw=true](https://github.com/hy6219/TIL/blob/main/Algorithm/greedy/%EB%B6%80%EB%B6%84%20%EB%B0%B0%EB%82%AD%20%EB%AC%B8%EC%A0%9C.PNG?raw=true)

source: 패스트캠퍼스 한 번에 끝내는 코딩테스트 369 Java편 초격차 패키지 Online.

→ 가치(v) /무게(w)즉, 단위 무게 당 가치의 비율이 높은 것을 가장 먼저 넣게 됨[무게가 적으면서도 가치도 적절한 경우]

1. 위의 구조를 2차원 배열로 생각해보기

```java
package greedy;

import java.util.Arrays;

public class FractionalKnapsack {

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
    }
}
```

(연습) Edge라는 클래스를 만들어서, 정점과 거리에 대한 필드를 관리하도록 하자

```java
package greedy;

public class Edge {
    public Integer distance;
    public String vertex;

    public Edge(Integer distance, String vertex) {
        this.distance = distance;
        this.vertex = vertex;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "distance=" + distance +
                ", vertex='" + vertex + '\'' +
                '}';
    }
}
```

이를 이용해서 오름차순으로 정렬하는 것을 연습해보자

```java
package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {

    public static void main(String[] args){
        //물건
        int[][] knapSack={
                {10,10},
                {15,12},
                {20,10},
                {25,8},
                {30,5}
        };

   

        Edge edge1=new Edge(10,"A");
        Edge edge2=new Edge(12,"A");
        Edge edge3=new Edge(13,"A");

        Edge[] edges=new Edge[]{edge1,edge2,edge3};

        Arrays.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
               int x1=o1.distance;
							 int x2=o2.distance;
							
							if(x1>x2){
								return 1;
              }
								return -1;
            }
        });
        System.out.println(Arrays.toString(edges));
    }
}
```

🌟 Comparable과 Comparator 인터페이스 🌟

1. Comparable 인터페이스: compareTo()메서드를 오버리이딩[기본적인 정렬을 하고자 할 경우 자주 사용됨]
2. Comparator 인터페이스: compare()메서드를 오버라이딩해서 구현하고, 일반적으로는 별도 클래스를 정의해서 구현[동일 객체에 대해서 다양한 정렬 기준을 가진 클래스에서 정렬을 하고자 할 때 자주 사용됨]
3. 하나의 객체에 ***Comparable 인터페이스가 정의되어 있더라도, Comparator 인자가 Arrays.sort의 인자값으로써 전달된다면, Comparator의 우선순위가 더 높아서 Comparator의 정렬 기준으로 정렬***이 된다

위와 같이 간단하게 작성할 수도 있지만, Edge 클래스에 대한 comparator를 구현체로 만들어서 적용해보자

```java
package greedy;

import java.util.Comparator;

public class EdgeComparator implements Comparator<Edge> {

    @Override
    public int compare(Edge o1, Edge o2) {
        return o1.distance-o2.distance;
    }
}
```

```java
package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {

    public static void main(String[] args){
        //물건
        int[][] knapSack={
                {10,10},
                {15,12},
                {20,10},
                {25,8},
                {30,5}
        };

        //비율에 대해서 정렬

        Edge edge1=new Edge(13,"A");
        Edge edge2=new Edge(12,"A");
        Edge edge3=new Edge(10,"A");

        Edge[] edges=new Edge[]{edge1,edge2,edge3};

        Arrays.sort(edges,new EdgeComparator());

        System.out.println(Arrays.toString(edges));
    }
}
```

```java
[Edge{distance=10, vertex='A'}, Edge{distance=12, vertex='A'}, Edge{distance=13, vertex='A'}]
```

Comparable도 사용해보자! 

```java
package greedy;

public class Edge implements Comparable<Edge>{
    public Integer distance;
    public String vertex;

    public Edge(Integer distance, String vertex) {
        this.distance = distance;
        this.vertex = vertex;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "distance=" + distance +
                ", vertex='" + vertex + '\'' +
                '}';
    }

    @Override
    public int compareTo(Edge o) {
        return this.distance-o.distance;
    }
}
```

```java
package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {

    public static void main(String[] args){
        //물건
        int[][] knapSack={
                {10,10},
                {15,12},
                {20,10},
                {25,8},
                {30,5}
        };

        //비율에 대해서 정렬

        Edge edge1=new Edge(13,"A");
        Edge edge2=new Edge(12,"A");
        Edge edge3=new Edge(10,"A");

        Edge[] edges=new Edge[]{edge1,edge2,edge3};

        Arrays.sort(edges);

        System.out.println(Arrays.toString(edges));
    }
}
```

```java
[Edge{distance=10, vertex='A'}, Edge{distance=12, vertex='A'}, Edge{distance=13, vertex='A'}]
```

1. 규칙 정리
- 무게, 가치 가 담긴 배열을 가치/무게 비율에 대해서 내림차순 정렬
- 정렬이 되어있기 때문에 비율이 큰 것부터 담길 수 있다
- 최대가치 maxValue와 물건의 몇 프로가 담기는 지 그 비율에 대한 변수 fraction을 준비

-fraction이 등장했다는 것은, 더이상 담을 수 없다는 것을 의미하므로, 그 이후에는 담는 것을 그만해도 좋다

- 배열의 길이만큼만(=2차원이므로 행의 갯수만큼=물건 갯수만큼) 반복

-무게제한과 해당순서의 무게를 비교해서 여유가 있으면(무게제한>현재 무게) 쪼개지 않고 담을 수 있고, 

그러면 무게제한은 현재 무게만큼 감소될 것이며

최대가치는 현재 가치만큼 증가할 것

-무게제한<현재무게 라면 `이후에는 더이상 일련의 반복작업을 하지 않아도 된다는 뜻을 의미하며, 무게제한은 변동이 없을 것이며, 쪼갤 비율=무게제한/현재무게, 최대가치+=현재가치*쪼갤비율`

이 된다

```java
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
```

```java
10 10 
15 12 
20 10 
25 8 
30 5 
자르지 않은 물건의 무게: 10.0, 가치: 10.0
자르지 않은 물건의 무게: 15.0, 가치: 12.0
자르지 않은 물건의 무게: 20.0, 가치: 10.0
자른 물건의 무게: 25.0, 가치: 8.0, 자른 비율: 0.2
무게제한 50에서 총 담을 수 있는 총 가치: 33.6
```

## 탐욕 알고리즘의 한계

- 근사치 추정에 활용 ← 반드시 최적의 해를 구할 수 있는 것은 아니기 때문
- →단순히 최적의 해에 가까운 값을 구하는 방법 중 하나