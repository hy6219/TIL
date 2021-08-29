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
