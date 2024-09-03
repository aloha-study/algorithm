# https://www.acmicpc.net/problem/15829
"""
[문제]
해시 함수: 임의의 길이를 받아서 고정 문자열 반환
a-z 가 주어진 경우 이를 1-26으로 치환 가능
sum(ar**i) mod M 이 해시 함수

[문제 유형]
구현

[풀이과정]
문자를 숫자로 치환하여 단순 계산 진행

sum(ar**i) mod M 을 수식으로 표현
"""

import sys

MOD = 1234567891
n = int(sys.stdin.readline().rstrip())
text = sys.stdin.readline().rstrip()

result = 0

for i, value in enumerate(text):
    number = ord(value) - ord('a') + 1
    result += (number * 31 ** i)

print(result % MOD)
