# https://www.acmicpc.net/problem/1676
"""
[문제]
N!에서 뒤에서부터 처음 0이 아닌 숫자가 나올 때까지 0의 개수를 구하는 프로그램

[풀이과정]
0이 나오는 조건
2, 5의 배수 한 쌍
"""
import sys

n = int(sys.stdin.readline().rstrip())
two, five = 0, 0


def calculate(n, m):
    result = 0

    while not n % m:
        n = n // m
        result += 1

    return result


for i in range(1, n + 1):
    two += calculate(i, 2)
    five += calculate(i, 5)

print(min(two, five))
