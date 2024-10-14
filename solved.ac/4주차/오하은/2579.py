import sys

inputf = sys.stdin.readline

N = int(inputf())
arr = []
max_s =[]
for _ in range(N):
    arr.append(int(inputf()))

if N == 1:
    print(arr[0])
    quit()
elif N == 2:
    print(arr[0]+arr[1])
    quit()
elif N == 3:
    print(max(arr[0]+arr[1],arr[0]+arr[2],arr[1]+arr[2]))
    quit()

max_s.append(arr[0])
max_s.append(arr[0]+arr[1])
max_s.append(max(arr[0]+arr[2],arr[1]+arr[2]))
for i in range(3,N):
    max_s.append(max(max_s[i-3]+arr[i-1]+arr[i],max_s[i-2]+arr[i]))

print(max_s[-1])


## [...] [max] [] [O] [O]
## [...] [...] [max] [] [O]