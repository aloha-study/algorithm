import sys
from math import factorial

inputf = sys.stdin.readline
N = int(inputf())
num = str(factorial(N))
ans = 0
for i in range(len(num)-1,-1,-1):
    if num[i] == '0':
        ans +=1
    else:
        break
print(ans)