//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        //Reading total number of testcases
        int t= sc.nextInt();
        
        while(t-- >0)
        {
            //reading the string
            String st = sc.next();
            
            //calling ispar method of Paranthesis class 
            //and printing "balanced" if it returns true
            //else printing "not balanced"
            if(new Solution().ispar(st) == true)
                System.out.println("balanced");
            else
                System.out.println("not balanced");
        
        }
    }
}
// } Driver Code Ends



class Solution
{
    //Function to check if brackets are balanced or not.
    static boolean ispar(String str)
    {
        // add your code here
           ArrayDeque<Character> st = new ArrayDeque<>();
		
		for ( int i =0 ;  i <str.length() ; i++){
			if(str.charAt(i)=='('  || str.charAt(i) =='['  || str.charAt(i) =='{'  )
				st.push(str.charAt(i));
			
			else{
				if(st.isEmpty()) return false;   // too handle str =")" , "(()))" else throws exception.			
			   
				//not empty
				else if( (str.charAt(i) ==')' && st.pop()=='(') ||
					(str.charAt(i) ==']' && st.pop()=='[') ||
					(str.charAt(i) =='}' && st.pop()=='{') )
			    continue;
				
				else return false;   // when str.charAt(i) is closing say } but pop is opening but not same type say (, [, in this case directly return false;
				// Eg: {(}))}
			}
		}
	return(st.isEmpty());
    }
}
