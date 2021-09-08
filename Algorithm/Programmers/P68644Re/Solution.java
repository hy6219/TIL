package programmers.P68644Re;

import java.util.*;

public class Solution {

    public static TreeSet<Integer> solution(int[] numbers) {
        TreeSet<Integer> answer = new TreeSet<>();//중복없고 키값없고

        for(int i=0;i< numbers.length-1;i++){
            for(int j=i+1;j< numbers.length;j++){
                answer.add(numbers[i]+numbers[j]);
            }
        }

        return answer;
    }

    public static void main(String[] args){
        int[] arr1={2,1,3,4,1};
        int[] arr2={5,0,2,7};

        System.out.println(solution(arr1));
        System.out.println(solution(arr2));
    }
}
