# [알고리즘]깊이 우선 탐색 DFS(Depth First Search)

깊이 우선 탐색의 기본 개념은 아래 링크를 참조하자! 👇

[TIL/[알고리즘]너비우선탐색알고리즘 BFS.md at main · hy6219/TIL](https://github.com/hy6219/TIL/blob/main/Algorithm/Search/BFS/%5B%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98%5D%EB%84%88%EB%B9%84%EC%9A%B0%EC%84%A0%ED%83%90%EC%83%89%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98%20BFS.md)

먼저, 저번 시간에서처럼, 아래와 같은 그래프 구조를 만들도록 한다!

![https://raw.githubusercontent.com/hy6219/TIL/main/Algorithm/Search/BFS/BFS%20%ED%91%9C%ED%98%84.PNG](https://raw.githubusercontent.com/hy6219/TIL/main/Algorithm/Search/BFS/BFS%20%ED%91%9C%ED%98%84.PNG)

```java
package search.depth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

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
    }

}
```

🌟 BFS 는 needVisit과 visited 의 두개의 큐를 이용했던 것과 비교하면

🌟 DFS는 `needVisit 스택`과 `visited 큐` 를 이용

먼저 스택과 접목하기 전에 간단히 생각해보면, 아래처럼 마지막 인덱스를 remove시키면 됨을 생각해볼 수 있다

```java
ArrayList<String> alist=new ArrayList<>();
 alist.add("a");
alist.add("b");
**String node=alist.remove(alist.size()-1);**
System.out.println(node);
```

핵심을 정리해보면,

1. 방문한 큐 visited를 준비하고
2. 방문할 스택 needVisit을 준비한다
3. 시작노드를 방문할 노드에 넣고
4. 방문할 노드가 남아있는 동안 반복 `while(needVisit.size()>0)`
5. 4 동안 `맨 뒤에 삽입된 것을 먼저 제거하고`
6. 4동안 그 제거된 노드가 `visited에 등록된적이 없다면 제거된 노드는 visited에 저장`
7. 그리고 `제거된 노드와 연결된 리스트는 `needVisit에 저장`
8. 4를 다 진행한 후 `visited 큐`를 리턴한다

```java
package search.depth;

import java.util.ArrayList;
import java.util.HashMap;

public class DFSSearch {

    public ArrayList<String> dfsFunc(HashMap<String,ArrayList<String>> map, String startNode){
        //방문한 노드
        ArrayList<String> visited=new ArrayList<>();
        //방문할 노드
        ArrayList<String> needVisit=new ArrayList<>();

        //시작 노드를 방문할 노드에 넣기
        needVisit.add(startNode);

        //방문할 노드가 남아있는 동안 반복
        while(needVisit.size()>0){
            //needVisit의 "맨 뒤! 즉 나중에 들어온 값을 먼저 빼내고"
            **String node=needVisit.remove(needVisit.size()-1);**

            //visited에 등록된적이 없을 경우에는
          if(!visited.contains(node)){
              //그 빼낸 노드는 visited에 저장하자
              visited.add(node);
              //그리고 node와 연결된 리스트들을 needVisit에 담기
              needVisit.addAll(map.get(node));
          }
        }
        return visited;
    }

}
```

```java
package search.depth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

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

        System.out.println("before: "+mapData1);

        DFSSearch dfs=new DFSSearch();
        ArrayList<String> list=dfs.dfsFunc(mapData1,"A");
        System.out.println("after: "+list);
    }

}
```

```java
before: {A=[B, C], B=[A, D], C=[A, G, H, I], D=[B, E, F], E=[D], F=[D], G=[C], H=[C], I=[C, J], J=[I]}
after: [A, C, I, J, H, G, B, D, F, E]
```

📌 시간 복잡도

- 노드 수: V
- 간선 수: E

-위의 코드에서 while needVisit은 V+E번 만큼 수행[BFS와 while 루프 수행 횟수는 동일]

따라서 시간 복잡도: O(V+E)