# 완전탐색 알고리즘-응용편

### 01. BOJ 14888- 연산자 끼워넣기

1. 문제 파악

수열 A1, A2, ..., AN 사이에 연산자(+,-,*,/)가 올 수 있음

- 식의 계산은 연산자 우선 순위를 무시하고 앞에서부터 진행해야 함
- 음수 계산: 수로 바꾼 뒤 몫을 취하고, 그 몫을 음수로 바꾸어 주도록!

`만들 수 있는 식의 결과가 최대인 것과 최소인 것을 구하는 프로그램을 작성`

> 첫째 줄에 만들 수 있는 식의 결과의 최댓값을, 둘째 줄에는 최솟값을 출력한다. 연산자를 어떻게 끼워넣어도 항상 -10억보다 크거나 같고, 10억보다 작거나 같은 결과가 나오는 입력만 주어진다. 또한, 앞에서부터 계산했을 때, 중간에 계산되는 식의 결과도 항상 -10억보다 크거나 같고, 10억보다 작거나 같다.
> 

→ ****🌟**int: -21억~21억—>int 사용!**

1. 시간복잡도 예측

**N-1개 카드 중 중복없이 , 순서있게 나열!**

→nPm 패턴! O($N!/(N-M)!$)=시간복잡도

공간복잡도=O(M)

1. 시나리오 계획

(1) 문제를 해결할 재귀함수

- 기록할 배열 A[1...N-1]에  연산자들이 순서대로 저장될 것
- 1) k번째 연산자가 N 번째 연산자이면==모든 연산자들을 전부 나열하는 방법을 찾은 경우

→ 정한 연산자 순서대로 계산

- 2) 4 가지 연산자들 중 무엇을 쓸것인지 선택하고 재귀 호출

(2) 완성된 식에 맞게 계산해서 정답에 갱신하는 작업

- "입력으로 들어온 수열에 대한 배열인 arr"과 "연산자기록를 위한 배열인 record"를 이용해서 계산하기
- 처음에는 첫번째 숫자를 갖고 있도록 하고(arr[1])
- 그다음부터는 1부터 N-1번째까지(마지막에는 다음값인 N까지 고려) record[i]와 arr[i]를 이용한 연산 작업 결과를 저장해주기

1. 구현된 코드

```java
package rhs_algo.complete_search.boj14888;

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
            while(st==null || !st.hasMoreTokens()){
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

        Long nextLong(){
            return Long.valueOf(next());
        }

        Double nextDouble(){
            return Double.valueOf(next());
        }
    }

    //배열 크기
    static int N;
    //배열 입력
    static int[] arr;
    //연산자 배열
    static int[] op=new int[5];
    //최대,최소
    static int max,min;
    //결과를 string으로 묶어줄것
    static StringBuilder sb=new StringBuilder();
    //기록을 위한 배열
    static int[] record;
    //입력
    public static void input(){
        FastReader r=new FastReader();
        //N입력받기
        N=r.nextInt();
        //배열 초기화
        arr=new int[N+1];
        //기록배열
        record=new int[N+1];
        //배열 입력받기
        for(int i=1;i<=N;i++){
            arr[i]=r.nextInt();
        }
        //연산자 배열 입력받기
        for(int i=1;i<5;i++){
            op[i]=r.nextInt();
        }
        min=Integer.MAX_VALUE;
        max=Integer.MIN_VALUE;
    }
    //완성된 식에 맞게 계산해서 정답에 갱신하기
    //입력으로 들어온 수열에 대한 배열인 arr과 연산자배열인 op를 이용해서 계산하기
    public static int calculator(){
        //계산된 값을 담을 변수인 value의 초기값은 첫번째 값으로 해주기
        int value=arr[1];

        for(int i=1;i<=N-1;i++){
            if(record[i]==1){
                //덧셈
                value=value+arr[i+1];//다음값요소 더하기
            }else if(record[i]==2){
                //뺄셈
                value=value-arr[i+1];
            }else if(record[i]==3){
                //곱셈
                value=value*arr[i+1];
            }else{
                value=value/arr[i+1];
            }
        }

        return value;
    }
    //완전탐색
    public static void rec_func(int k){
        if(k==N){
            //N번째 연산자라면, 완성된 식에 맞게 계산해서 정답에 갱신하기
            //정한 순서대로 계산
            int value=calculator();
            //최소, 최댓값 비교
            max=Math.max(max,value);
            min=Math.min(min,value);
        }else{
            //k번째 연산자로 어떤 것이 올지 고르는데,
            //후보가 총 네가지(+,-,*,/)
            for(int cand=1;cand<=4;cand++){
                //먼저 연산자가 있는지 확인
                if(op[cand]>=1){
                    //남은 갯수를 감소시킴
                    op[cand]--;
                    //연산자 기록 남기기
                    record[k]=cand;
                    //완전탐색
                    rec_func(k+1);
                    //탐색 후 초기화
                    op[cand]++;
                    record[k]=0;
                }
            }
        }
    }
    public static void main(String[] args){
        input();
        rec_func(1);
        sb.append(max).append('\n').append(min);
        System.out.println(sb);
    }
}
```

