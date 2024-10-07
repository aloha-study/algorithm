# https://www.acmicpc.net/problem/10773
"""
[문제]
0이 나오면, 가장 최근 수를 지운다.
모든 수를 받아 적은 후 그 수의 합을 구하시오.

[문제 유형]
구현

[풀이 과정]
1) 큐에 숫자를 넣습니다.
2) 0인 경우 큐에서 숫자를 제거합니다.
3) 큐에 남아있는 숫자를 더합니다.
4) 정수가 0일 경우 지울 수 있는 수가 있음을 보장하기 때문에 최초에 0이 오는 경우는 제외합니다

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
numbers = []

for _ in range(n):
    number = int(sys.stdin.readline().rstrip())
    if number:
        numbers.append(number)
    else:
        numbers.pop()

print(sum(numbers))
