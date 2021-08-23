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
