# 어떻게든 푼다! 완탐! Brute Force!

### 🔍 완전 탐색?

- 문제 해결을 위해 확인해야 할 모든 경우를 전부 탐색
- 그 중에서도 백트래킹을 통해서 or 재귀 함수를 통해 해결해보도록 하기!

- 장점:  부분점수 얻기 좋다!
- 단점: 전부탐색사기에 시간복잡도가 일반적으로 높음

### 코테에 나오는 완전탐색 종류

N개 중 —-1) 중복을 허용해서

           |___2) 중복 없이

M개 를—-A) 순서있게 나열하기

           |___B) 고르기

🌟 🌟🌟함수 정의부터 50%!!

### 01. N개 중 중복을 허용해서 M개를 순서있게 나열하기(1+A)

백준 15651번 문제- N과 M (3)

난이도 : 2(알고리즘과 자료구조를 알고 있다)

1. 문제 파악
- N, M: 입력으로 주어지는 자연수
- 수열 : [1,N] 범위에서의 자연수 중 M개를 고른 수열  ▶  N은 close range, M은 조합에서 r에 해당(nCr)
- "같은 수를 여러번 골라도 된다" ▶ `중복허용` →중복조합느낌도 있음!
- "수열은 사전 순으로 증가하는 순서로 출력"  ▶ `순서있게 나열하기`

 ▶  ▶  중복을 허용하고 순서있게 나열하는 `완전탐색`!!

- 조건 : 1≤ M≤N≤7

🌺 테스트케이스 이해

(예제입력1)

3 1

(예제출력1)

1

2

3

→ [1,3] 범위 중 1 개를 선택 → 1 이 될수도, 2가 될 수도, 3이 될수도!

예제입력/출력2와 3을 확인해보니 nCr의 경우수를 모두 출력!(중복허용되므로 중복조합도 고려될 수 있음)

1. 시간 복잡도 예측

→ EX) N=a, M=b로 주어지게 되면

모든 경우의 수= $a*a*...*a=a가 b번 곱해진것=a^b=n^m$

→O($N^M)$

만약 N=4, M=3과 같은 입력이 주어지면, 최악의 경우 82만에 해당되는 복잡도가 예상되는데,1초에 1억번의 연산이 가능하다면 충분히 가능할 것이라고 생각해볼 수 있음

_ _ _ → M=3

2-2. 공간 복잡도 예측

N으로 표현해야 할 자리가 M개 이기 때문에 O(M)

1. 구현 스케치

```java
static int N,M;//N과 M->공통적으로 사용될 변수를 static으로 두어 
//인자값으로 넣지 않아도 가능하도록 지원
static int[] selected;//완전탐색 결과 기록 배열

/*
**재귀함수
	1. 만약 M개 자리를 모두 고른 경우, 조건에 맞는 탐색을 한 가지 성공한것
  2. 아직 M개를 고르지 않은 경우, k번째부터 M번째 원소를 조건에
맞게 고르는 모든 방법을 시도
*/
static void rec_func(int k){
 if(k==M+1){
   //다 고른 경우
 //selected[1..M]배열이 새롭게 탐색된 결과
}else{
  //1~N 까지를 k번 원소로(_ _ _ 처럼 _에 채워지는 값) 한번씩 정하고
// 매번 k+1번부터 M번 원소로 재취 호출해주기
	}
}
```

🌟 류호석님 강의 중 FastReader 템플릿→ 입출력 부분을 빠르게 도와줌

```java
public static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br=new BufferedReader(new InputStreamReader(System.in));
        }
        public FastReader(String s) throws FileNotFoundException {
            br=new BufferedReader(new FileReader(new File(s)));
        }
        String nextLine(){
            String str="";
            try{
                str=br.readLine();
            }catch(IOException e){
                e.printStackTrace();
            }
            return str;
        }
        String next(){
            while(st==null|| !st.hasMoreTokens()){
                try{
                    st=new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.valueOf(next());
        }
        long nextLong(){
            return Long.valueOf(next());
        }
        double nextDouble(){
            return Double.valueOf(next());
        }
    }
```

1. 함수를 이용해서 모듈화

(a) 입력

(b) 재취함수

(c) Main

---

(a) 입력

