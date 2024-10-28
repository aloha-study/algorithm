"""
1
11 13 5 13

1
4 3 3 3
"""
import sys

t = int(sys.stdin.readline().rstrip())

for _ in range(t):
    m, n, x, y = map(int, sys.stdin.readline().rstrip().split())

    temp = -1

    for i in range(40000 + 1):
        number = i * m + x

        if number % n == y or (n == y and number % n == 0):
            temp = number
            break
    
    print(temp)