- 단점: 모든 경우마다 계산작업이 수행됨

→ 심화 스케치

```java
static void rec_func(int k, int value){
	//value: k-1번째 연산자까지 계산한 결과-> value를 정답에 갱신
   if(k==N){
     //모든 연산자들을 전부 나열할 방법을 찾은 상태
 //value를 정답에 갱신
 }else{
 //4 가지 연산자들 중 무엇을 쓸지 선택하고
//연산자를 계산한 후에 재귀 호출하기
  }
}
}
```

```java
//계산하는 과정도 피연산자 두개와 연산자를 받아 처리하도록 하기
static int calculator(int val,int op, int next){
 if(op==1){
   val+=next;//덧셈
}else if(op==2){
  val-=next;//뺄셈
}else if(op==3){
  val*=next;//곱셈
}else{
  val/=next;//나누기
}
}
```

### 02. BOJ 9663 N-Queen

1. 문제 이해
- 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제
- N=14가 입력으로 올때 int 최대인 21억을 넘길지 안넘길지 모르는 상황

→ 일단 넣어보고 판단

🌟 유명한 백트래킹 문제!

1. 시간 복잡도 예측

(1번행에 놓을 퀸의 열) (2번 행에 놓을 퀸의 열)...(N번 행에 놓을 퀸의 열)

N개 중 중복을 허용해서 N개를 순서대로 나열하는 모든 경우의 수 

→ 완전탐색

시간복잡도=O($N^M$)-.> N=14(최대)일 때 14^14>10^16→시간초과가 예상됨

공간복잡도=O(M)

1. 시나리오

```java
static int N;//N*N
static int ans;//가능한 모든 경우의 수를 세는 변수
static int[] col;//지금까지 어떤 열들이 나오는지 기록하는 배열
//col[i]: i번 행의 퀸은 col[i]번 열에 퀸을 놓았다는 기록

//row번~N번 행에 대해서 가능한 퀸을 놓는 경우의 수 구하기
static void rec_func(int row){
 //각 행마다 하나씩 잘 놓아서 퀸을 놓을 수 있는 모든 자리에 놓은 경우
 if(row==N+1){
   //서로 공격하는 퀸들이 없는 경우==지금까지 놓은 퀸들의 자리가 올바른지
//확인
  if(validity_check()){
    ans++;//경우의수 늘리기
  }
}else{
   //모든 열에 놓아야할 경우
   //==각 행에 대해서 퀸을 놓아야 할 경우
   for(int cand=1;cand<=N;cand++){
      //해당 열의 퀸이 놓일 열에 후보열값을 넣기
       col[row]=cand;
       //완전탐색
        rec_func(row+1);
       //맞지 않은 경우에 다시 놓을 수 있도록 초기화
       col[row]=0;
    }
  }
}
```

