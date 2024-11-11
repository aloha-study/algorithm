import sys
inputf = sys.stdin.readline

N,K = map(int,inputf().split())
t = 0
q = [N]
arr = [0]*100001
while q:
    n = q.pop(0)
    if n == K:
        print(arr[n])
        break
    for i in (n+1,n-1,n*2):
        if 0<=i<=100000 and not arr[i]:
            arr[i] = arr[n]+1
            q.append(i)