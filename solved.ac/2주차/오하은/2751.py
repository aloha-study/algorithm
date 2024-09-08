import sys
inputf = sys.stdin.readline
N = int(inputf())
arr = [int(inputf()) for _ in range(N)]
arr.sort()
for i in arr:
    print(i)