import java.io.*;
import java.util.*;
class Node{
    Node left,right;
    int data;
    Node(int data){
        this.data=data;
        left=right=null;
    }
}
class Solution{
static void levelOrder(Node root){
      
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            Node n = q.poll();
            System.out.print(n.data+" ");
            if(n.left != null){
                q.offer(n.left);
            }
            if(n.right != null){
                q.offer(n.right);
            }
        }
      
    }
  public static Node insert(Node root,int data){
      if(root==null){
          return new Node(data);
      }
      else{
          Node cur;
          if(data<=root.data){
              cur=insert(root.left,data);
              root.left=cur;
          }
          else{
              cur=insert(root.right,data);
              root.right=cur;
          }
          return root;
      }
  }
  public static void main(String args[]){
          Scanner sc=new Scanner(System.in);
          int T=sc.nextInt();
          Node root=null;
          while(T-->0){
              int data=sc.nextInt();
              root=insert(root,data);
          }
          levelOrder(root);
      }	
}
