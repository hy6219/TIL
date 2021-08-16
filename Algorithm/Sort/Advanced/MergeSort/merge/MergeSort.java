package sorting.merge;

import java.util.ArrayList;

public class MergeSort {

    public ArrayList<Integer> mergeSplitFunc(ArrayList<Integer> list){
        int size=list.size();
        //인자값 길이가 1개 이하이면 그대로 반환
        if(size<=1){
            return list;
        }

        //배열을 앞뒤로 나누기
        int midIdx=size/2;
        ArrayList<Integer> leftArr = mergeSplitFunc(new ArrayList<>(list.subList(0,midIdx)));
        ArrayList<Integer> rightArr= mergeSplitFunc(new ArrayList<>(list.subList(midIdx,size)));

        System.out.println("midIdx: "+midIdx);
        System.out.println("left: "+leftArr);
        System.out.println("right: "+rightArr);
        //return mergeFunc(left,right)
        return mergeFunc(leftArr,rightArr);
    }

    public ArrayList<Integer> mergeFunc(ArrayList<Integer> leftArr, ArrayList<Integer> rightArr) {
        //병합된 배열
        ArrayList<Integer> mergedArr=new ArrayList<>();

        //왼쪽과 오른쪽 부분 배열에 대한 포인터
        int leftPointer = 0;
        int rightPointer =0;

        int leftSize=leftArr.size();
        int rightSize=rightArr.size();
        //CASE#1: left,right모두 있을 때
        while(leftSize>leftPointer && rightSize>rightPointer){
             if(leftArr.get(leftPointer)>rightArr.get(rightPointer)){
                 mergedArr.add(rightArr.get(rightPointer));
                 rightPointer++;
             }else{
                 mergedArr.add(leftArr.get(leftPointer));
                 leftPointer++;
             }
            //배열 크기도 없데이트
            leftSize=leftArr.size();
            rightSize=rightArr.size();
        }


        //CASE#2 :right 데이터가 없을때
        while(leftSize>leftPointer){
            mergedArr.add(leftArr.get(leftPointer));
            leftPointer++;
            leftSize=leftArr.size();
        }
        //CASE#3: left 데이터가 없을 때
        while(rightSize>rightPointer){
            mergedArr.add(rightArr.get(rightPointer));
            rightPointer++;
            rightSize=rightArr.size();
        }
        System.out.println("now, list: "+mergedArr);
        System.out.println("===================================");
        return mergedArr;
    }

}
