import string

class Solution:
    def isPalindrome(self, s: str) -> bool:
        s = s.translate(str.maketrans('', '', string.punctuation + ' '))
        s = s.lower()
        print(s)
        
        left = 0
        right = len(s) - 1
        
        while left < len(s) // 2:
            if s[left] != s[right]:
                return False
            left += 1
            right -= 1
        return True

inst = Solution()

inputs = ["A man, a plan, a canal: Panama12312"]

for input in inputs:
    print(inst.isPalindrome(input))
    