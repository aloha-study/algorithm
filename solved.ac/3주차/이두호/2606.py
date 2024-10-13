# https://www.acmicpc.net/problem/2606
"""
[문제]
1번 컴퓨터가 웜 바이러스에 걸림
1번에 연결된 컴퓨터는 웜 바이러스에 걸림

[문제 유형]
그래프

[풀이 과정]
1) 1번 컴퓨터 바이러스 걸림
2) 주변을 탐색하여 (BFS/DFS) 연결되어있는지 확인
3) 총 바이러스 걸린 컴퓨터 개수 - 1 (1번 컴퓨터)

[예시]
7
6
1 2
2 3
1 5
5 2
5 6
4 7
==
4

1 ㅡ 2 ㅡ 3
ㄴㅡㅡㄴㅡㅡ 5 ㅡ 6

4 ㅡ 7
"""

import sys
from collections import deque

n = int(sys.stdin.readline().rstrip())
m = int(sys.stdin.readline().rstrip())
edges = [[] for _ in range(n + 1)]
contamination = [False] * (n + 1)

for _ in range(m):
    x, y = map(int, sys.stdin.readline().rstrip().split())
    edges[x].append(y)
    edges[y].append(x)


queue = deque([])
queue.append(1)
contamination[1] = True

while queue:
    c = queue.popleft()

    for v in edges[c]:
        if not contamination[v]:
            contamination[v] = True
            queue.append(v)

print(sum(contamination) - 1)
