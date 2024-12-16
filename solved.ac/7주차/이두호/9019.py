import sys
from collections import deque

t = int(sys.stdin.readline().rstrip())

MAX_VALUE = 10000

def bfs(a, b):
    queue = deque([a])
    visited[a] = True

    while queue:
        x = queue.popleft()

        d = (x * 2) % MAX_VALUE
        s = 9999 if x == 0 else x - 1
        l = int(str(x).zfill(4)[1:] + str(x).zfill(4)[0])
        r = int(str(x).zfill(4)[-1] + str(x).zfill(4)[:-1])

        if visited[b]:
            break

        if not visited[d]:
            queue.append(d)
            visited[d] = True
            commands[d] = commands[x] + 'D'

        if not visited[s]:
            queue.append(s)
            visited[s] = True
            commands[s] = commands[x] + 'S'

        if not visited[l]:
            queue.append(l)
            visited[l] = True
            commands[l] = commands[x] + 'L'

        if not visited[r]:
            queue.append(r)
            visited[r] = True
            commands[r] = commands[x] + 'R'


for _ in range(t):
    commands = ['' for _ in range(MAX_VALUE)]
    visited = [False] * MAX_VALUE
    a, b = map(int, sys.stdin.readline().rstrip().split())
    bfs(a, b)
    print(commands[b])
