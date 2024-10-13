# https://www.acmicpc.net/problem/1003
"""
[문제]
피보나치 수를 구하는 함수
fibonacci(N)을 호출했을 대, 0과 1이 몇 번 출력되는지 구하는 프로그램

[문제 유형]
DP

[풀이과정]
dp[n][0]: 0이 나온 횟수
dp[n][1]: 1이 나온 횟수

= fibonacci 점화식
dp[i][0] = dp[i - 1][0] + dp[i - 2][0]
dp[i][1] = dp[i - 1][1] + dp[i - 2][1]
"""

import sys

t = int(sys.stdin.readline().rstrip())
dp = [[0, 0] for _ in range(41)]
dp[0] = [1, 0]
dp[1] = [0, 1]

for i in range(2, 41):
    dp[i][0] = dp[i - 1][0] + dp[i - 2][0]
    dp[i][1] = dp[i - 1][1] + dp[i - 2][1]

for _ in range(t):
    number = int(sys.stdin.readline().rstrip())
    print(dp[number][0], dp[number][1])