1. 완성된 코드

```java
package rhs_algo.complete_search.boj9663;

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

        Long nextLong(){
            return Long.valueOf(next());
        }

        Double nextDouble(){
            return Double.valueOf(next());
        }
    }

    static int N;//N*N
    static int ans;//가능한 모든 경우의 수를 세는 변수
    static int[] col;//지금까지 어떤 열들이 나오는지 기록하는 배열
//col[i]: i번 행의 퀸은 col[i]번 열에 퀸을 놓았다는 기록

    //입력
    static void input(){
        FastReader r=new FastReader();
        N=r.nextInt();
        col=new int[N+1];//기록
    }
    //서로가 공격을 할 수 있는지 확인
    static boolean attackable(int r1,int c1,int r2,int c2){
        //상,하,대각선방향(우측상향, 좌측상향)으로 겹치면 안됨

        //열이 같은 경우==상하로 같은 경우
        if(c1==c2) return true;
        //좌측 상향 대각선에 있는 경우
        //행-열값이 같음
        if(r1-c1==r2-c2) return true;//공격가능
        //우측상향 대각선에 있는 경우
        //행+열 값이 같음
        if(r1+c1==r2+c2) return true;

        //위의 모든 케이스를 다 만족하지 않으면 공격할 수 없음
        return false;
    }
    //맞게 잘 놓였는지 확인
    static boolean validity_check(){
        //모든 핀이 공격할 수 없으면 true
        //공격할 수 있으면 false
        //i번째 행에 놓인 퀸의 위치==즉 그 행의 열값을 이용
        //i번째 행보다 높이 있는 퀸들 중 공격할수 있는 경우를 살핌
        for(int i=1;i<=N;i++){
            //(i,col[i])
            for(int j=1;j<i;j++){
                //(j,col[j])
                if(attackable(i,col[i],j,col[j])){
                    //만약 이 둘이 공격할 수 있다면
                    return false;
                }
            }
        }
        return true;//공격할 수 없는 경우
    }
    //row번~N번 행에 대해서 가능한 퀸을 놓는 경우의 수 구하기
    static void rec_func(int row){
        //각 행마다 하나씩 잘 놓아서 퀸을 놓을 수 있는 모든 자리에 놓은 경우
        if(row==N+1){
            //서로 공격하는 퀸들이 없는 경우==지금까지 놓은 퀸들의 자리가 올바른지
//확인
            if(validity_check()){
                ans++;//경우의수 늘리기
            }
        }else{
            //모든 열에 놓아야할 경우
            //==각 행에 대해서 퀸을 놓아야 할 경우
            for(int cand=1;cand<=N;cand++){
                //해당 열의 퀸이 놓일 열에 후보열값을 넣기
                col[row]=cand;
                //완전탐색
                rec_func(row+1);
                //맞지 않은 경우에 다시 놓을 수 있도록 초기화
                col[row]=0;
            }
        }
    }
    public static void main(String[] args){
        input();
        rec_func(1);
        //가능한 모든 경우의 수 출력
        System.out.println(ans);
    }
}
```

→ 시간초과

"불필요한 탐색을 많이 시도하기 때문"

→가능하지 않은 위치는 놓지 말자

심화 스케치

```java
static int N;//N*N
static int ans;//가능한 모든 경우의 수를 세는 변수
static int[] col;//지금까지 어떤 열들이 나오는지 기록하는 배열
//col[i]: i번 행의 퀸은 col[i]번 열에 퀸을 놓았다는 기록

//row번~N번 행에 대해서 가능한 퀸을 놓는 경우의 수 구하기
static void rec_func(int row){
 //각 행마다 하나씩 잘 놓아서 퀸을 놓을 수 있는 모든 자리에 놓은 경우
 if(row==N+1){
 //성공적인 경우에 대해서만 호출이 되면 그 경우수만 카운트
ans++;
}else{
   //모든 열에 놓아야할 경우
   //==각 행에 대해서 퀸을 놓아야 할 경우
   for(int cand=1;cand<=N;cand++){
      //해당 열의 퀸이 놓일 열에 후보열값을 넣기
//단, row행의 cand 열에 놓을 수 있으면 실행될 것
       col[row]=cand;
       //완전탐색
        rec_func(row+1);
       //맞지 않은 경우에 다시 놓을 수 있도록 초기화
       col[row]=0;
    }
  }
}
```

