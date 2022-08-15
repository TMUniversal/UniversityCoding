import sys


def check_palindrome(s: str) -> bool:
    for i in range(len(s)):
        if s[i].lower() != s[len(s) - 1 - i].lower():
            return False
    return True


dateiname = sys.argv[1]

with open(dateiname) as f:
    words = f.read().lower().split()

summe = 0
for word in words:
    if check_palindrome(word):
        summe += 1

print(summe)
