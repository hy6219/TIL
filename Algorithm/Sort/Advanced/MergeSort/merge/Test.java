package sorting.merge;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {

    public static Object[] splitFunc(Integer[] arr){
        int size= arr.length;

        if(size<=1){
            return null;
        }
        int mid = size/2;
        Integer[] split1=new Integer[mid];
        Integer[] split2=new Integer[mid];

        Object[] res = new Object[2];

        System.arraycopy(arr,0,split1,0,mid);
        System.arraycopy(arr,mid,split2,0,mid);

        res[0] = split1;
        res[1] = split2;

        return res;
    }

    public static ArrayList<ArrayList<Integer>> splitFunc2(ArrayList<Integer> arr){
        int size = arr.size();

        if(size<=1){
            return null;
        }

        int mid = size/2;
        //sublist- [0,mid)
        ArrayList<Integer> splited1= new ArrayList<>(arr.subList(0,mid));
        //[mid,size)
        ArrayList<Integer> splited2=new ArrayList<>(arr.subList(mid,size));

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        res.add(splited1);
        res.add(splited2);

        return res;

    }

    public static void main(String[] args){
        //배열을 앞뒤  두 배열로 자르는 코드 작성하기
        Integer[] arr  = {3,5,2,4,6,7,8,1,9,10};

        Object[] splited= splitFunc(arr);
        System.out.println("splited#1: "+Arrays.toString((Integer[])splited[0]));
        System.out.println("splited#2: "+Arrays.toString((Integer[])splited[1]));


        ArrayList<ArrayList<Integer>> res = splitFunc2(new ArrayList<Integer>(Arrays.asList(3,5,2,4,6,7,8,1,9,10)));

        ArrayList<Integer> sp1=res.get(0);
        ArrayList<Integer> sp2=res.get(1);

        System.out.println("splited##1: "+sp1);
        System.out.println("splited##2: "+sp2);
    }
}