FastReader를 이용해서 N과 M입력을 받고 탐색 결과를 기록할 배열을 생성

```java
//필드
    static int N,M;//testcase 입력
    static int[] selected;//탐색기록배열
    //stringbuilder를 이용해서 문자열 결합시 복잡도를 감쇠시키도록
   static StringBuilder sb=new StringBuilder();
    //1.입력함수
    public static void input(){
        FastReader sc=new FastReader();
        N=sc.nextInt();
        M=sc.nextInt();
        selected=new int[M+1];
    }
```

(b) 재귀함수

- 다 고른 경우(k==M+1) ↔ 모든 탐색이 다 진행된 경우 ↔ M까지 탐색했기 때문에 그 다음은 M+1이 되는데, 이때는 결과를 종합해준다!
- 그렇지 않은 경우, `1~N 중 하나를 골라` `k+1번~M번을 모두 탐색` 하고, 탐색된 k번째는 0으로 마킹

```java
/*
    **2. 재귀함수
        1. 만약 M개 자리를 모두 고른 경우, 조건에 맞는 탐색을 한 가지 성공한것
      2. 아직 M개를 고르지 않은 경우, k번째부터 M번째 원소를 조건에
    맞게 고르는 모든 방법을 시도
    */
    public static void rec_func(int k){
        if(k==M+1){
            //다 고른 경우
            //selected[1..M]배열이 새롭게 탐색된 결과

            //🧡selected배열을 출력해주기
            for(int i=1;i<=M;i++) sb.append(selected[i]).append(' ');
            sb.append('\n');
        }else{
            //1~N 까지를 k번 원소로(_ _ _ 처럼 _에 채워지는 값) 한번씩 정하고
            for(int cand=1;cand<=N;cand++){
                selected[k]=cand;
                // 매번 k+1번부터 M번까지 모두 탐색(재귀방식을 이용)
                rec_func(k+1);
                //탐색을 해주게 되면, k번째 원소는 탐색해줄 필요가 없기 때문에 0으로 마킹
                selected[k]=0;
            }

        }
    } 
```

(complete)

```java
package rhs_algo.complete_search.boj15651;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br=new BufferedReader(new InputStreamReader(System.in));
        }
        public FastReader(String s) throws FileNotFoundException {
            br=new BufferedReader(new FileReader(new File(s)));
        }
        String nextLine(){
            String str="";
            try{
                str=br.readLine();
            }catch(IOException e){
                e.printStackTrace();
            }
            return str;
        }
        String next(){
            while(st==null|| !st.hasMoreTokens()){
                try{
                    st=new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.valueOf(next());
        }
        long nextLong(){
            return Long.valueOf(next());
        }
        double nextDouble(){
            return Double.valueOf(next());
        }
    }
    //필드
    static int N,M;//testcase 입력
    static int[] selected;//탐색기록배열
    //stringbuilder를 이용해서 문자열 결합시 복잡도를 감쇠시키도록
    static StringBuilder sb=new StringBuilder();
    //1.입력함수
    public static void input(){
        FastReader sc=new FastReader();
        N=sc.nextInt();
        M=sc.nextInt();
        selected=new int[M+1];
    }
    /*
    **2. 재귀함수
        1. 만약 M개 자리를 모두 고른 경우, 조건에 맞는 탐색을 한 가지 성공한것
      2. 아직 M개를 고르지 않은 경우, k번째부터 M번째 원소를 조건에
    맞게 고르는 모든 방법을 시도
    */
    public static void rec_func(int k){
        if(k==M+1){
            //다 고른 경우
            //selected[1..M]배열이 새롭게 탐색된 결과

            //🧡selected배열을 출력해주기
            for(int i=1;i<=M;i++) sb.append(selected[i]).append(' ');
            sb.append('\n');
        }else{
            //1~N 까지를 k번 원소로(_ _ _ 처럼 _에 채워지는 값) 한번씩 정하고
            for(int cand=1;cand<=N;cand++){
                selected[k]=cand;
                // 매번 k+1번부터 M번까지 모두 탐색(재귀방식을 이용)
                rec_func(k+1);//다음빈칸을 채워주기 위함
                //탐색을 해주게 되면, k번째 원소는 탐색해줄 필요가 없기 때문에 0으로 마킹
                selected[k]=0;
            }

        }
    }
    public static void main(String[] args){
        input();
        rec_func(1);
        System.out.println(sb);
    }
}
```

