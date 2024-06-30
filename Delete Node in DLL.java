//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;
    Node prev;

    Node(int x) {
        data = x;
        next = null;
        prev = null;
    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Node head = null;
            Node tail = head;

            for (int i = 0; i < n; i++) {
                int temp = sc.nextInt();
                if (head == null) {
                    head = new Node(temp);
                    tail = head;
                } else {
                    Node newNode = new Node(temp);
                    tail.next = newNode;
                    newNode.prev = tail;
                    tail = newNode;
                }
            }
            int x = sc.nextInt();

            Solution obj = new Solution();
            Node res = obj.deleteNode(head, x);

            Node.printList(res);
        }
    }
}

// } Driver Code Ends


/*

Definition for doubly Link List Node
class Node
{
    int data;
    Node next;
    Node prev;
    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    public Node deleteNode(Node head, int position) {
           if (head == null || position <= 0) {
            return head;
        }
        
        Node current = head;
        
        // If head needs to be removed
        if (position == 1) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return head;
        }
        
        // Traverse the list to find the node to be deleted
        for (int i = 1; current != null && i < position; i++) {
            current = current.next;
        }
        
        // If the position is more than the number of nodes
        if (current == null) {
            return head;
        }
        
        // Delete the node
        if (current.next != null) {
            current.next.prev = current.prev;
        }
        
        if (current.prev != null) {
            current.prev.next = current.next;
        }
        
        return head;
    }
}
