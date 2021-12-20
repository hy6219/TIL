package programmers.P42577;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    static Map<String,Integer> map;

    //key-value구조로 만들기
    static void makeKeyValueStructure(String[] phone_book){

        map=new HashMap<>();

        for(int i=0;i< phone_book.length;i++){
            map.put(phone_book[i], i);
        }
    }

    public static boolean solution(String[] phone_book) {
        makeKeyValueStructure(phone_book);
        //모든전화번호의 substring으로 구성된 문자열이 map에 존재하는지 확인
        for(int i=0;i< phone_book.length;i++){
            for(int j=0;j< phone_book[i].length();j++){
                String key=phone_book[i].substring(0,j);
                if(map.containsKey(key)) return false;//접두사 존재!
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[] test01={"119", "97674223", "1195524421"};
        String[] test02={"123","456","789"};
        String[] test03={"12","123","1235","567","88"};


        System.out.println(solution(test01));
        System.out.println(solution(test02));
        System.out.println(solution(test03));
    }

}
