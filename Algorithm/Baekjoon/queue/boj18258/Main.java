package baekjoon.boj18258;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
* @Author: jisoo
* push X: 정수 X를 큐에 넣는 연산이다.
pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 큐에 들어있는 정수의 개수를 출력한다.
empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
* */
public class Main {

    static LinkedList<Integer> queue=new LinkedList<>();

    static void push(int x){
        queue.add(x);
    }
    static int empty(){
        boolean flag=queue.isEmpty();

        return (flag==true)?1:0;
    }
    static int size(){
        return queue.size();
    }

    static int pop(){
        int flag=empty();
        return (flag==1)?-1:queue.remove(0);
    }

    static int front(){
        int flag=empty();
        return (flag==1)?-1:queue.get(0);
    }

    static int back(){
        int flag=empty();
        return (flag==1)?-1:queue.get(size()-1);
    }




    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int line=Integer.valueOf(br.readLine());
        StringBuilder sb=new StringBuilder();
        for(int i=0; i<line;i++){
            StringTokenizer st=new StringTokenizer(br.readLine()," ");
            switch (st.nextToken()){
                case "push":
                    int t=Integer.valueOf(st.nextToken());
                    push(t);
                    break;
                case "pop":
                    sb.append(pop()+"\n");
                    break;
                case "empty":
                    sb.append(empty()+"\n");
                    break;
                case "size":
                    sb.append(size()+"\n");
                    break;
                case "front":
                    sb.append(front()+"\n");
                    break;
                case "back":
                    sb.append(back()+"\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
