# 최단 경로 알고리즘

- 두 노드를 잇는 가장 짧은 경로를 찾는 문제
- 가중치 그래프에서 간선의 가중치 합이 최소가 되도록 하는 경로를 찾는 것이 목적

### 최단 경로 문제 종류

1. 단일 출발 single-source 최단 경로 문제 →다익스트라 알고리즘
- 그래프 내의 **특정 노드 u에서 출발하여 그래프 내의 모든 다른 노드에 도착**하는 가장 짧은 경로 찾기

2.단일 도착 single-destination 최단 경로 문제

- 모든 노드들로부터 출발해서 그래프 내의 특정 노드 u로 도착하는 가장 짧은 경로를 찾는 문제

3.단일 쌍 single-pair 최단 경로 문제

- 주어진 노드 u와 v 간의 최단 경로를 찾는 문제

4.전체 쌍 all-pair 최단 경로: 그래프 내의 모든 노드 쌍(u,v) 사이에 대한 최단 경로를 찾는 문제

### 다익스트라 알고리즘 로직

방향이 있는 가중치 그래프

### 1) 예제로 이해해보기

![https://github.com/hy6219/TIL/blob/main/Algorithm/shortenPath/%EC%B5%9C%EB%8B%A8%EA%B2%BD%EB%A1%9C%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98.PNG?raw=true](https://github.com/hy6219/TIL/blob/main/Algorithm/shortenPath/%EC%B5%9C%EB%8B%A8%EA%B2%BD%EB%A1%9C%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98.PNG?raw=true)

source: 패스트캠퍼스 한 번에 끝내는 코딩테스트 369 Java편 초격차 패키지 Online.

A에서 F로 가는 것을 생각해본다면

- 배열을 하나 만든다
- 그 배열에는 각 노드들에 대한 가중치가 들어가는데 처음에는 무한대로 둔다[자기 자신으로 갈 일은 없어서 0으로 넣기]
- 그 후에는 연결되는 노드들에 대해서 무한대보다 작으면 가중치값을 업데이트
- 이 때, 우선순위 큐의 맨 앞은 최소힙이라서 가중치가 작은 노드가 위치하게 된다[맨 앞 이후는 로직에 의해 달라질 수 있어서 맨앞이 중요]
- 가중치가 작은 경우를 계속적으로 더하고, 더하면서 기존 값보다 작으면 업데이트
- 다른 노드들을 다 거쳤을 때, 목적지까지 더해진 가중치 > 목적지에 저장된 가중치 라면, 파생된 다른 노드로 오는 것은 더 길 수밖에 없다는 것을 의미

→이 경우에는 그저 계산을 스킵하면 된다!

→ 자기 노드에 연결된 노드들을 찾는다는 점에서 BFS와 비슷한 느낌

*우선순위 큐를 이용하여 구현

- 우선순위 큐는 최소힙을 바탕으로 한 구조

→ 가중치 합이 작은 노드를 언제든지 pop하기 좋음

- 우선순위 큐를 사용했을 때의 장점

-지금까지 발견된 가장 짧은 거리의 노드에 대해서 먼저 계산

-더 긴 거리로 계산된 루트에 대해서는 계산을 스킵할 수 있음

🌟 다익스트라 알고리즘 정리 🌟

1) 첫 정점을 기준으로 배열을 선언하여 첫 정점에서 각 정점까지 거리를 저장

- 초기에는 첫 정점의 거리는 0, 나머지는 무한대로 저장
- 우선순위 큐에 (첫 정점, 거리0)만 먼저 넣기

2) 우선순위 큐에서 노드를 꺼냄

- 처음에는 첫 정점만 저장되어 있으므로, 첫 정점이 꺼내짐
- 첫 정점에 인접한 노드를 각각에 대해, `첫 정점에서 각 노드로 가는 거리` 와 `현재 배열에 저장되어 있는 첫 정점에서 각 정점까지의 거리`를 비교
- `첫 정점에서 각 노드로 가는 거리` <  `현재 배열에 저장되어 있는 첫 정점에서 각 정점까지의 거리` → 배열에 해당 노드의 거리 값을 갱신
- `배열에 해당 노드의 거리가 업데이트된 경우, 우선순위 큐에 넣는다`

