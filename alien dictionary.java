//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.next());
        while (t-- > 0) {
            int n = Integer.parseInt(sc.next());
            int k = Integer.parseInt(sc.next());

            String[] words = new String[n];

            for (int i = 0; i < n; i++) {
                words[i] = sc.next();
            }

            Solution ob = new Solution();
            //  System.out.println(T.findOrder(words,k));
            String order = ob.findOrder(words, n, k);
            if (order.length() == 0) {
                System.out.println(0);
                continue;
            }
            if (order.length() != k) {
                System.out.println("INCOMPLETE");
                return;
            }
            String temp[] = new String[n];
            for (int i = 0; i < n; i++) temp[i] = words[i];

            Arrays.sort(temp, new Comparator<String>() {
                @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for (int i = 0;
                         i < Math.min(a.length(), b.length()) && index1 == index2;
                         i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }

                    if (index1 == index2 && a.length() != b.length()) {
                        if (a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }

                    if (index1 < index2)
                        return -1;
                    else
                        return 1;
                }
            });

            int flag = 1;
            for (int i = 0; i < n; i++) {
                if (!words[i].equals(temp[i])) {
                    flag = 0;
                    break;
                }
            }

            System.out.println(flag);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
     private static void topologicalSort(int v, boolean[] visited, Stack<Character> stack, Map<Character, List<Character>> adj) {
        visited[v] = true;
        char c = (char)(v + 'a');
        
        if (adj.containsKey(c)) {
            for (char neighbor : adj.get(c)) {
                if (!visited[neighbor - 'a']) {
                    topologicalSort(neighbor - 'a', visited, stack, adj);
                }
            }
        }
        
        stack.push(c);
    }
    public String findOrder(String[] dict, int n, int k) {
        // Write your code here
         Map<Character, List<Character>> adj = new HashMap<>();
        
        // Build the graph
        for (int i = 0; i < n - 1; i++) {
            String word1 = dict[i];
            String word2 = dict[i + 1];
            
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    adj.putIfAbsent(word1.charAt(j), new ArrayList<>());
                    adj.get(word1.charAt(j)).add(word2.charAt(j));
                    break;
                }
            }
        }
        
        // Perform topological sort
        Stack<Character> stack = new Stack<>();
        boolean[] visited = new boolean[k];
        
        for (int i = 0; i < k; i++) {
            if (!visited[i]) {
                topologicalSort(i, visited, stack, adj);
            }
        }
        
        // Generate the final order string
        StringBuilder order = new StringBuilder();
        while (!stack.isEmpty()) {
            order.append(stack.pop());
        }
        
        return order.toString();
         
    }
}