### 02. N개 중  중복없이 M개를 순서있게 나열하기(2+A 유형)

BOJ 15649- N과 M(1)

난이도: 2

1. 문제 파악
- N, M: 입력으로 주어지는 자연수
- 수열 : [1,N] 범위에서의 자연수 중 M개를 고른 수열  ▶  N은 close range, M은 조합에서 r에 해당(nCr)
- 1≤M≤N≤8
- "1부터 N까지 자연수 중 중복없이 M개를 고른" → `중복없이`
- "수열은 사전순으로 증가하는 순서로 출력" → `순서있게 나열`

—> `완전탐색`!!

1. 시간,공간 복잡도 예측

→→ 이전에는 중복이 허용되어 a*a*...*a 이런식으로 접근했지만

N=4, M=3을 예로 들면

____    ____ ____

1        1        1 (x)

1        2        3(O)

→ nC1 * n-1C1 * ..*n-m+1C1=n*(n-1)*...*(n-m+1)=nPm← '왼쪽부터 한자리씩 선택폭이 좁혀지는, 종속적인 관계!'

따라서, 시간복잡도는 O(N)=O($N!/(N-M)!)$ ← nPm

가장 클 경우는 N=M=8 → 8!/0! = 8!/1 = 40320 < 1억번 연산/초

→ 따라서 구현 가치가 있다!

공간복잡도는 O(M)← 필요한 자리

1. 구현 스케치

```java
static int N,M;//N과 M->공통적으로 사용될 변수를 static으로 두어 
//인자값으로 넣지 않아도 가능하도록 지원
static int[] selected;//완전탐색 결과 기록 배열
static int[] used;//중복을 체크
/*
**재귀함수
	1. 만약 M개 자리를 모두 고른 경우, 조건에 맞는 탐색을 한 가지 성공한것
  2. 아직 M개를 고르지 않은 경우, k번째부터 M번째 원소를 조건에
맞게 고르는 모든 방법을 시도
*/
static void rec_func(int k){
 if(k==M+1){
   //다 고른 경우
 //selected[1..M]배열이 새롭게 탐색된 결과
}else{
  //1~N 까지를 k번 원소로(_ _ _ 처럼 _에 채워지는 값) 한번씩 정하고

//위의 후보값이 selected 배열원소값과 같으면 사용된 적 있는 것이므로 
//중복을 피하기 위해서 플래그값을 변경해주기

// 사용된적이 없다면, 즉 k번째에 후보값이 올수 있으면
//매번 k+1번부터 M번 원소로 재취 호출해주기
	}
}
```

1. 함수를 이용해서 모듈화

(a) 입력

(b) 재취함수

(c) Main

---

(a) 입력

FastReader를 이용해서 N과 M입력을 받고 탐색 결과를 기록할 배열과 [1,N] 중 중복되었는 지를 확인할 배열을 생성

```java
//필드
    static int N,M;//testcase 입력
    static int[] selected;//탐색기록배열
    static int[] used;//중복체크
    //stringbuilder를 이용해서 문자열 결합시 복잡도를 감쇠시키도록
    static StringBuilder sb=new StringBuilder();
    //1.입력함수
    public static void input(){
        FastReader sc=new FastReader();
        N=sc.nextInt();
        M=sc.nextInt();
        selected=new int[M+1];
			 used=new int[N+1];
    }
```

(b) 재귀함수

```
   1.만약 M개 자리를 모두 고른 경우,조건에 맞는 탐색을 한 가지 성공한것
  2.아직 M개를 고르지 않은 경우, k번째부터 M번째 원소를 조건에
맞게 고르는 모든 방법을 시도
 -중복을 제거하기 위해 배열값을 0(중복x,이미 다 사용함), 1(중복o)으로 나누어 접근
```

