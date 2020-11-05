/*
USACO 2020 February Contest, Silver
Problem 3. Clock Tree
*/

import java.io.*;
import java.util.*;
import java.lang.*;

public class clocktree {
   public static boolean[] visited;
   public static room[] rooms;
   public static void main(String[] args) throws IOException
   {
      BufferedReader br = new BufferedReader(new FileReader("clocktree.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("clocktree.out")));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      rooms = new room[n+1];
      int[] clocks = new int[n+1];
      st = new StringTokenizer(br.readLine());
      for(int x = 1; x <= n; x++)
      {
         int clock = Integer.parseInt(st.nextToken()) % 12;
         rooms[x] = new room(x, clock);
         clocks[x] = clock;
      }
      for(int z = 0; z < n-1; z++)
      {
         st = new StringTokenizer(br.readLine());
         int one = Integer.parseInt(st.nextToken());
         int two = Integer.parseInt(st.nextToken());
         rooms[one].neighbors.add(two);
         rooms[two].neighbors.add(one);
      }
      int total = 0;
      visited = new boolean[n+1];
      for(int r = 1; r <= n; r++)
      {
         dfs(r);
         if(rooms[r].clock == 0 || rooms[r].clock == 1)
            total++;
         for(int i = 1; i <= n; i++)
         {
            rooms[i].clock = clocks[i];
            visited[i] = false;
         }
      }
      out.println(total);
      out.close();
   }
   public static class room
   {
      public int num;
      public int clock;
      public ArrayList<Integer> neighbors;
      public room(int num, int clock)
      {
         this.num = num;
         this.clock = clock;
         neighbors = new ArrayList<Integer>();
      }
   }
   public static void dfs(int r)
   {
      rooms[r].clock += rooms[r].neighbors.size();
      int change = 0;
      visited[r] = true;
      for(int i: rooms[r].neighbors)
      {
         if(!visited[i])
         {
            dfs(i);
            change += 12 - rooms[i].clock;
         }
      }
      rooms[r].clock += change;
      rooms[r].clock %= 12;
   }
}
