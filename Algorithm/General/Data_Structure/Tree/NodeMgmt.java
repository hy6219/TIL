package com.dataStructure.tree;

//노드를 관리할 수 있는 클래스
public class NodeMgmt {
    Node root=null;
    public class Node {
        //노드
        //왼쪽 브랜치
        Node left;
        //오른쪽 브랜치
        Node right;
        //data
        int value;

        //constructor
        public Node(int data){
            this.value=data;
            this.left=null;
            this.right=null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "left=" + left +
                    ", right=" + right +
                    ", value=" + value +
                    '}';
        }
    }


    //데이터 삽입
    public boolean insertNode(int data){
        //case 1: 노드가 하나도 없을 때
        if(this.root==null){
            this.root=new Node(data);
        }else{
            //case 2:노드가 하나 이상 들어가 있을 때
            //정확한 노드의 위치를 찾은 다음에 데이터를 넣어주어야 함
            Node finder = this.root;

            while(true){
                //case2-1. 현재 노드의 왼쪽에 노드가 들어가야 할 때
                if(data < finder.value){
                    //왼쪽에 있는 노드가 있는지 확인
                    if(finder.left!=null){
                        //존재하고 있었다면 왼쪽으로 옮겨서
                        //탐색을 이어가야할 것
                        finder=finder.left;
                    }else{
                        finder.left=new Node(data);
                        break;//clear되었기 때문에 더이상 반복하지 않아도 됨
                    }
                }else{
                    //case2-2 . 현재 노드의 오른쪽에 노드가 들어가야 할 때
                    if(finder.right!=null){
                        finder=finder.right;
                    }else{
                        finder.right=new Node(data);
                        break;
                    }
                }
            }
        }
        return true;//적절한 위치를 찾아 삽입 완료
    }

