/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

/**
 *
 * @author Debaspreet Chowdhury
 */
public class tree {
    
    //tree has root field
    Node root;
    
    //tree default constructors and other constructors
    public tree(){root=null;}
    public tree(int n){root = new Node(n);}
    
    /**
     * inserting a child into a node.
     * if child already there, then insert element as sibling
     * invoke the insertsibling method to insert child as siblings
     * or simply inserting siblings
     * */
    public Node insertchild(Node n,int key){
        if ( n == null ) {
        Node tmp = new Node();
        root = tmp;
        tmp.data = key;
        tmp.child = null;
        tmp.sibling = null;
        return (tmp);
    }
    if (n.child == null) {
        Node tmp = new Node();
        n.child = tmp;
        tmp.data = key;
        tmp.child = null;
        tmp.sibling = null;
        return (tmp);
    } else {
        return (insertsibling(n.child, key));
    }
    }
    
    /**
     * modified insertsibling method.
     * when child present, then this method is called
     * to insert the element as a sibling to the parent node.
     * NO NEED TO TRAVERSE !!!!! BECAUSE THIS METHOD IS MODIFIED.
     * This modified method stores the address of the last node
     * in the field called enterLast of type Node.
     * */
    public Node insertsibling(Node n,int key){
        if (n.sibling == null) {
            //System.out.println("test1");
        Node tmp = new Node();
        n.sibling = tmp;
        n.enterLast = tmp;
        tmp.data = key;
        tmp.child = null;
        tmp.sibling = null;
        return (tmp);
    } else {
            Node tmp = new Node();
            n.enterLast.sibling = tmp;
            n.enterLast = tmp;
            tmp.data = key;
            tmp.child = null;
            tmp.sibling = null;
            return (tmp);
    }
    }
    
    
    /**
     * to find the maximum number in the entire tree starting rom Node n
     * n by default is 0 to ease up comparisons.
     * returns the maximum number in the entire list.
     * */
    public int findMax(Node start,int n) {
        int i=n;
        Node tmp;
        if (start != null) {
            if(start.data>i) { i=findMax(start.child,start.data);}
            else i=findMax(start.child,i);
            tmp = start.sibling;
            while (tmp != null) {
                if (tmp.data > i) {i=tmp.data;}
                i=findMax(tmp.child,i);
                tmp = tmp.sibling;
            }
        }
        return i;
    }
    
    /**
     * returns the node with the specific key that
     * is being searched. This method is used by the
     * insertchild method in turn to add to a node returned
     * by findNode method.
     * */
    public Node findNode(Node n,int key){
        
    Node tmp;
    if (n == null) {return (n);}
    if (n.data == key) {return (n);}
    tmp = findNode(n.child, key);
    if (tmp == null) {
        tmp = findNode(n.sibling, key);
        if (tmp != null) {return(tmp);}
    }
    return (tmp);
    }
    
    //display the rough tree structure.
    public void preTraverse(Node start) {
    Node tmp;
    if (start != null) {
        
        System.out.print(start.data+" ");
        preTraverse(start.child);
        tmp = start.sibling;
        while (tmp != null) {
            System.out.print(tmp.data+" ");
            preTraverse(tmp.child);
            tmp = tmp.sibling;
        }
    }
    return;

}
    /**
     * main method.
     * an evenly distributed tree with 16 elements is created
     * */
    public static void main(String args[]){
        
        //TREE CONSTRUCTION STARTS HERE
        tree sample = new tree(1);
        
        /**
         * find a node with a particular value
         * add childs to that node
         * if more than one child added to a particular
         * node, then method automatically
         * adds that child as a sibling to the node !
         * */
        Node f = sample.findNode(sample.root,1);
        sample.insertchild(f,2);
        sample.insertchild(f,3);
        sample.insertchild(f,16);
        
        f = sample.findNode(sample.root,2);
        sample.insertchild(f,4);
        sample.insertchild(f,5);
        
        f = sample.findNode(sample.root,4);
        sample.insertchild(f,8);
        sample.insertchild(f,9);
        
        f = sample.findNode(sample.root,5);
        sample.insertchild(f,10);
        sample.insertchild(f,11);
        
        f = sample.findNode(sample.root,3);
        sample.insertchild(f,6);
        sample.insertchild(f,7);
        
        f = sample.findNode(sample.root,6);
        sample.insertchild(f,12);
        sample.insertchild(f,13);
        
        f = sample.findNode(sample.root,7);
        sample.insertchild(f,14);
        sample.insertchild(f,15);
        //TREE CONSTRUCTION ENDS HERE
        
        System.out.println(sample.root.data);
        System.out.print(sample.root.child.data);
        System.out.print(sample.root.child.sibling.data);
        System.out.println(sample.root.child.sibling.sibling.data);
        System.out.print(sample.root.child.child.data);
        System.out.print(sample.root.child.child.sibling.data);
        System.out.print(sample.root.child.sibling.child.data);
        System.out.println(sample.root.child.sibling.child.sibling.data);
        
        System.out.println("Pretraveresed tree is as folows : ");
        sample.preTraverse(sample.root);
        System.out.println();
        
        
        //Find maximum value in the tree
        System.out.println("Maximum number so far in the tree is : "+sample.findMax(sample.root,0));
        
        
    }
}

class Node {
    
    int data;
    Node child;
    Node sibling;
    Node enterLast; //for entering siblings to the end of the list without traversing it
    
    public Node(){}
    public Node(int data){this.data=data;}
    
}