### 03. BOJ 1182- 부분수열의 합

1. 문제 이해

N개 정수로 이루어진 수열에서, 크기가 양수인 부분 수열 중 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수를 구하기

- 1 ≤ N ≤ 20, |S| ≤ 1,000,000 →목표치와 N값을 고려했을때 , 부분 수열 개수 상한=2^20=100만<21억→따라서 N은 int 사용가능

-부분 수열의 합 상한: 20 * 1000000(=각원소=|Ai|="주어지는 정수의 절댓값은 100,000을 넘지 않는다.") < 21억→S도 int 사용 가능

- 입력:

# 1 N, S

#2 N개 정수

1. 시간복잡도 예측

`각 원소마다 부분 수열에 포함시킬지(1) , 포함시키지 않을지(0)` 를 살펴야 하고, 나열의 순서가 중요하기 때문에 `중복 YES, 순서 YES` 의 케이스!

시간복잡도= O($N^M$) → 2^20=100만 → 100만보다 작기 때문에  도전해볼만한 가치도 있다!

공간복잡도=O(M)

1. 구현스케치

```java
static int N;//N개 정수
static int S;//목표값
static int ans;//모든 경우의 수를 기록

static int[] nums;//n개 수 입력 기록

//k번째 원소를 포함시킬지 정하는 함수
//value=k-1번째 원소까지 골라진 원소들의 합
static void rec_func(int k, int value){
 if(k==N+1){
  //부분수열을 하나 완성시킨 경우
//value가 S랑 같으면 경우의 수로 기록
 }else{
 //k번째 원소를 포함시킬지 결정하고, 재귀호출
 }
}
```

1. 완성된 코드

```java
package rhs_algo.complete_search.boj1182;

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
            while(st==null||!st.hasMoreTokens()){
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

        Long nextLong(){
            return Long.valueOf(next());
        }

        Double nextDouble(){
            return Double.valueOf(next());
        }
    }

    static int N;//N개 정수
    static int S;//목표값
    static int ans;//모든 경우의 수를 기록

    static int[] nums;//n개 수 입력 기록
    //입력
    static void input(){
        FastReader r= new FastReader();
        N=r.nextInt();
        S=r.nextInt();
        nums=new int[N+1];

        for(int i=1;i<=N;i++){
            nums[i]=r.nextInt();
        }
    }
    //k번째 원소를 포함시킬지 정하는 함수
//value=k-1번째 원소까지 골라진 원소들의 합
    static void rec_func(int k, int value){
        if(k==N+1){
            //부분수열을 하나 완성시킨 경우
            //value가 S랑 같으면 경우의 수로 기록
            if(value==S){
                ans++;//하나의 부분수열 발견
            }
        }else{
            //k번째 원소를 포함시킬지 결정하고, 재귀호출
            //포함시키고 싶은 경우
            rec_func(k+1,value+nums[k]);
            //포함시키고 싶지 않은 경우
            rec_func(k+1,value);//지금까지 골랐던 원소들을 더하지 않고 넘겨주기만 하면 됨
        }
    }
    public static void main(String[] args){
        input();
        //맨처음에는 아무런 원소를 고르지 않았기에 value=0으로 제공
        rec_func(1,0);
        //ans가 정말 "진부분집합==비어있지 않은 부분집합"만 다루는지 확인하기
        //S==0인 경우, 전부다 불포함시킨 상황에서 비교하기 때문에 이 경우에 대한 처리가 필요
        if(S==0){
            ans--;//공집합 경우를 제외시키기
        }
        System.out.println(ans);
    }
}
```