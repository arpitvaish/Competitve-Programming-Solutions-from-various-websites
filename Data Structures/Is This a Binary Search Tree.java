The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/
   
    boolean checkBST(Node root) {
       
        return checkbst(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
        
    }
    boolean checkbst(Node root, int max, int min){
        if(root == null)
            return true;
        if(root.data <= min || root.data >= max){
            return false;
        }
        return checkbst( root.left, root.data, min) && checkbst(root.right, max, root.data);
    }
