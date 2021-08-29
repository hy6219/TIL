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
            String node=needVisit.remove(needVisit.size()-1);

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
