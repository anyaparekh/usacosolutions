/*
USACO 2014 January Contest, Bronze
Problem 2. Bessie Slows Down
*/

import java.io.*;
import java.util.*;
import java.lang.*;
 
class slowdown
{
   public static void main(String[] args) throws IOException
   {
      BufferedReader br = new BufferedReader(new FileReader("slowdown.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("slowdown.out")));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      ArrayList<Integer> t = new ArrayList<Integer>();
      ArrayList<Integer> d = new ArrayList<Integer>();
      for(int x = 0; x < n; x++)
      {
         st = new StringTokenizer(br.readLine());
         String val = st.nextToken();
         int i = Integer.parseInt(st.nextToken());
         if(val.equals("T"))
            t.add(i);
         else
            d.add(i);
      }
      Collections.sort(t);
      Collections.sort(d);
      double speed = 1.0;
      double[][] arr = new double[1][2];
      arr[0][0] = 0; // seconds
      arr[0][1] = 0; // distance
      for(int y = 0; y < n; y++)
      {
         double i1 = 0;
         double i2 = 0;
         boolean bool1 = false;
         boolean bool2 = false;
         if(t.size() > 0)
            i1 = t.get(0) - arr[0][0];
         else
            i1 = Integer.MAX_VALUE;
         if(d.size() > 0)
            i2 = (d.get(0) - arr[0][1]) / (1.0/speed);
         else
            i2 = Integer.MAX_VALUE;
         if(i1 <= i2)
         {
            arr[0][1] = arr[0][1] + (t.get(0) - arr[0][0]) * (1.0/speed);
            arr[0][0] = t.get(0);
            t.remove(0);
         }
         else if(i1 > i2)
         {
            arr[0][0] = arr[0][0] + (d.get(0) - arr[0][1]) / (1.0/speed);
            arr[0][1] = d.get(0);  
            d.remove(0); 
         }
         speed++;
      }
      double i3 = (1000 - arr[0][1]) / (1.0/speed);
      out.println(Math.round(arr[0][0] + i3));
      out.close();
   }
}