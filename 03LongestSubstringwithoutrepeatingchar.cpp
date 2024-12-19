class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        // Map to store the last seen index of each character
        unordered_map<char, int> lastSeen;
        int maxLength = 0; // Maximum length of substring
        int start = 0;     // Start of the current window
        
        for (int end = 0; end < s.length(); ++end) {
            char currentChar = s[end];
            
            // If the character is already in the substring, move the start
            if (lastSeen.find(currentChar) != lastSeen.end() && lastSeen[currentChar] >= start) {
                start = lastSeen[currentChar] + 1;
            }
            
            // Update the last seen index of the character
            lastSeen[currentChar] = end;
            
            // Calculate the current window size
            maxLength = max(maxLength, end - start + 1);
        }
        
        return maxLength;
    }
};
