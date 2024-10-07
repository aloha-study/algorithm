import sys
inputf = sys.stdin.readline

arr = []
N = int(inputf())
for _ in range(N):
    arr.append(list(map(int,inputf().split())))

ans =[[0] for _ in range(N+1)]
for i in range(N):
    d, p = arr[i][0], arr[i][1]
    if i+d <= N:
        e = max(max(inner) for inner in ans[:i+1]) + p
        ans[i+d].append(e)

print(max(max(inner) for inner in ans))