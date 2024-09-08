import sys
inputf=sys.stdin.readline

A, B, V = map(int,inputf().split())
x = (V-B)/(A-B)
if x == int(x):
    print(int(x))
else:
    print(int(x) + 1)