import sys
inputf = sys.stdin.readline

N = int(inputf())
arr = list(map(int,inputf().split()))
mid = N//2
fruit = [0 for _ in range(N)]
fruit[mid] = 1
for i in range(mid-1,-1,-1):
    n = len(set(arr[i:mid+1]))
    if n>2:
        break
    else:
        fruit[i]=n
for i in range(mid+1,N):
    n = len(set(arr[mid:i+1]))
    if n>2:
        break
    else:
        fruit[i]=n
print(fruit)

# 못품