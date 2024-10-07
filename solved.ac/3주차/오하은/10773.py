import sys
inputf=sys.stdin.readline

N = int(inputf()) 
stack = []
for _ in range(N):
    n = int(inputf())
    if n==0:
        stack.pop()
    else:
        stack.append(n)
print(sum(stack))