-결과적으로 BFS와 유사하게 첫 정점에 인접한 노드들을 우선 방문하게 됨

-배열에 기록된 현재까지 발견된 가장 짧은 거리보다 더 긴 거리를 가진 경우에는 거리 계산을 스킵

3) 2)의 과정을 우선순위큐에 꺼낼 노드가 없을 때까지 반복

### 위의 그래프 구조를 자바 코드로 만들어보기

위의 경우는 BFS처럼 map 구조를 이용하면 될 것 같다

먼저, 가중치(=거리)와 노드가 하나의 단위체이므로 이를 Edge라는 클래스로 구성해보자

이때, 정렬의 기준을 위해서 Comparable을 구현하자

```java
package daikstra;

public class Edge implements Comparable<Edge>{

    public int dist;
    public String vertex;

    public Edge(int dist,String vertex){
        this.dist=dist;
        this.vertex=vertex;
    }

    @Override
    public String toString(){
        return "Edge{vertex="+this.vertex+", dist="+dist+"}";
    }

    @Override
    public int compareTo(Edge o) {
        return this.dist-o.dist;
    }
}
```

그리고 이를 이용해서 BFS와 유사하게 구조를 잡자

```java
package daikstra;

import java.util.*;

public class Daikstra {

    public static void main(String[] args){
        Map<String, ArrayList<Edge>> map=
                new HashMap<>();

        map.put("A",new ArrayList<Edge>(Arrays.asList(new Edge(8,"B"),new Edge(1,"C"),new Edge(2,"D"))));
        map.put("B",new ArrayList<Edge>());
        map.put("C",new ArrayList<Edge>(Arrays.asList(new Edge(5,"B"),new Edge(2,"D"))));
        map.put("D",new ArrayList<Edge>(Arrays.asList(new Edge(3,"E"),new Edge(5,"F"))));
        map.put("E",new ArrayList<Edge>(Arrays.asList(new Edge(1,"F"))));
        map.put("F",new ArrayList<Edge>(Arrays.asList(new Edge(2,"A"))));

        System.out.println(map);

        Set<Map.Entry<String,ArrayList<Edge>>> me=
                (Set<Map.Entry<String, ArrayList<Edge>>>) map.entrySet();

        Iterator iter=me.iterator();

        while(iter.hasNext()){
            Map.Entry<String,ArrayList<Edge>> item= (Map.Entry<String, ArrayList<Edge>>) iter.next();
            String key=item.getKey();
            ArrayList<Edge> value=item.getValue();

            System.out.println("key: "+key);
            System.out.println("value: "+value);
            System.out.println("===");
        }

    }

}
```

```java
{A=[Edge{vertex=B, dist=8}, Edge{vertex=C, dist=1}, 
Edge{vertex=D, dist=2}], B=[],
 C=[Edge{vertex=B, dist=5}, Edge{vertex=D, dist=2}], 
D=[Edge{vertex=E, dist=3}, Edge{vertex=F, dist=5}],
 E=[Edge{vertex=F, dist=1}], F=[Edge{vertex=A, dist=2}]}
key: A
value: [Edge{vertex=B, dist=8}, Edge{vertex=C, dist=1}, Edge{vertex=D, dist=2}]
===
key: B
value: []
===
key: C
value: [Edge{vertex=B, dist=5}, Edge{vertex=D, dist=2}]
===
key: D
value: [Edge{vertex=E, dist=3}, Edge{vertex=F, dist=5}]
===
key: E
value: [Edge{vertex=F, dist=1}]
===
key: F
value: [Edge{vertex=A, dist=2}]
===
```

### 구현하기

### STEP 01.  초기화

1) 첫 정점을 기준으로 배열을 선언하여 첫 정점에서 각 정점까지 거리를 저장

- 초기에는 첫 정점의 거리는 0, 나머지는 무한대로 저장
- 우선순위 큐에 (첫 정점, 거리0)만 먼저 넣기

