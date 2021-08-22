# [탐색 알고리즘]이진 탐색 Binary Search

- 탐색할 자료를 둘로 나누어 해당 데이터가 있을만할 곳을 탐색

![https://blog.penjee.com/wp-content/uploads/2015/04/binary-and-linear-search-animations.gif](https://blog.penjee.com/wp-content/uploads/2015/04/binary-and-linear-search-animations.gif)

source: [https://blog.penjee.com/wp-content/uploads/2015/04/binary-and-linear-search-animations.gif](https://blog.penjee.com/wp-content/uploads/2015/04/binary-and-linear-search-animations.gif)

🌟 이진탐색은 `데이터 리스트가 정렬되어 있어야 한다` 라는 전제조건이 붙는다!

- 전체 데이터의 중간을 먼저 찾는다
- 찾는 값> 중간위치 값 ▶️ 오른쪽으로 보기
- 찾는 값< 중간위치 값 ▶️ 왼쪽으로 보기

위의 과정을 반복!

🌟 분할 정복 알고리즘과 이진탐색

- 분할 정복 알고리즘

-divide:문제를 하나 또는 둘 이상으로 나눔

-conquer: 나눠진 문제가 충분히 작고 해결이 가능하다면 해결하고, 그렇지 않으면 다시 나눈다

- 이진 탐색

-divide : 배열 혹은 리스트를 두 개의 서브 배열 혹은 리스트로 나눔

-conquer: 검색할 숫자 > 중간값이면 뒷 부분의 서브 배열에서 찾고

검색할 숫자< 중간값이면 앞부분의 서브 배열에서 찾기

🌟 이진 탐색 알고리즘 ⭐

ⓐ 크기가 0인 경우 ▶️ return -1

ⓑ 크기가 1인 경우

- 찾는 값과 일치 → return 인덱스값
- 찾는 값과 불일치 → return -1

ⓒ 위의 두 단계를 거치면 자연스럽게 size≥2 인 것이죠! 그래서 

case 1) 찾는 값과 같은 경우→바로 return 인덱스값

case 2-1) 찾는 값 < 중간 값 → 배열의 0~중간인덱스 까지 범위 줄이기

case 2-2) 찾는 값 > 중간 값 → 배열의 중간인덱스~배열의 끝 까지 범위 줄이기

```java
package sorting.search.binary;

public class BinarySearch {
    public int binarySearch(int[] arr, int finder){
        int size=arr.length;
        int mid=size/2;
        int val=arr[mid];
        int[] temp=new int[mid];

        //크기가 1인데 찾는 데이터라면 바로 리턴 인덱스
        if(size==1 && finder==val){
            return mid;
        }
        //크기가 1인데 찾는 데이터가 아닌 경우
        if(size==1 && finder!=val){
            return -1;
        }
        //크기가 0인 경우
        if(size==0){
            return -1;
        }
        //size>=2
        if(val==finder){
            return mid;
        }else{
            if(finder<val){
                System.arraycopy(arr,0,temp,0,mid);
                return binarySearch(temp,finder);
            }else{
                System.arraycopy(arr,mid,temp,0,mid);
                return binarySearch(temp,finder);
            }
        }

    }
}
```

```java
package sorting.search.binary;

import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        BinarySearch b= new BinarySearch();
        int[] arr=new int[10];
        for(int i =0 ; i< 10; i++){
            arr[i]=(int)(Math.random()*100)+1;
        }

        System.out.println("before sorted: "+ Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("after sorted: "+Arrays.toString(arr));

        System.out.println("find 13: "+b.binarySearch(arr,13));
        System.out.println("find 6: "+b.binarySearch(arr,6));
    }
}
```

sort를 해준 이유는 이진 탐색은 전제조건으로 정렬이 되어 있는 배열에 대해서 수행하기 때문이다!

📌 알고리즘 분석 📌

- n 개의 리스트를 매번 2로 나누어 1이 될 때까지 비교연산을 k회 진행

n*1/2*1/2...=1

n*$(1/2)^k$=1

n=$2^k$

k=log(2)n

따라서 O(logn)이 시간복잡도가 된다!

(이진 탐색은 각 단계별 한번씩만 체크하고, 병합이나 퀵정렬은 각 단계별로 모두 체크하기 때문에 복잡도가 각각 log n, nlogn의 차이가 발생한다)