```java
public static void rec_func(int k){
        if(k==M+1){
            //다 고른 경우
            //selected[1..M]배열이 새롭게 탐색된 결과

            //🧡selected배열을 출력해주기
            for(int i=1;i<=M;i++) sb.append(selected[i]).append(' ');
            sb.append('\n');
        }else{
            boolean isUsed=false;//중복 막기
            //1~N 까지를 k번 원소로(_ _ _ 처럼 _에 채워지는 값) 한번씩 정하고
            for(int cand=1;cand<=N;cand++){

                //1이면 중복되었다
                //0이면 중복되지 않았다

                //중복된 경우 다음 값 넣기
                if(used[cand]==1) continue;

                //k번째에 cand가 올 수 있는 경우== 중복이 안된 경우
                //->기록해두고, 중복체크배열에 1로 적용해주기
                selected[k]=cand; used[cand]=1;
                //완전탐색(k+1~M)
                rec_func(k+1);
                //k번째는 이제 탐색하지 않아도 되고, 더이상 candidate 값을 더이상 사용하지 말것임을 명시!
                selected[k]=0; used[cand]=0;
            }

        }
    }
```

(전체)

```java
package rhs_algo.complete_search.boj15649;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br=new BufferedReader(new InputStreamReader(System.in));
        }
        public FastReader(String s) throws FileNotFoundException {
            br=new BufferedReader(new FileReader(new File(s)));
        }
        String nextLine(){
            String str="";
            try{
                str=br.readLine();
            }catch(IOException e){
                e.printStackTrace();
            }
            return str;
        }
        String next(){
            while(st==null|| !st.hasMoreTokens()){
                try{
                    st=new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.valueOf(next());
        }
        long nextLong(){
            return Long.valueOf(next());
        }
        double nextDouble(){
            return Double.valueOf(next());
        }
    }
    //필드
    static int N,M;//testcase 입력
    static int[] selected;//탐색기록배열
    static int[] used;//중복체크
    //stringbuilder를 이용해서 문자열 결합시 복잡도를 감쇠시키도록
    static StringBuilder sb=new StringBuilder();
    //1.입력함수
    public static void input(){
        FastReader sc=new FastReader();
        N=sc.nextInt();
        M=sc.nextInt();
        selected=new int[M+1];
        used=new int[N+1];
    }
    /*
    **2. 재귀함수
        1. 만약 M개 자리를 모두 고른 경우, 조건에 맞는 탐색을 한 가지 성공한것
      2. 아직 M개를 고르지 않은 경우, k번째부터 M번째 원소를 조건에
    맞게 고르는 모든 방법을 시도
    * -중복을 제거하기 위해 배열값을 0(중복x, 이미 다 사용함), 1(중복o)으로 나누어 접근
    */
    public static void rec_func(int k){
        if(k==M+1){
            //다 고른 경우
            //selected[1..M]배열이 새롭게 탐색된 결과

            //🧡selected배열을 출력해주기
            for(int i=1;i<=M;i++) sb.append(selected[i]).append(' ');
            sb.append('\n');
        }else{
            boolean isUsed=false;//중복 막기
            //1~N 까지를 k번 원소로(_ _ _ 처럼 _에 채워지는 값) 한번씩 정하고
            for(int cand=1;cand<=N;cand++){
//-->n^2
//                for(int i=1;i<k;i++){
//                    if(cand==selected[i]){
//                        isUsed=true;
//                    }
//                }
//                //중복되지 않은 경우
//               if(!isUsed){
//                   selected[k]=cand;//후보로 중복되지 않은 값을 넣어주고
//                   // 매번 k+1번부터 M번까지 모두 탐색(재귀방식을 이용)
//                   rec_func(k+1);//다음빈칸을 채워주기 위함
//                   //탐색을 해주게 되면, k번째 원소는 탐색해줄 필요가 없기 때문에 0으로 마킹
//                   selected[k]=0;
//               }

                //1이면 중복되었다
                //0이면 중복되지 않았다

                //중복된 경우 다음 값 넣기
                if(used[cand]==1) continue;

                //k번째에 cand가 올 수 있는 경우== 중복이 안된 경우
                //->기록해두고, 중복체크배열에 1로 적용해주기
                selected[k]=cand; used[cand]=1;
                //완전탐색(k+1~M)
                rec_func(k+1);
                //k번째는 이제 탐색하지 않아도 되고, 더이상 candidate 값을 더이상 사용하지 말것임을 명시!
                selected[k]=0; used[cand]=0;
            }

        }
    }
    public static void main(String[] args){
        input();
        rec_func(1);
        System.out.println(sb);
    }
}
```

