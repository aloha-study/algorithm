"""
1~N번
p = [3, 1, 4, 3, 2]
d = [3, 4, 8, 11, 13] = 39

p = [1, 2, 3, 3, 4]
d = [1, 3, 6, 9, 13] = 32

기다리는 시간을 최소화하기 위해 오름차순으로 정렬한다.
누적 합계를 더한다.
"""
import sys

n = int(sys.stdin.readline().rstrip())
waiting = sorted(list(map(int, sys.stdin.readline().rstrip().split())))
total = 0
result = []

for time in waiting:
    total += time
    result.append(total)

print(sum(result))
