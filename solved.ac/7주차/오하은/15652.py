import sys
from itertools import combinations_with_replacement
inputf = sys.stdin.readline

N,M = map(int,inputf().split())
ans = list(combinations_with_replacement([i for i in range(1,N+1)],M))
for a in ans:
    print(*a)