//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s, patt;
            s = sc.next();
            patt = sc.next();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.search(patt, s);
            if(res.size()==0)
                System.out.print(-1);
            else {
                for(int i = 0;i<res.size();i++)
                    System.out.print(res.get(i) + " ");
            }
            System.out.println();    
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {

  ArrayList<Integer> search(String pat, String txt) {
    int i = 0;
    int N = txt.length();
    
    int j = 0;
    int M = pat.length();
    int[] lps = new int[M];
    computeLPS(pat, lps);
    
    ArrayList<Integer> sol = new ArrayList<Integer>();
    
    while (i < N) {
      if (pat.charAt(j) == txt.charAt(i)) {
        i++;
        j++;
      }
      if (j == M) {
        sol.add(i - j + 1);
        j = lps[j - 1];
      } else if (i < N && pat.charAt(j) != txt.charAt(i)) {
        if (j > 0) {
          j = lps[j - 1];
        } else {
          i++;
        }
      }
    }
    return sol;
  }

  void computeLPS(String pat, int[] lps) {
    int M = pat.length();
    int i = 1;
    int len = 0;
    lps[0] = 0;
    while (i < M) {
      if (pat.charAt(i) == pat.charAt(len)) {
        lps[i++] = ++len;
      } else {
        if (len > 0) {
          len = lps[len - 1];
        } else {
          lps[i++] = 0;
        }
      }
    }
  }
}
