// USACO 2014 January Contest, Bronze
// Problem 1. Ski Course Design

import java.io.*;
import java.util.*;
import java.lang.*;

class skidesign2 {
   public static void main(String[] args) throws IOException
   {
      BufferedReader br = new BufferedReader(new FileReader("skidesign.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int[] narray = new int[101];
      for(int a = 0; a < n; a++)
      {
         st = new StringTokenizer(br.readLine());
         narray[Integer.parseInt(st.nextToken())]++;
      }
      int truemin = Integer.MAX_VALUE;
      for(int x = 0; x <= 83; x++)
      {
         int min = x;
         int max = x+17;
         int cost = 0;
         for(int below = 0; below < min; below++)
            cost += narray[below]*(below-min)*(below-min);
         for(int above = max+1; above < 101; above++)
            cost += narray[above]*(above-max)*(above-max);
         truemin = Math.min(truemin, cost);
      }
      out.println(truemin);
      out.close();
   }
}