### 03. N개 중 중복을 허용하여, M개를 고르기(1+B 버전)

BOJ 15652번- N과 M(4)

난이도: 2

1. 문제 파악
- N, M: 입력으로 주어지는 자연수
- 수열 : [1,N] 범위에서의 자연수 중 M개를 중복을 허용해서 고른 수열  ▶  N은 close range, M은 조합에서 r에 해당(nHr)→ `중복허용`
- 1 ≤ M ≤ N ≤ 8
- "중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다."
- "수열은 사전 순으로 증가하는 순서로 출력해야 한다."
- `고른 수열은 비내림차순`

← 

> 길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.
> 

→ `고르기` ↔ `2 3과 3 2 는 같은 것`!!

→ `완전탐색!`

1. 시간, 공간 복잡도

(ex) N=4, M=3

→ ___   ___ ___

1 1 1(0)

1 1 2(0)

1 2 1 (x)

—>중복조합에 조건이 붙기 때문에 모든 경우의 수 < 4H3=$4^3=64$가지

—> 따라서 O($N^M$)의 시간 복잡도를 가짐

—>$8^8=1677만$ 보다 작기 때문에 도전해볼 가치가 있음

공간 복잡도=O(M)

1. 구현 스케치

```java
static int N,M;//N과 M->공통적으로 사용될 변수를 static으로 두어 
//인자값으로 넣지 않아도 가능하도록 지원
static int[] selected;//완전탐색 결과 기록 배열

/*
**재귀함수
	1. 만약 M개 자리를 모두 고른 경우, 조건에 맞는 탐색을 한 가지 성공한것
  2. 아직 M개를 고르지 않은 경우, k번째부터 M번째 원소를 조건에
맞게 고르는 모든 방법을 시도
*/
static void rec_func(int k){
 if(k==M+1){
   //다 고른 경우
 //selected[1..M]배열이 새롭게 탐색된 결과
}else{
//시작은 selected[k-1]==이전에 사용되었던 숫자
//만약 시작이 0이면 1로 변경해주기(자연수 1부터 N까지이므로)

  //start~N 까지를 k번 원소로(_ _ _ 처럼 _에 채워지는 값) 한번씩 정하고

//매번 k+1번부터 M번 원소로 재취 호출해주기
//더이상 방문할 필요가 없다면 방문이 필요없음을 명시해주기
	}
}
```

(정리)

```java
package rhs_algo.complete_search.boj15652;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br=new BufferedReader(new InputStreamReader(System.in));
        }
        public FastReader(String s) throws FileNotFoundException {
            br=new BufferedReader(new FileReader(new File(s)));
        }
        String nextLine(){
            String str="";

            try{
                str=br.readLine();
            }catch(IOException e){
                e.printStackTrace();
            }

            return str;
        }

        String next(){
            while(st==null ||!st.hasMoreTokens()){
                try{
                    st=new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){
            return Integer.valueOf(next());
        }
        long nextLong(){
            return Long.valueOf(next());
        }
        double nextDouble(){
            return Double.valueOf(next());
        }
    }
    static int N,M;
    static int[] selected;
    //초기화
    public static void input(){
        FastReader sc=new FastReader();
        N=sc.nextInt();
        M=sc.nextInt();
        selected=new int[M+1];
    }
    static StringBuilder sb=new StringBuilder();
    //재귀
    static void rec_func(int k){
        if(k==M+1){
            //다 탐색한 경우
            for(int i=1;i<=M;i++)sb.append(selected[i]).append(' ');
            sb.append('\n');
        }else{
            //탐색이 남은경우
            //비내림차순으로 적용될 필요가 있고
            //1 2==2 1 로 처리가 되므로 이부분을 주의! 즉 순서가 없음
            int start=selected[k-1];//이전에 사용된 값
            if(start==0) start=1;

            for(int cand=start;cand<=N;cand++){
                //start~N 까지를 k번 원소로(_ _ _ 처럼 _에 채워지는 값) 한번씩 정하고
                selected[k]=cand;
//매번 k+1번부터 M번 원소로 재취 호출해주기
                rec_func(k+1);
//더이상 방문할 필요가 없다면 방문이 필요없음을 명시해주기
                selected[k]=0;
            }
        }
    }

    public static void main(String[] args){
        input();
        rec_func(1);
        System.out.println(sb);
    }
}
```

