//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class LinkedList {
    // Function to print nodes in a given circular linked list
    static void printList(Node head) {
        if (head == null) {
            System.out.println("empty");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
            int key = Integer.parseInt(br.readLine());
            Node head = new Node(arr.get(0));
            Node tail = head;
            for (int i = 1; i < arr.size(); ++i) {
                tail.next = new Node(arr.get(i));
                tail = tail.next;
            }
            tail.next = head; // Make the list circular
            Solution ob = new Solution();
            Node current = ob.deleteNode(head, key);
            Node rev = ob.reverse(current);
            printList(rev);
        }
    }
}

// } Driver Code Ends


/*class Node
{
    int data;
    Node next;
    Node(int d)
    {
        data=d;next=null;
    }
}*/

class Solution {
     Node reverse(Node head) {
        //make single LL from circular LL
        Node cur = head;
        while(cur.next!=head){
            cur=cur.next;
        }
        cur.next=null;
        
        Node org_head=head;
        Node new_head=reverseIt(head);
        //again establish the link to make it circular LL
        org_head.next = new_head;
        return new_head;
    }
    Node reverseIt(Node head){
        Node prev=null, cur=head, save=null;
        while(cur!=null){
            save = cur.next;
            cur.next = prev;
            prev=cur;
            cur=save;
        }
        return prev;
    }

    Node deleteNode(Node head, int key) {
        //check if value present
        Node cur=head.next;
        boolean found=false;
        while(cur!=head){
            if(cur.data==key) found=true;
            cur=cur.next;
        }
        if(head.data==key)  found=true;
        if(!found)  return head;
        
        
        cur=head;
        while(cur.data!=key){
            cur=cur.next;
        }
        //we need to delete cur node
        //to delete that node we need to access it's prev node
        Node temp=head;
        while(temp.next!=cur){
            temp=temp.next;
        }
        temp.next = temp.next.next;
        
        return head.data==key ? head.next : head;
    }
        
}
