"""
--: (0, 0) ~ (2 ** (n - 1) - 1, 2 ** (n - 1) - 1)                       : 초기값
-+: (0, 2 ** (n - 1)) ~ (2 ** (n - 1) - 1, 2 ** n - 1)                  : 초기값 + 1 * 2 ** (n - 1) * 2 ** (n - 1)
+-: (2 ** (n - 1), 0) ~ (2 ** n - 1, 2 ** (n - 1) - 1)                  : 초기값 + 2 * 2 ** (n - 1) * 2 ** (n - 1)
++: (2 ** (n - 1) - 1, 2 ** (n - 1) - 1) ~ (2 ** n - 1, 2 ** n - 1)     : 초기값 + 3 * 2 ** (n - 1) * 2 ** (n - 1)
"""
import sys

n, r, c = map(int, sys.stdin.readline().rstrip().split())
result = 0

while n != 0:
    n -= 1
    standard = 2 ** n

    # 왼쪽 위
    if r < 2 ** n and c < 2 ** n:
        result += 0 * standard * standard

    # 오른쪽 위
    if r < 2 ** n and c >= 2 ** n:
        result += 1 * standard * standard
        c -= standard

    # 왼쪽 아래
    if r >= 2 ** n and c < 2 ** n:
        result += 2 * standard * standard
        r -= standard
    
    # 오른쪽 아래
    if r >= 2 ** n and c >= 2 ** n:
        result += 3 * standard * standard
        c -= standard
        r -= standard

print(result)
