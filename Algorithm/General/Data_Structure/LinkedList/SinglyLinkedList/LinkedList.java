package com.dataStructure.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;

public class LinkedList{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static class Data{
        static final int NO = 1;//번호입력 여부
        static final int NAME=2;//이름입력 여부

        private Integer no;//번호
        private String name;//이름

        //데이터 입력<-&마스킹을 통해서 입력 확인
        void scanData(String guide, int sw) throws IOException {
            System.out.println(guide+"할 데이터를 입력하세요");
            //일치하는 지 확인(모두 1로 반환된 후 그 값이 NO 혹은 NAME인지 비교
            if((sw & NO)==NO){
                System.out.println("번호: ");
                no = Integer.valueOf(br.readLine());
            }

            if((sw & NAME)==NAME){
                System.out.println("이름: ");
                name = br.readLine();
            }
        }
        //Comparator를 상속받는 객체에 대해서 검색될 수 있도록 했기 때문에
        //Comparator 인터페이스를 구현하기
        //1.회원번호로 정렬
        public static final Comparator<Data> NO_ORDER = new NoOrderComparator();

        private static class NoOrderComparator implements Comparator<Data>{
            @Override
            public int compare(Data o1, Data o2) {
                if(o1.no>o2.no){
                    return 1;
                }else if(o1.no<o2.no){
                    return -1;
                }
                return 0;
            }
        }

        //2.이름 순
        public static final Comparator<Data> NAME_ORDER =new NameOrderComparator();

        private static class NameOrderComparator implements Comparator<Data>{
            @Override
            public int compare(Data o1, Data o2) {
                return o1.name.compareTo(o2.name);
            }
        }

        @Override
        public String toString(){
            return "("+no+")"+name;
        }
    }

    //메뉴 열거형
    enum Menu{
        ADD_FIRST( "머리에 노드를 삽입"),
        ADD_LAST(" 꼬리에 노드를 삽입"),
        REMOVE_FIRST( "머리 노드를 삭제"),
        REMOVE_LAST( "꼬리 노드를 삭제"),
        REMOVE_SELECTED( "선택 노드를 삭제"),
        CLEAR( "모든 노드를 삭제"),
        SEARCH_NO( "번호로 검색"),
        SEARCH_NAME( "이름으로 검색"),
        NEXT( "선택 노드를 하나 뒤쪽으로 이동"),
        PRINT_SELECTED( "선택 노드를 출력"),
        DUMP( "모든 노드를 출력"),
        TERMINATE( "종료");

        //출력할 문자열
        private final String msg;

        Menu(String msg) {
            this.msg = msg;//msg필드를 매개변수인자값으로
        }

        //서수가 idx인 열거를 반환
        static Menu MenuAt(int idx){
            for(Menu m:Menu.values()){
                //values는 열거형 요소들을 순서대로 enum 타입의 배열로 리턴(예: Menu[])
                //ordinal은 열거형에 정의된 순서를 반환
                if(m.ordinal()==idx){
                    return m;
                }
            }
            //못찾은 경우
            return null;
        }

        String getMessage(){
            return msg;
        }
    }

    //메뉴 선택
    static Menu selectMenu() throws IOException {
        int key=0;

        do{
            for(Menu m:Menu.values()){
                System.out.printf("(%d) %s",m.ordinal(),m.getMessage());

                if((m.ordinal()%3)==2 && m.ordinal()!=Menu.TERMINATE.ordinal()){
                    //3개씩 개행시키는데 종료명령이전까지만 개행!
                    System.out.println();
                }
            }
            System.out.print(": ");
            key = Integer.valueOf(br.readLine());
        }while(key<Menu.ADD_FIRST.ordinal() || key > Menu.TERMINATE.ordinal());//열거형 범위에 해당되는 한
        //계속 수행하는데, 일단 처음에 한번은 무조건 실행해야 하기 때문에 do-while이용

        return Menu.MenuAt(key);
    }

    public static void main(String[] args) throws IOException {
        //메뉴
        Menu menu;
        //삽입하기 위한 데이터
        Data data;
        //검색용도
        Data ptr;
        //입력용도
        Data temp = new Data();

        SinglyLinkedList<Data> linkedList = new SinglyLinkedList<>();

        do{
            switch(menu=selectMenu()){
                case ADD_FIRST:
                    data = new Data();//삽입할 데이터 입력받기
                    data.scanData("머리에 삽입",Data.NO |Data.NAME);//DATA.NO와 DATA.NAME을 OR MASKING하게 되면 2!!이를 내부에서
                    //&MASKING처리하게 되면 번호와 이름을 입력받게 됨
                    linkedList.insertBeforeHead(data);
                    break;
                case ADD_LAST:
                    data= new Data();
                    data.scanData("꼬리에 삽입",Data.NO | Data.NAME);
                    linkedList.insertAfterTail(data);
                    break;
                case REMOVE_FIRST:
                    linkedList.removeFirst();
                    break;
                case REMOVE_LAST:
                    linkedList.removeLast();
                    break;
                case REMOVE_SELECTED:
                    linkedList.removeCurr();
                    break;
                case SEARCH_NO:
                    //회원번호로 검색
                    temp.scanData("검색",Data.NO);
                    ptr = linkedList.search(temp, Data.NO_ORDER);

                    if(ptr==null){
                        System.out.println("해당 번호의 데이터가 없습니다");
                    }else{
                        System.out.println("검색 성공: " + ptr);
                    }
                    break;
                case SEARCH_NAME:
                    //이름으로 검색
                    temp.scanData("이름으로 검색",Data.NAME);
                    ptr = linkedList.search(temp,Data.NAME_ORDER);

                    if(ptr==null){
                        System.out.println("해당 이름의 데이터가 없습니다");
                    }else{
                        System.out.println("검색 성공: "+ptr);
                    }
                    break;
                case NEXT:
                    //선택 노드를 뒤쪽으로 이동
                    linkedList.next();
                    break;
                case PRINT_SELECTED:
                    //선택노드의 데이터를 출력
                    linkedList.printCurNode();
                    break;
                case DUMP:
                    //모든 노드 출력
                    linkedList.dump();
                    break;
                case CLEAR:
                    //모든 노드 삭제
                    linkedList.clear();
                    break;
            }
        }while(menu!=Menu.TERMINATE);
        br.close();
    }
}
