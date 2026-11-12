import java.util.Arrays;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        
        int[] lastSeen = new int[128];
        
       
        Arrays.fill(lastSeen, -1);
        
        int maxLength = 0;
        int left = 0; 
        
       
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            
            
            if (lastSeen[currentChar] >= left) {
                left = lastSeen[currentChar] + 1;
            }
            
            
            lastSeen[currentChar] = right;
            
           
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }

    public static void main(String[] args) {
        Solution solver = new Solution();
        
    
        System.out.println(solver.lengthOfLongestSubstring("abcabcbb")); // Output: 3 ("abc")
        System.out.println(solver.lengthOfLongestSubstring("bbbbb"));    // Output: 1 ("b")
        System.out.println(solver.lengthOfLongestSubstring("pwwkew"));   // Output: 3 ("wke")
    }
}
