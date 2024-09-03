# https://www.acmicpc.net/problem/2869
"""
[문제]
높이가 V 미터인 나무 막대
낮에 A 미터 상승
밤에 B 미터 하강
정상 도달 시 필요한 시간은? (단, 정상 도달 시 하강하지 않음)

[풀이과정]
n - 1일 동안 상승 및 하강 반복
마지막 날 상승 

(a - b) * (n - 1) + a = v
n = (v - a) / (a - b) + 1
"""
import sys
import math

a, b, v = map(int, sys.stdin.readline().rstrip().split())

print(math.ceil((v - a) / (a - b) + 1))