### 04. N개 중 중복없이 M개를 고르기(2+B버전)

BOJ 15650-N과 M(2)

난이도: 2

1. 문제 이해
- [1,N] 자연수 중 `중복없이 M개를` 고른 수열
- 고른 수열은 오름차순이어야 한다
- 수열은 사전순 증가
- 1 ≤ M ≤ N ≤ 8
- 1  2 == 2  1 → `고르기`

1. 시간, 공간 복잡도 계산

ex) N=4, M=3

→ ___  ___ ____

1 1 1 (x)

1 2 3 (o)

1 2 4 (o)

—>4C1 * 3C1*2C1

—>nC1* *...**n-m+1C1—>O($N!/{(N-M)!M!}$)=O(nCm)=시간복잡도

—> 최대로 클 경우는 M=N=4인 경우인데, 이때 모든 경우의 수= 8!/(4!*4!)=70 → 충분히 도전해볼만 함

공간복잡도=O(M)

1. 구현 스케치

🌟 이전 선택에 따른 값 영향을 받기 때문에 이전값+1부터 N까지 후보로 넣으면서 확인

```java
static int N,M;//N과 M->공통적으로 사용될 변수를 static으로 두어 
//인자값으로 넣지 않아도 가능하도록 지원
static int[] selected;//완전탐색 결과 기록 배열

/*
**재귀함수
	1. 만약 M개 자리를 모두 고른 경우, 조건에 맞는 탐색을 한 가지 성공한것
  2. 아직 M개를 고르지 않은 경우, k번째부터 M번째 원소를 조건에
맞게 고르는 모든 방법을 시도
*/
static void rec_func(int k){
 if(k==M+1){
   //다 고른 경우
 //selected[1..M]배열이 새롭게 탐색된 결과
}else{
  //이전값+1~N 까지를 k번 원소로(_ _ _ 처럼 _에 채워지는 값) 한번씩 정하고

//매번 k+1번부터 M번 원소로 재취 호출해주기
	}
}
```

(정리)

```java
package rhs_algo.complete_search.boj15650;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br=new BufferedReader(new InputStreamReader(System.in));
        }
        public FastReader(String s) throws FileNotFoundException {
            br=new BufferedReader(new FileReader(new File(s)));
        }
        String nextLine(){
            String str="";

            try{
                str=br.readLine();
            }catch(IOException e){
                e.printStackTrace();
            }

            return str;
        }

        String next(){
            while(st==null ||!st.hasMoreTokens()){
                try{
                    st=new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){
            return Integer.valueOf(next());
        }
        long nextLong(){
            return Long.valueOf(next());
        }
        double nextDouble(){
            return Double.valueOf(next());
        }
    }
    static int N,M;
    static int[] selected;
    //초기화
    public static void input(){
        FastReader sc=new FastReader();
        N=sc.nextInt();
        M=sc.nextInt();
        selected=new int[M+1];
    }
    static StringBuilder sb=new StringBuilder();
    //재귀
    static void rec_func(int k){
        if(k==M+1){
            //다 탐색한 경우
            for(int i=1;i<=M;i++)sb.append(selected[i]).append(' ');
            sb.append('\n');
        }else{
            //이후 값: 이전값 다음값부터 선택할 수 있음
            for(int cand=selected[k-1]+1;cand<=N;cand++){
                //selected[k-1]+1~N 까지를 k번 원소로(_ _ _ 처럼 _에 채워지는 값) 한번씩 정하고
                selected[k]=cand;
//매번 k+1번부터 M번 원소로 재취 호출해주기
                rec_func(k+1);
//더이상 방문할 필요가 없다면 방문이 필요없음을 명시해주기
                selected[k]=0;
            }
        }
    }

    public static void main(String[] args){
        input();
        rec_func(1);
        System.out.println(sb);
    }
}
```

### 📌 총 정리

[완전탐색 시간복잡도](https://www.notion.so/2d4259ae78dd49fda92fa6cea5e08bfd)

🌟 완전탐색은 `중복` 과 `순서` 를 꼼꼼히 따져보자!