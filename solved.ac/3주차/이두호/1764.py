# https://www.acmicpc.net/problem/1764
"""
[문제]
듣도 못한 수 N, 보도 못한 수 M
N, M 명이 주어질 때 중복되는 인원을 찾아(듣보잡) 알파벳 순으로 출력

[문제 유형]
구현

[풀이과정]
1. 듣도 못한 인원과 보도 못한 인원의 교집합을 구한다.
2. 알파벳 순으로 정렬한다.
3. 출력한다.
"""
import sys

n, m = map(int, sys.stdin.readline().rstrip().split())
a = set()
b = set()

for _ in range(n):
    a.add(sys.stdin.readline().rstrip())

for _ in range(m):
    b.add(sys.stdin.readline().rstrip())

c = sorted(a.intersection(b))

print(len(c), *c, sep="\n")
