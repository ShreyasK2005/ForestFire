import java.util.*;
public class RecursionPractice11
{
   public static void main(String[] args) {
      
      System.out.println(longestCommonSub("12345", "54321 21 54321"));  
   }
   
   
   public static void printBinary(int digits)
   {
      String results = "";
      printBinaryHelper(digits, results);
   }
   private static void printBinaryHelper(int digits, String result)
   {
      if(result.length() == digits)
      {
         System.out.print(result + " ");
      }
      else
      {
         printBinaryHelper(digits, result + 0);
         printBinaryHelper(digits, result + 1);
      }
   }
   public static void climbStairs(int steps)
   {
      String results = "";
      climbStairsHelper(steps, results);
   } 
   private static void climbStairsHelper(int steps, String result)
   {
      if(steps == 0)
      {
         System.out.println(result.substring(0, result.length() - 2) + "");
         return;
      }
      else if(steps == 1)
      {
         System.out.println(result  + "1");
         return;
      }
      else
      {
         climbStairsHelper(steps - 1, result + "1, ");
         climbStairsHelper(steps - 2, result + "2, ");
      }
   } 
   public static void campsite(int x, int y)
   {
      String result = "";
      campsiteLocator(x, y, result);
    
   }
   private static void campsiteLocator(int x, int y, String result)
   {
      if(x == 0 && y == 0)
      {
         System.out.println(result);
         return;
      }
      else if(x == 0 && y > 0)
      {
         campsiteLocator(x, y-1, result + "N ");
         return;
      }
      else if(x > 0 && y == 0)
      {
         campsiteLocator(x-1, y, result + "E ");
         return;
      }
      else
      {
         campsiteLocator(x-1, y-1, result + "NE ");
         campsiteLocator(x, y-1, result + "N ");
         campsiteLocator(x-1, y, result + "E ");
      }
   }
   
     
   public static int getMax(List<Integer> nums, int limit)
   {
      return getMax(nums, limit, 0, 0);
   }
   private static int getMax(List<Integer> nums, int limit, int i, int max)
   {
      if(i == nums.size())
      {
         if(max <= limit)
         {
            return max;
         }
         return Integer.MIN_VALUE;
      }
      
      return Math.max(getMax(nums, limit, i + 1, max), getMax(nums, limit, i + 1, nums.get(i) + max));
   }

   public static int makeChange(int amount) 
   {
     return makeChangeHelper(amount, 25);
   }
  
  
    private static int makeChangeHelper(int aR, int lD)
    {
      int s = 0;
      if(aR == 0)
      {
       return 1;
      }
      if(aR >= 25 && 25 <= lD)
      {
        s+=makeChangeHelper(aR - 25, 25);
      }
      if(aR >= 10 && 10 <= lD)
      {
        s+=makeChangeHelper(aR - 10, 10);
      }
      if(aR >= 5 && 5 <= lD)
      {
        s+=makeChangeHelper(aR - 5, 5);
      }
      if(aR >= 1 && 1 <= lD)
      {
        s+=makeChangeHelper(aR - 1, 1);
      }
      return s;
    }
    
    public static void makeChangeAndPrint(int amount)
    {
       System.out.println("P  N  D  Q");
       System.out.println("-----------");
       makeChangeHelper(amount, 25, 0, 0, 0, 0);
    }
    
    private static void makeChangeHelper(int aR, int lD, int p, int n, int d, int q)
    {
      if(aR == 0)
      {
       System.out.println("[" +  p + ", " + n + ", " + d + ", " + q + "]");
      }
      if(aR >= 25 && 25 <= lD)
      {
        makeChangeHelper(aR - 25, 25, p, n, d, q+1);
      }
      if(aR >= 10 && 10 <= lD)
      {
        makeChangeHelper(aR - 10, 10, p, n, d+1, q);

      }
      if(aR >= 5 && 5 <= lD)
      {
        makeChangeHelper(aR - 5, 5, p, n+1, d, q);

      }
      if(aR >= 1 && 1 <= lD)
      {
        makeChangeHelper(aR - 1, 1, p+1, n, d, q);

      }      
    }
    public static String longestCommonSub(String a, String b)
    {
      if(a.length() == 0 || b.length() == 0)
       {
         return " ";
       }
       if(a.charAt(0) == b.charAt(0))
       {
            return a.charAt(0) + longestCommonSub(a.substring(0+1, a.length()), b.substring(0+1, b.length()));
       }
       String t = longestCommonSub(a.substring(0+1, a.length()), b);
       String h = longestCommonSub(a, b.substring(0+1, b.length()));
       if(t.length() > h.length())
       {
         return t;
       }
       return h;
    }
    
}