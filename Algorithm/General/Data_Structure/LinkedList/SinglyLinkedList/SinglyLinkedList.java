package com.dataStructure.linkedlist;

import java.io.IOException;
import java.util.Comparator;

public class SinglyLinkedList<E> {
    //노드
    static class Node<E>{
        //데이터
        E data;
        //pointer
        Node<E> next =null;
        Node(E data, Node<E> next){
            this.data = data;
            this.next = next;
        }

    }
    //헤드노드
    private Node<E> head;
    //선택되는 노드-탐색후 삭제를 위함
    private Node<E> selected;

    public SinglyLinkedList(){
        head = selected = null;//초기화
    }
    //검색 수행
    //Comparator를 상속받는 객체에 한해서 수행
    public E search(E obj, Comparator<? super E> c){
        Node<E> ptr = head;//현재 검색을 진행중인 노드

        while(ptr!=null){

            if(c.compare(obj,ptr.data)==0){
                //검색 성공
                selected = ptr;
                return ptr.data;
            }

            //포인터를 이용해서 다음노드로 연결
            ptr=ptr.next;
        }
        //검색 실패
        return null;
    }
    //헤드노드 위치 앞에 노드를 삽입
    public void insertBeforeHead(E obj){
        //헤드 노드==새로 삽입할 노드, 새로 삽입할 노드의 포인터가 기존 헤드노드를 가리키도록
        //기존 헤드노드
        Node<E> ptr = head;
        //생성자를 이용해서 기존 헤드노드를 가리키도록 하고, 다른 작업의 진행을 위해서
        //그를 위한 노드도 갱신시켜주기
        head=selected=new Node<>(obj,ptr);//헤드노드는 이렇게 수행하게 되면 기존에 헤드노드가 비어있다 할지라도 문제없음
    }

    //기존 꼬리노드 뒤에 삽입
    public void insertAfterTail(E obj){
        //헤드노드가 비어있다면 헤드노드에 삽입하는 것과 동일하므로 이를 수행하도록 하고
        //아니라면 기존 꼬리노드와 삽입될 꼬리노드를 연결해주어야 함
        if(head==null){
            insertBeforeHead(obj);
        }else {
            Node<E> ptr = head;
            while (ptr.next != null) {
                //꼬리노드 찾기
                ptr = ptr.next;
            }
            //꼬리노드를 찾았다면 다음노드는 새로삽입할 노드로 연결하기(이를 다음작업을 위한 노드인 selected에도 갱신해주기)
            ptr.next = selected = new Node<>(obj, null);//꼬리노드인데, 지금 singly linked list구현중이므로
            //포인터는 비워두어도 됨
        }
    }
    //헤드노드삭제
    public void removeFirst(){
        //헤드노드가 있을 경우에만 실행하는데
        //이 경우에는 헤드노드와 작업수행노드를 기존 헤드노드의 다음노드를 가리키도록 변경해주면 간단하게 작업할 수 있음
        if(head!=null){
            head = selected= head.next;
        }
    }

    //꼬리 노드 삭제
    public void removeLast(){
        //꼬리노드도, 전제는 헤드노드가 존재해야 링크드리스트가 있는 것이라서 이부분을 먼저 체크
        //헤드노드의 다음노드가 없다면 이 경우는 노드가 1개만 있는 경우라서 헤드노드삭제로 수행
        //그렇지 않고 노드가 최소 2개 이상이라면, 꼬리노드를 찾고,포인터를 null로 변경해주고 ,
        //selected노드는 기존꼬리노드의 이전노드, 즉 현재 꼬리노드로 업데이트해주기
        if(head!=null){
            if(head.next==null){
                //노드가 1개만 있는 경우
                removeFirst();
            }else{
                //스캔중인 노드
                Node<E> ptr=head;
                //스캔중인 노드 이전노드
                Node<E> pre = head;

                while(ptr.next!=null){
                    pre=ptr;//이전노드를 저장하고
                    ptr=ptr.next;//그 다음ptr노드를 다음노드로 변경
                }
                pre.next=null;//새로운 꼬리노드로 변경(포인터를 비우기)
                selected = pre;//새로운 꼬리노드인 pre로 작업을 위한 노드 갱신

            }
        }

    }
    //특정 노드 삭제
    public void remove(Node p){
        //헤드노드가 있을 경우에만 진행해야함! 그렇지 않으면 비어있는 곳에 접근하게 되어서
        //null pointer exception이 발생할 수 있음
        if(head!=null) {
            //특정노드가 헤드노드이면 위에서 작성한 메서드 실행
            if (p == head) {
                removeFirst();
            } else {
                Node<E> ptr = head;

                while (ptr.next != p) {
                    //찾고자 하는 노드 전까지 이동하는데, p가 리스트에 존재하지 않으면 함수를 종료
                    ptr = ptr.next;
                    if (ptr == null) return;
                }
                //p노드가 제거되려면
                //ptr의 다음을 가리키는 포인터는 p노드의 다음을 가리켜야 함
                ptr.next = p.next;
                selected = ptr;//그리고 나서 selected도 삭제대상 노드의 전 노드로 업뎃해주어야 함
            }
        }
    }
    //현재 노드 삭제
    public void removeCurr(){
        remove(selected);
    }
    //모든 노드 삭제
    public void clear(){
        while(head!=null){
            removeFirst();
        }
        selected = null;
    }

    //선택한 노드를 한 단계 뒤쪽으로 이동
    public boolean next(){
        if(selected == null || selected.next==null){
            //해당 노드가 비어있거나 다음 노드가 존재하지 않아 수행할 수 없는 경우
            return false;
        }
        //나머지 경우는 포인터를 이용해서 연결해주고 true 반환
        selected = selected.next;
        return true;
    }

    //선택 노드를 출력
    public void printCurNode(){
        if(selected == null){
            System.out.println("선택한 노드가 없습니다");
        }else{
            System.out.println(selected.data);
        }
    }

    //모든 노드 출력
    public void dump() throws IOException {
        Node<E> ptr = head;
        StringBuilder sb = new StringBuilder();


        sb.append("[");
        while(ptr!=null){
            sb.append(ptr.data);
            if(ptr.next!=null){
                //꼬리노드가 아닌 경우
                sb.append(", ");
            }
            ptr= ptr.next;
        }

        sb.append("]\n");
        System.out.println(sb);
    }

}
