/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

/**
 *
 * @author papillon
 */
public class binarytree {
    
    Node0 root;
    
    public void addnode(int key){
        
        Node0 node = new Node0(key);
        
        if(root==null){
            root = node;
        }
        else {
            
            Node0 temp=root;
            Node0 parent=null;
            
            while(temp!=null){
                
                parent = temp;
                if(temp.key>node.key)
                    temp=temp.left;
                else
                    temp=temp.right;
            }
            
            if(parent.key>node.key)
                parent.left=node;
            else
                parent.right=node;
        }
    }
    
    //inorder
    public void inorder(Node0 node){
        
        if(node!=null) {
            
            inorder(node.left);
            System.out.println(node.key);
            inorder(node.right);
            
        }
        return;
    }
    
    //preorder
    public void preorder(Node0 node){
        
        if(node!=null) {
            
            System.out.println(node.key);
            preorder(node.left);
            preorder(node.right);
            
        }
        return;
    }
    
    
    //postorder
    public void postorder(Node0 node){
        
        if(node!=null) {
            
            postorder(node.left);
            postorder(node.right);
            System.out.println(node.key);
            
        }
        return;
    }
    
    public void find(int key){
        
        Node0 node = root;
        
        while(node!=null) {
            
            if(node.key==key){
                System.out.println("found");
                return;
            }
            
            if(node.key>key)
                node=node.left;
            else
                node=node.right; 
        }
        System.out.println("not found");
    }
    
    
    public static void main(String[] args){
        
        binarytree b = new binarytree();
        
        b.addnode(50);
        b.addnode(25);
        b.addnode(15);
        b.addnode(30);
        b.addnode(75);
        b.addnode(85);
       
        b.preorder(b.root);
        System.out.println();
        b.inorder(b.root);
        System.out.println();
        b.postorder(b.root);
        b.find(80);
        
    }
    
}

class Node0 {
    
    int key;
    Node0 left;
    Node0 right;
    
    Node0(int key){
        
        this.key=key;
        
    }
    
}