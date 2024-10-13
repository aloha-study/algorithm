"""
[문제]
1. 한 계단 or 두 계단
2. 연속 세 계단 불가
3. 마지막 계단은 반드시

[문제 유형]
DP

[풀이과정]
d[n][m]: n번째 계단을 밟았을 때, 이전 계단 밟은 여부 (m / 0: 이전 계단 밟지 않음, 1: 이전 계단 밟은)

[예제]
6
10
20
15
25
10
20
0 10 30 35 55 65 75
"""
import sys

n = int(sys.stdin.readline().rstrip())
scores = [0]
d = [[0, 0] for _ in range(n + 1)]

for _ in range(n):
    scores.append(int(sys.stdin.readline().rstrip()))

d[1][0] = scores[1]
d[1][1] = scores[1]

for i in range(2, n + 1):
    d[i][0] = max(d[i - 2]) + scores[i]
    d[i][1] = d[i - 1][0] + scores[i]

print(max(d[n]))
