# https://www.acmicpc.net/problem/2751
"""
[문제]
N개의 수가 주어졌을 때, 오름차순 정렬
절댓값이 1,000,000 보다 작거나 같은 정수

[문제 유형]
정렬

[풀이 과정]
최대 숫자의 개수는 1,000,000 이기 때문에 기본 정렬인 O(NlogN) 보다 카운트 정렬 O(K) 가 빠르다.
절댓값이기 때문에 숫자의 구간은 -1,000,000 ~ 1,000,000 이므로 2,000,001 개의 공간이 필요하다.
크기가 2,000,001 인 배열을 선언 후 카운트 정렬을 수행하면 된다.
"""

import sys

standard = 10**6
numbers = [0] * (standard * 2 + 1)
n = int(sys.stdin.readline().rstrip())

for _ in range(n):
    m = int(sys.stdin.readline().rstrip())
    numbers[m + standard] += 1

for i, v in enumerate(numbers):
    if v == 1:
        print(i - standard, end="\n")