```java
package daikstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class ShortenTemplate {

    //HashMap<String,Integer>:정점, 거리
    public HashMap<String,Integer> dijkstraFunc(HashMap<String, ArrayList<Edge>> graph,String start){
        //거리저장배열
        HashMap<String, Integer> distances=new HashMap<>();
        //우선순위 큐
        Queue<Edge> pq=new PriorityQueue<>();

        //모든 정점들을 가져와서 distances에 대해서 각 정점의 value는 infinite=Integer.MAX_VALUE로 초기화
        for(String key: graph.keySet()){
            distances.put(key,Integer.MAX_VALUE);
        }
        //처음 시작노드는 0으로 두기
        distances.put(start,0);
        //우선순위큐에 시작노드에 대한 정보만 넣기
        pq.add(new Edge(distances.get(start),start));

        //알고리즘 작성
        return distances;

    }

}
```

```java
package daikstra;

import java.util.*;

public class Daijkstra {

    public static void main(String[] args){
        HashMap<String, ArrayList<Edge>> map= new HashMap<>();

        map.put("A",new ArrayList<Edge>(Arrays.asList(new Edge(8,"B"),new Edge(1,"C"),new Edge(2,"D"))));
        map.put("B",new ArrayList<Edge>());
        map.put("C",new ArrayList<Edge>(Arrays.asList(new Edge(5,"B"),new Edge(2,"D"))));
        map.put("D",new ArrayList<Edge>(Arrays.asList(new Edge(3,"E"),new Edge(5,"F"))));
        map.put("E",new ArrayList<Edge>(Arrays.asList(new Edge(1,"F"))));
        map.put("F",new ArrayList<Edge>(Arrays.asList(new Edge(2,"A"))));

        ShortenTemplate st=new ShortenTemplate();
        System.out.println(st.dijkstraFunc(map,"A"));

        }

}
```

```java
{A=0, B=2147483647, C=2147483647, D=2147483647, E=2147483647,
 F=2147483647}
```

여기서 "2147483647"은 Integer.MAX_VALUE를 의미한다

즉, 처음 노드만 0으로 설정되고 나머지는 최댓값으로 초기화되었음을 확인해볼 수 있다

### STEP02. 다익스트라 알고리즘

2) 우선순위 큐에서 노드를 꺼냄

- 처음에는 첫 정점만 저장되어 있으므로, 첫 정점이 꺼내짐
- 첫 정점에 인접한 노드를 각각에 대해, `첫 정점에서 각 노드로 가는 거리` 와 `현재 배열에 저장되어 있는 첫 정점에서 각 정점까지의 거리`를 비교
- `첫 정점에서 각 노드로 가는 거리` <  `현재 배열에 저장되어 있는 첫 정점에서 각 정점까지의 거리` → 배열에 해당 노드의 거리 값을 갱신
- `배열에 해당 노드의 거리가 업데이트된 경우, 우선순위 큐에 넣는다`

-결과적으로 BFS와 유사하게 첫 정점에 인접한 노드들을 우선 방문하게 됨

-배열에 기록된 현재까지 발견된 가장 짧은 거리보다 더 긴 거리를 가진 경우에는 거리 계산을 스킵

3) 2)의 과정을 우선순위큐에 꺼낼 노드가 없을 때까지 반복

```java
package daikstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class ShortenTemplate {

    //HashMap<String,Integer>:정점, 거리
    public HashMap<String,Integer> dijkstraFunc(HashMap<String, ArrayList<Edge>> graph,String start){
        //1.초기화
        //거리저장배열
        HashMap<String, Integer> distances=new HashMap<>();
        //우선순위 큐
        Queue<Edge> pq=new PriorityQueue<>();

        //모든 정점들을 가져와서 distances에 대해서 각 정점의 value는 infinite=Integer.MAX_VALUE로 초기화
        for(String key: graph.keySet()){
            distances.put(key,Integer.MAX_VALUE);
        }
        //처음 시작노드는 0으로 두기
        distances.put(start,0);
        //우선순위큐에 시작노드에 대한 정보만 넣기
        pq.add(new Edge(distances.get(start),start));

        //poll된 노드
        Edge edge=null;
        //현재 keep해둘 poll된 노드의 거리와 정점정보 저장
        String curNode;
        int curDist;
        //노드에 연결된 리스트 정보 가져오기
        ArrayList<Edge> nodeList;

        Edge adjacentNode;
        String adjacent;
        int weight;
        int dist;

        //2.알고리즘 작성
        //우선순위큐가 채워져 있는 동안 반복
        while(pq.size()>0){
            //첫 번째 노드를 가져오기
            edge=pq.poll();
            //현재 keep해둘 poll된 노드의 거리와 정점정보 저장
            curDist=edge.dist;
            curNode=edge.vertex;

            //지금까지 저장된 배열에서의 값<비교할 값(첫 정점에서 각 노드로 가는 거리)
            if(distances.get(curNode)<curDist){
                //업데이트 x
                continue;
            }

            //노드에 연결된 리스트 정보 가져오기
            nodeList=graph.get(curNode);

            for(int idx=0;idx< nodeList.size();idx++){
                //pop된 노드와 연결된 정점들
                adjacentNode=nodeList.get(idx);
                adjacent=adjacentNode.vertex;
                weight=adjacentNode.dist;

                dist=curDist+weight;//가중치합을 통해 업데이트할 지 판단하기 위함
                if(dist<distances.get(adjacent)){
                    //update
                    distances.put(adjacent,dist);
                    pq.add(new Edge(dist,adjacent));//우선순위큐에 넣기
                }
            }
        }

        return distances;

    }

}
```

