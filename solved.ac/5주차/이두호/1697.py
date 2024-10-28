import sys
from collections import deque

LIMIT = 100000 + 1
n, k = map(int, sys.stdin.readline().rstrip().split())
visited = [False] * LIMIT
queue = deque([(n, 0)])


def move(x, time):
    if not (0 <= x < LIMIT):
        return
    
    if visited[x]:
        return
    
    visited[x] = True
    return (x, time + 1)


def solution(x, time, queue):
    temp = move(x, time)

    if temp:
        queue.append((temp[0], temp[1]))


while queue:
    x, time = queue.popleft()

    if x == k:
        print(time)
        break

    solution(x - 1, time, queue)
    solution(x + 1, time, queue)
    solution(x * 2, time, queue)