    //이진 트리 탐색
    //데이터를 가진 노드를 발견하면 노드를 반환
    public Node search(int data){
        //case 1 : 노드가 하나도 없을 때
        if(this.root==null){
            return null;
        }else{
            //case 2 : 노드가 하나 이상 있을 때
            //루트노드부터 시작해서 해당 노드를 찾기
            Node finder = this.root;

            while(finder!=null){
                if(finder.value==data){
                    //case 2-1. 해당 노드를 찾은 경우
                    return finder;
                }else{
                    //case 2-2. 해당 노드를 찾지 못한 경우
                    //case 2-2-1. data<finder.value
                    if(data<finder.value){
                        //왼쪽으로 탐색
                        finder=finder.left;
                    }else{
                        //case 2-2-2. data>finder.value
                        //오른쪽으로 탐색
                        finder=finder.right;
                    }


                }
            }
            //못찾은 경우
            return null;
        }
    }
    //이진 탐색 트리 삭제
    //삭제할 노드 탐색
    public boolean delete(int value){
        boolean searched =false;

        Node currParent= this.root;//루트노드부터 탐색
        Node curr = this.root;

        //코너 케이스1. 노드가 하나도 없을 때
        if(this.root==null){
            return false;
        }else {
            //코너 케이스 2: 노드가 단지 하나만 있고, 해당 노드가 삭제할 노드일 때
            if(this.root.value==value && this.root.left==null && this.root.right==null){
                this.root=null;
                return true;
            }
        //아닌 경우 순회
            while(curr!=null){
                if(curr.value==value){
                    searched=true;
                    break;
                }else if(value<curr.value){
                    currParent=curr;//부모노드 위치를 업데이트하면서
                    //왼쪽 순회
                    curr=curr.left;
                }else if(value>curr.value){
                    currParent=curr;
                    //오른쪽 순회
                    curr=curr.right;
                }
            }
            //while루프를 끝나고 나서 탐색이 끝난 경우도 있을 것이고
            //못찾은 경우도 있을 것
            if(searched==false){
                //찾지못한 경우는 바로 false 리턴
                return false;
            }
        }
        //여기까지 실행되면
        //curr: 삭제 대상 데이터를 갖고 있는 노드
        //currParent: 삭제 대상 데이터를 갖고 있는 노드의 부모노드

        //case1 : 삭제할 노드가 리프노드인 경우
        if(curr.left==null && curr.right==null){
            if(value<currParent.value){
                //지금 value를 갖고 있는 노드가
                //curr인데 이 값이 부모노드보다 작다는 것은
                //해당 노드가 부모노드의 왼쪽 브랜치와 연결되어 있었다는 것!
                //따라서 왼쪽 브랜치를 비워주기
                currParent.left=null;
                curr=null;//명시적으로 가독성을 높이기 위함
            }else{
                //부모노드의 오른쪽에 있었던것
                currParent.right=null;
                curr=null;
            }

            return true;
        }else if(curr.left!=null && curr.right==null){
            //case 2-1: 삭제할 노드가 자식노드를 한 개 갖고 있는 경우(왼쪽)
            if(value < currParent.value){
                //해당 노드는 부모노드의 왼쪽에 존재했던 것
                currParent.left=curr.left;//해당노드의 왼쪽 노드와 부모노드의 왼쪽 브랜치를 연결
                //명시적으로 작성
                curr=null;
            }else{
                //해당노드는 부모노드의 오른쪽에 존재했던 것
                //부모노드의 오른쪽과 현재노드의 왼쪽을 연결(현재노드의 왼쪽만 존재하기 때문)
                currParent.right=curr.left;
                curr = null;
            }
            return true;
        }else if(curr.left==null && curr.right!=null){
            //case 2-2: 삭제할 노드가 자식노드를 한 개 갖고 있는 경우(오른쪽)
            if(value< currParent.value){
                //부모노드의 왼쪽과 현재노드의 오른쪽을 연결
                currParent.left=curr.right;
                curr=null;
            }else{
                //부모노드의 오른쪽과 현재노드의 오른쪽을 연결
                currParent.right=curr.right;
                curr=null;
            }
            return true;
        }else{
            //case 3-1.자식노드가 2개인 노드를 삭제(삭제할 노드가 왼쪽에 있을 때)
            //이 때, 가장 작은 값을 가진 노드는 , 오른쪽 브랜치를 갖거나 어떤 자식도 없거나!를 의미!
            if(value < currParent.value){
                Node changeNode = curr.right;//오른쪽 자식 중 가장 작은 값을 찾기 위함
                Node changeParentNode = curr.right;

                while(changeNode.left!=null){
                    changeParentNode=changeNode;
                    changeNode=changeNode.left;//작은 값 찾기
                }
                
                //changeNode: 삭제할 노드의 오른쪽 부분에서의 가장 작은 노드가 저장됨
                //case 3-1-1 changeNode의 자식노드가 없을 때
                if(changeNode.left==null && changeNode.right==null) {
                    changeParentNode.left=null;
                }else if(changeNode.right!=null){
                    //case 3-1-2 changeNode의 오른쪽 자식노드가 있을 때
                    changeParentNode.left=changeNode.right;//오른쪽 자식노드와 부모의 왼쪽 요소 연결
                }
                //currParentNode의 왼쪽 자식에 삭제할 노드의
                //오른쪽 자식 중 가장 작은 값을 가진 changeNode 연결
                currParent.left=changeNode;
                //원래 삭제될 노드의 자식노드와 연결
                changeNode.left=curr.left;
                changeNode.right=curr.right;

                curr=null;
            }else{
                //case 3-2.자식노드가 2개인 노드를 삭제(삭제할 노드가 오른쪽에 있을 때)
                Node changeNode = curr.right;//오른쪽 자식 중 가장 작은 값을 찾기 위함
                Node changeParentNode = curr.right;

                while(changeNode.left!=null){
                    changeParentNode=changeNode;
                    changeNode=changeNode.left;//작은 값 찾기
                }
                //changeNode: 삭제할 노드의 오른쪽 부분에서의 가장 작은 노드가 저장됨
                //case 3-2-1 changeNode의 자식노드가 없을 때
                if(changeNode.left==null && changeNode.right==null) {
                    changeParentNode.left=null;
                }else if(changeNode.right!=null){
                    //case 3-2-2 changeNode의 오른쪽 자식노드가 있을 때
                    changeParentNode.left=changeNode.right;//오른쪽 자식노드와 부모의 왼쪽 요소 연결
                }
                //currParentNode의 오른쪽 자식에 삭제할 노드의
                //오른쪽 자식 중 가장 작은 값을 가진 changeNode 연결
                currParent.right=changeNode;//부모의 오른쪽과 연결
                //원래 삭제될 노드의 자식노드와 연결
                changeNode.left=curr.left;
                changeNode.right=curr.right;

                curr=null;
            }
            return true;



        }
    }
    ////////////////
}
