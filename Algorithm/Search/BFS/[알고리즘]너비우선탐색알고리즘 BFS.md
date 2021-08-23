# [알고리즘]너비 우선 탐색 BFS(Breadth First Search)

## 01. 대표적인 그래프 탐색 알고리즘 BFS와 DFS

- 비순환, 무방향 그래프! 사이클이 없음!
- BFS(Breadth First Search) : 정점들과 같은 레벨에 있는 노드들(형제 노드들)을 먼저 탐색[너비우선]

![https://miro.medium.com/max/1400/1*nhuQGHyODuWnO1-GZOsQCQ.gif](https://miro.medium.com/max/1400/1*nhuQGHyODuWnO1-GZOsQCQ.gif)

source: [https://miro.medium.com/max/1400/1*nhuQGHyODuWnO1-GZOsQCQ.gif](https://miro.medium.com/max/1400/1*nhuQGHyODuWnO1-GZOsQCQ.gif)

- DFS(Depth First Search) : 정점의 자식들을 먼저 탐색하는 방식[깊이우선]

![https://upload.wikimedia.org/wikipedia/commons/7/7f/Depth-First-Search.gif](https://upload.wikimedia.org/wikipedia/commons/7/7f/Depth-First-Search.gif)

source : [https://upload.wikimedia.org/wikipedia/commons/7/7f/Depth-First-Search.gif](https://upload.wikimedia.org/wikipedia/commons/7/7f/Depth-First-Search.gif)

## 02. 자바로 너비우선탐색 생각해보기

![https://github.com/hy6219/TIL/blob/main/Algorithm/Search/BFS/BFS%20%ED%91%9C%ED%98%84.PNG?raw=true](https://github.com/hy6219/TIL/blob/main/Algorithm/Search/BFS/BFS%20%ED%91%9C%ED%98%84.PNG?raw=true)

source: 패스트캠퍼스 알고리즘 강의(한 번에 끝내는 코딩테스트 369 Java편 초격차 패키지 Online.)

연결된 형태 및 관계가 마치 키-밸류로 되어있어서 Map구조와 ArrayList를 사용해볼 수 있다

```java
package search.breadth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class BFS {
    public static void main(String[] args){
        HashMap<String, ArrayList<String>> mapData1=new HashMap<>();
        mapData1.put("A",new ArrayList<String>(Arrays.asList("B","C")));
        mapData1.put("B",new ArrayList<String>(Arrays.asList("A","D")));
        mapData1.put("C",new ArrayList<String>(Arrays.asList("A","G","H","I")));
        mapData1.put("D",new ArrayList<String>(Arrays.asList("B","E","F")));
        mapData1.put("E",new ArrayList<String>(Arrays.asList("D")));
        mapData1.put("F",new ArrayList<String>(Arrays.asList("D")));
        mapData1.put("G",new ArrayList<String>(Arrays.asList("C")));
        mapData1.put("H",new ArrayList<String>(Arrays.asList("C")));
        mapData1.put("I",new ArrayList<String>(Arrays.asList("C","J")));
        mapData1.put("J",new ArrayList<String>(Arrays.asList("I")));

        System.out.println(mapData1);
    }

}
```

우선 연습한다고 생각하자! 이렇게 입력해주면 손은 아프겠지만 😭

```java
{A=[B, C], B=[A, D], C=[A, G, H, I], D=[B, E, F], E=[D], F=[D], G=[C], H=[C], I=[C, J], J=[I]}
```

그러면 위에서 정리한 관계별 데이터를 확인해볼 수 있게 된다!

## 03. BFS 알고리즘 구현

- visited(방문한 노드들을 담은 큐)와 needVisit(방문해야 할 노드들을 담은 큐)로 두개의 큐를 이용

-알고리즘 중 일부인 리스트에 넣고, 앞에 있는 값을 빼내어 보자

```java
package search.breadth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class BFS {
    public static void main(String[] args){

        ArrayList<String> list= new ArrayList<>();
        list.add("A");
        list.add("B");

        String node=list.remove(0);
        System.out.println(list);
        System.out.println(node);

    }

}
```

```java
[B]
A
```

-해당 데이터가 있는지를 확인해서 방문해야할 큐에서 제외시키기 위해서

-"값"이 존재하는지 찾을 필요가 있다!

```java
package search.breadth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class BFS {
    public static void main(String[] args){

        ArrayList<String> list= new ArrayList<>();
        list.add("A");
        list.add("B");

        String node=list.remove(0);
        System.out.println(list);
        System.out.println(node);
        **System.out.println(list.contains("A"));**
    }

}
```

```java
[B]
A
**false**
```

위에서 봤던 표에서 리스트 형태로 된 밸류가 묶여져 있는데, 반복문을 사용해도 되지만  `list 구조의 addAll` 과 `map의 get(key)`를 이용하면 가능하다!

```java
package search.breadth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class BFS {
    public static void main(String[] args){
        HashMap<String, ArrayList<String>> mapData1=new HashMap<>();
        mapData1.put("A",new ArrayList<String>(Arrays.asList("B","C")));
        mapData1.put("B",new ArrayList<String>(Arrays.asList("A","D")));
        mapData1.put("C",new ArrayList<String>(Arrays.asList("A","G","H","I")));
        mapData1.put("D",new ArrayList<String>(Arrays.asList("B","E","F")));
        mapData1.put("E",new ArrayList<String>(Arrays.asList("D")));
        mapData1.put("F",new ArrayList<String>(Arrays.asList("D")));
        mapData1.put("G",new ArrayList<String>(Arrays.asList("C")));
        mapData1.put("H",new ArrayList<String>(Arrays.asList("C")));
        mapData1.put("I",new ArrayList<String>(Arrays.asList("C","J")));
        mapData1.put("J",new ArrayList<String>(Arrays.asList("I")));

        ArrayList<String> list= new ArrayList<>();
        list.add("A");
        list.add("B");

        String node=list.remove(0);
        System.out.println(list);
        System.out.println(node);
        System.out.println(list.contains("A"));
        ArrayList<String> aList=new ArrayList<>();
        aList.add("C");
        **aList.addAll(mapData1.get("A"));
        System.out.println(aList);**
    }

}
```

```java
(생략)
**[C, B, C]**
```

🌟 **BFS 알고리즘 정리** 🌟

ⓐ 인자값으로 `HashMap<String,ArrayList<String>>과 시작노드(String startNode-key값)`을 넣자

ⓑ 방문한 노드를 위한 큐와 방문해야할 노드를 위한 큐를 준비

ⓒ `방문해야할 노드에 시작 노드만 넣어주자`

ⓓ 방문해야할 노드가 아직 있다면 `(while(needVisit.size()>0))` 

- 방문해야할 노드에서 첫 번째 요소를 빼내어서
- 방문한 노드에 그 노드가 존재하지 않는다면, 방문한 노드에 추가하고, 방문해야할 노드에는 그 노드와 연결된 ArrayList를 넣기

ⓔ while문으로 반복을 다했다면, 즉 방문할 노드가 없다면 방문한 순서대로 탐색된 큐인 visited를 리턴

```java
package search.breadth;

import java.util.ArrayList;
import java.util.HashMap;

public class BFSSearch {
    public ArrayList<String> bfsFunc(HashMap<String,ArrayList<String>> graph,String startNode){
        //방문한 노드
        ArrayList<String> visited=new ArrayList<>();
        //방문해야 할 노드
        ArrayList<String> needVisit=new ArrayList<>();

        //시작 노드만 넣어주기
        needVisit.add(startNode);

        //방문해야할 노드가 아직 있다는 것
        while(needVisit.size()>0){
            //첫 번째 요소를 제거
            String node= needVisit.remove(0);
            //해당노드가 visited에 있는지 확인해보고 없으면 visited에 추가
            if(!visited.contains(node)){
                visited.add(node);
                // 해당노드에 연결되어있던 노드들(arrayList)을 방문해야 하므로 추가하기!
                needVisit.addAll(graph.get(node));
            }
        }
        //방문할 노드가 없다면(while이 끝나고)
        //방문한 순서대로 탐색된 큐를 리턴
        return visited;
    }
}
```

```java
package search.breadth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class BFS {
    public static void main(String[] args){
        HashMap<String, ArrayList<String>> mapData1=new HashMap<>();
        mapData1.put("A",new ArrayList<String>(Arrays.asList("B","C")));
        mapData1.put("B",new ArrayList<String>(Arrays.asList("A","D")));
        mapData1.put("C",new ArrayList<String>(Arrays.asList("A","G","H","I")));
        mapData1.put("D",new ArrayList<String>(Arrays.asList("B","E","F")));
        mapData1.put("E",new ArrayList<String>(Arrays.asList("D")));
        mapData1.put("F",new ArrayList<String>(Arrays.asList("D")));
        mapData1.put("G",new ArrayList<String>(Arrays.asList("C")));
        mapData1.put("H",new ArrayList<String>(Arrays.asList("C")));
        mapData1.put("I",new ArrayList<String>(Arrays.asList("C","J")));
        mapData1.put("J",new ArrayList<String>(Arrays.asList("I")));

        BFSSearch bs= new BFSSearch();
        System.out.println(bs.bfsFunc(mapData1,"A"));
    }

}
```

```java
[A, B, C, D, G, H, I, E, F, J]
```

📌 시간 복잡도

- 노드 수: V
- 간선 수: E

-위의 코드에서 while needVisit은 V+E번 만큼 수행

따라서 시간 복잡도: O(V+E)