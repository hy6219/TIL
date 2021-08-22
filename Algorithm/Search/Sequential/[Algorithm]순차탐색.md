# [탐색 알고리즘]순차 탐색 알고리즘 Sequential Search

🌹 탐색

- 여러 데이터 중 원하는 데이터를 찾아내는 것

🌹 순차 탐색

- 데이터가 담겨있는 리스트를 앞에서부터 하나씩 비교해서 원하는 데이터를 찾는 방법

💡 step1

임의의 배열이 있을 때, 원하는 데이터의 위치를 리턴하는 순차탐색  알고리즘 작성하기

- 원하는 데이터가 리스트에 없으면 -1 리턴
- Math.random()메서드를 사용해서 0과 100사이의 랜덤값을 10개 가진 testData만들기

(내가 생각한 방법)

```java
package sorting.search.sequential;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SequentialSearch {
    int[] arr;

    public void makeRdn(int limit,int size){
        this.arr = new int[size];

        for(int i =0 ; i < size; i++){
            arr[i]=(int)(Math.random()*limit)+1;
        }
    }

   public int seqSearch(int finder){
       int size= arr.length;

       for(int i =0; i < size; i++){
           if(arr[i]==finder){
               return i;
           }
       }
       return -1;
   }
}
```

 

```java
package sorting.search.sequential;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        SequentialSearch s= new SequentialSearch();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int finder=Integer.valueOf(br.readLine());
        int res=0;

        s.makeRdn(100,10);
        System.out.println(s.seqSearch(finder));
    }
}
```

📌 시간 복잡도: 최악의 경우, 리스트 길이 혹은 배열 길이가 n일 때 n번 비교해야 하므로 O(n)