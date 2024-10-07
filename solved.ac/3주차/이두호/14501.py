# https://www.acmicpc.net/problem/14501
"""
[문제]
N+1일째 되는 날 퇴사하기 위해, 남은 N일 동안 최대한 많은 상담 진행
각 상담을 완료하는데 걸리는 기간 Ti
상담을 했을 때 받을 수 있는 금액 Pi

[문제 유형]
DP

[풀이 과정]
1) 상담을 했을 때 최대 금액 정규식 추출
2) 

[예시]
4
3
0
4
0
==
0
"""
import sys

n = int(sys.stdin.readline().rstrip())
consulting = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(n)]
d = [0] * (n + 1)

for i in range(n):
    for j in range(i + consulting[i][0], n + 1):
        d[j] = max(d[j], d[i] + consulting[i][1])

print(d[-1])
