# https://www.acmicpc.net/problem/1966
"""
[문제]
1. 현재 Queue의  가장 앞에 있는 문서의 중요도 확인
2. 나머지 문서들 중 현재 문서보다 중요도가 높은 문서가 있는 경우 Queue의 가장 뒤에 재배치
3. 중요도가 가장 높으면 인쇄

[문제 유형]
구현

[풀이과정]
1. 내가 보고자 하는 문서 마킹
2. Queue에서 꺼낸 후 가장 높은 중요도를 가졌는지 확인
3. 마킹된 문서를 출력할 때까지 반복
"""
import sys
from collections import deque

t = int(sys.stdin.readline().rstrip())

for _ in range(t):
    a, b = map(int, sys.stdin.readline().rstrip().split())
    papers = list(map(int, sys.stdin.readline().rstrip().split()))
    queue = deque([(value, True) if b == index else (value, False) for index, value in enumerate(papers)])
    result = 0

    while True:
        c = queue.popleft()

        if not queue:
            result += 1
            break

        if c[0] >= max(queue, key=lambda x: x[0])[0]:
            result += 1
            if c[1]:
                break
        else:
            queue.append(c)

    print(result)
