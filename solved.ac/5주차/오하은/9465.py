import sys

inputf = sys.stdin.readline

T = int(inputf())
for _ in range(T):
    n = int(inputf())
    arr = []
    ans = [[0 for _ in range(n)] for _ in range(2)]

    for _ in range(2):
        arr.append(list(map(int,inputf().split())))

    ans[0][0] = arr[0][0]
    ans[1][0] = arr[1][0]
    if n == 1:
        print(max(ans[0][0],ans[1][0]))
        continue

    ans[0][1] = arr[1][0] + arr[0][1]
    ans[1][1] = arr[0][0] + arr[1][1]
    
    for x in range(2,n):
        ans[0][x] = max(arr[0][x]+ans[1][x-1],arr[0][x]+ans[1][x-2])
        ans[1][x] = max(arr[1][x]+ans[0][x-1],arr[1][x]+ans[0][x-2])
    
    max_ans = 0
    for r in ans:
        max_ans = max(max_ans,max(r))
    print(max_ans)