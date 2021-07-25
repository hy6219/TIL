package com.dataStructure.tree;

public class TreeMain {
    public static void main(String[] args){
        NodeMgmt tree = new NodeMgmt();

        tree.insertNode(2);
        tree.insertNode(3);
        tree.insertNode(4);
        tree.insertNode(5);
        tree.insertNode(6);

        NodeMgmt.Node test = tree.search(3);
        System.out.println(test);
        System.out.println(test.value);//3
        System.out.println("===");
        System.out.println(tree.search(0));//null
        System.out.println("===");
        System.out.println(test.right.value);//4
        System.out.println("===");
  //      System.out.println(test.left);//null

        tree.insertNode(0);
        test=tree.search(2);
        System.out.println(test.left.value);

        tree.insertNode(1);
        tree.insertNode(10);
        tree.insertNode(11);
        tree.insertNode(12);
        tree.insertNode(13);

        tree.delete(13);
        test=tree.search(13);
        System.out.println(test);//null

        tree.delete(0);
        test= tree.search(0);
        System.out.println(test);//null

        tree.delete(4);
        test=tree.search(4);
        System.out.println(test);//null
        test=tree.search(2);//루트를 기준으로 모두 출력
        System.out.println(test);
        /*
        * Node{left=Node{left=null, right=null, value=1}, right=Node{left=null, right=Node{left=null, right=Node{left=null, right=Node{left=null, right=Node{left=null, right=Node{left=null, right=null, value=12}, value=11}, value=10}, value=6}, value=5}, value=3}, value=2}
        *           2
        *       x     3
        *           5   6
        *         10 11 12 x
        * */
    }
}
