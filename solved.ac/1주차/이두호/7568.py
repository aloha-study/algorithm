import sys

n = int(sys.stdin.readline().rstrip())
people = []
result = [1] * n

for _ in range(n):
    h, w = map(int, sys.stdin.readline().rstrip().split())
    people.append((h, w))

for i in range(n):
    for j in range(n):
        h1, w1 = people[i]
        h2, w2 = people[j]

        if h2 > h1 and w2 > w1:
            result[i] += 1

print(*result, sep=" ")
