package programmers.P84325;

import java.util.*;

public class Solution {

    public static  String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        StringTokenizer st=null;
        //분야별 선호도 리스트
        Map<String, ArrayList<String>> field=new HashMap<>();
        //사용자의 언어-선호도 맵구조
        Map<String,Integer> preLang=new HashMap<>();


        //필드별 언어 선호도 순 정리(맵구조)
        for(int i=0; i < table.length;i++){
            String target=table[i];
            String key="";
            ArrayList<String> list=new ArrayList<>();

            st=new StringTokenizer(target," ");
            key=st.nextToken();
            int j=1;
            while(st.hasMoreTokens()){
                list.add(st.nextToken());
            }

            field.put(key,list);
        }

        ArrayList<Map.Entry<String,ArrayList<String>>> fieldList=new ArrayList<>(field.entrySet());
    //    System.out.println("분야별 언어 선호도순: "+fieldList);
        //언어-선호도 순 키-밸류로 정리
        for(int i=0; i < languages.length;i++){
            preLang.put(languages[i],preference[i]);
        }

   //     System.out.println("사용자의 언어별 선호도: "+preLang);

        //[직업군,언어선호도*직업군 언어점수]
        Map<String,Integer> stand=new HashMap<>();

        for(int i=0;i< fieldList.size();i++){
            int temp=0;
            String key=fieldList.get(i).getKey();
            ArrayList<String> val=fieldList.get(i).getValue();

            for(int j=0; j<val.size();j++){
                String lang=val.get(j);
                int idx=val.indexOf(val.get(j));
                boolean flag=preLang.containsKey(lang);//해당 언어가 선호 언어로 등록되어 있는지 확인
                if(flag){
                    temp+=preLang.get(lang)*(5-idx);//점수 더하기
                }
            }
            stand.put(key,temp);
        }

 //       System.out.println("분야별 총점 결과: "+stand);

        //총점 결과의 value 순으로 정렬
        ArrayList<Map.Entry<String,Integer>> sort=new ArrayList<>(stand.entrySet());

        Collections.sort(sort, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int val1=o1.getValue();
                int val2=o2.getValue();

                String key1=o1.getKey();
                String key2=o2.getKey();

                //value값이 같으면 key값 사전순 배열
                if(val1==val2){
                    return key1.compareTo(key2);
                }

                return val2-val1;
            }
        });

      //  System.out.println("sorted standard: "+sort);

        answer=sort.get(0).getKey();

        return answer;
    }

    public static void main(String[] args){
        String[] table={"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
        String[] lang1={"PYTHON", "C++", "SQL"};
        String[] lang2={"JAVA", "JAVASCRIPT"};

        int[] pre1={7, 5, 5};
        int[] pre2={7, 5};

        System.out.println(solution(table,lang1,pre1));
        System.out.println(solution(table,lang2,pre2));
    }
}
