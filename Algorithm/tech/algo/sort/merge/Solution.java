package tech.algo.sort.merge;

import java.util.ArrayList;

public class Solution {

    /**
     * 깊이가 i라면, 노드는 각 단계에서 반절씩 분할되므로 2^i 개가 발생되므로 전체 단계에 따른 시간복잡도는 logN이 소요되고,
     * 각 단계별로 병합되는 과정에서 N번의 반복작업이 소요되기 때문에
     * 총 NlogN의 시간복잡도가 요구됨
     *
     * 최대한 자를 수 있을 때까지 절반씩 자르는 과정을 수행하고, 병합하는 과정
     *
     * 분할 정복-상위의 해답을 구하기 위해서 하위의 해답을 구하는 방식
     * 동적 정복-가장 최하위의 해답을 구한 후 상위로 올라가면서 해답을 구하는 상향식 방식, 메모이제이션 기법 사용
     * +메모이제이션: 이전에 계산한 값을 저장해서 다시 실행할 경우의 속도를 개선시키는 기술
     * */

    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();

        list.add(2);
        list.add(5);
        list.add(3);
        list.add(4);
        list.add(1);
        list.add(6);
        list.add(10);
        list.add(9);
        list.add(8);
        list.add(7);

        System.out.println("before: "+list);
        ArrayList<Integer> res1=mergeSplitFunc(list);
        System.out.println("after: "+res1);
    }

    //분할 후 병합
    static ArrayList<Integer> mergeSplitFunc(ArrayList<Integer> list) {
        //반절씩 좌우로 자를 것!
        int size=list.size();
        int mid=size/2;

        //크기가 1이하면 전달된 리스트를 그대로 반환
        if(size<=1) return list;

        //분할정복
        ArrayList<Integer> left=mergeSplitFunc(new ArrayList<>(list.subList(0,mid)));
        ArrayList<Integer> right=mergeSplitFunc(new ArrayList<>(list.subList(mid,size)));

        return mergeFunc(left,right);
    }

    static ArrayList<Integer> mergeFunc(ArrayList<Integer> left,ArrayList<Integer> right){
        ArrayList<Integer> ans=new ArrayList<>();
        //포인터를 이용해서 효율적으로 관리
        int leftPointer=0, rightPointer=0;
        //크기
        int lSize=left.size();
        int rSize=right.size();

        //case1. 왼쪽과 오른쪽 모두 병합할 요소가 남은 경우
        while(leftPointer<lSize && rightPointer < rSize){
            //오른쪽에 있는 요소가 먼저 와야 할 경우
            if(left.get(leftPointer) > right.get(rightPointer)){
                ans.add(right.get(rightPointer));
                rightPointer++;
            }else{
                //왼쪽에 있는 요소가 먼저 와야 할 경우
                ans.add(left.get(leftPointer));
                leftPointer++;
            }

        }

        //case2.왼쪽 혹은 오른쪽에만 남아 있는 경우
        //case2-1.왼쪽에만 남은 경우
        while(leftPointer<lSize){
            //모두 넣기
            ans.add(left.get(leftPointer));
            leftPointer++;
        }

        //case2-2. 오른쪽에만 남은 경우
        while(rightPointer<rSize){
            //모두 넣기
            ans.add(right.get(rightPointer));
            rightPointer++;
        }

        return ans;
    }
}
