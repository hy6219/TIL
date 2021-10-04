package rhs_algo.sort.boj10825;

import java.io.*;
import java.util.Arrays;
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

    static class Student implements Comparable<Student> {
        String name;
        int kor;
        int eng;
        int math;

        public Student() {
        }

        public Student(String name, int kor, int eng, int math) {
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getKor() {
            return kor;
        }

        public void setKor(int kor) {
            this.kor = kor;
        }

        public int getEng() {
            return eng;
        }

        public void setEng(int eng) {
            this.eng = eng;
        }

        public int getMath() {
            return math;
        }

        public void setMath(int math) {
            this.math = math;
        }

        @Override
        public int compareTo(Student other) {
            //국어점수 내림차순
            if(kor!=other.kor) return other.kor-kor;
            //영어점수 오름차순
            if(eng!=other.eng) return eng-other.eng;
            //수학점수 내림차순
            if(math!=other.math) return other.math-math;
            //이름 사전순
            return name.compareTo(other.name);
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", kor=" + kor +
                    ", eng=" + eng +
                    ", math=" + math +
                    '}';
        }
    }
    static int N;//배열크기
    static Student[] students;
    static FastReader r=new FastReader();
    //입력받기
    static void input(){
        N=r.nextInt();

        students=new Student[N];

        for(int i=0; i<N;i++){
            Student s=new Student();
            s.setName(r.next());
            s.setKor(r.nextInt());
            s.setEng(r.nextInt());
            s.setMath(r.nextInt());

            students[i]=s;
        }


    }
    static StringBuilder sb=new StringBuilder();
    //정렬
    static void mySort(){
        //정렬
        Arrays.sort(students);
        //이름만 출력하도록 해줄 것
        for(int i=0;i<N;i++){
            sb.append(students[i].getName());
            if(i!=N-1){
                sb.append('\n');
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args){
        input();
        mySort();
    }
}