```java
package daikstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class ShortenTemplate {

    //HashMap<String,Integer>:정점, 거리
    public HashMap<String,Integer> dijkstraFunc(HashMap<String, ArrayList<Edge>> graph,String start){
        //1.초기화
        //거리저장배열
        HashMap<String, Integer> distances=new HashMap<>();
        //우선순위 큐
        Queue<Edge> pq=new PriorityQueue<>();

        //모든 정점들을 가져와서 distances에 대해서 각 정점의 value는 infinite=Integer.MAX_VALUE로 초기화
        for(String key: graph.keySet()){
            distances.put(key,Integer.MAX_VALUE);
        }
        //처음 시작노드는 0으로 두기
        distances.put(start,0);
        //우선순위큐에 시작노드에 대한 정보만 넣기
        pq.add(new Edge(distances.get(start),start));

        //poll된 노드
        Edge edge=null;
        //현재 keep해둘 poll된 노드의 거리와 정점정보 저장
        String curNode;
        int curDist;
        //노드에 연결된 리스트 정보 가져오기
        ArrayList<Edge> nodeList;

        Edge adjacentNode;
        String adjacent;
        int weight;
        int dist;

        //알고리즘 작성
        //우선순위큐가 채워져 있는 동안 반복
        while(pq.size()>0){
            //첫 번째 노드를 가져오기
            edge=pq.poll();
            //현재 keep해둘 poll된 노드의 거리와 정점정보 저장
            curDist=edge.dist;
            curNode=edge.vertex;

            //지금까지 저장된 배열에서의 값<비교할 값(첫 정점에서 각 노드로 가는 거리)
            if(distances.get(curNode)<curDist){
                //업데이트 x
                continue;
            }

            //노드에 연결된 리스트 정보 가져오기
            nodeList=graph.get(curNode);

            for(int idx=0;idx< nodeList.size();idx++){
                //pop된 노드와 연결된 정점들
                adjacentNode=nodeList.get(idx);
                adjacent=adjacentNode.vertex;
                weight=adjacentNode.dist;

                dist=curDist+weight;//가중치합을 통해 업데이트할 지 판단하기 위함
                if(dist<distances.get(adjacent)){
                    //update
                    distances.put(adjacent,dist);
                    pq.add(new Edge(dist,adjacent));//우선순위큐에 넣기
                }
            }
        }

        return distances;

    }

}
```

```java
{A=0, B=6, C=1, D=2, E=5, F=6}
```

그러면 A에서 시작해서 각 지점에 도착하는 최단거리가 계산되어 보여진다

## 시간 복잡도

- 과정1: 각 노드마다 인접한 간선들을 모두 검사 O(E)[E:Edge]
- 과정2: 우선순위 큐에 노드 및 거리 정보를 넣고 pop하는 과정 :

-각 간선마다 우선순위 큐애 추가하는 과정: O(E)

-O(E)개의 노드 및 거리 정보를 유지하는 과정:O(logE)

→ O(ElogE)

## 총 시간 복잡도

=과정 1+ 과정 2

=O(E+ElogE)

=O(ElogE)

(←차수가 낮은 것은 무시됨)