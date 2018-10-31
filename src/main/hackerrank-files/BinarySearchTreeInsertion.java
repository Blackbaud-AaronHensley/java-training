import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

    public static void preOrder( Node root ) {

        if( root == null)
            return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);

    }

 /* Node is defined as :
 class Node
    int data;
    Node left;
    Node right;

    */

    public static Node insert(Node root,int data) {
        Node new_node = new Node(data);

        if(rootIsNull(root)) return new_node;

        Node current = null;
        Node next = root;

        while(nextNotNull(next)) {
            current = next;
            next = (current.data < data) ? current.right : current.left;
        }

        if(current.data < data) {
            current.right = new_node;
        } else {
            current.left = new_node;
        }

        return root;
    }

    private static boolean rootIsNull(Node root) {
        if(root == null) return true;
        return false;
    }

    private static boolean nextNotNull(Node next) {
        if(next != null) return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        preOrder(root);
    }
}