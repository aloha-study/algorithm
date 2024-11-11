
import sys
inputf = sys.stdin.readline

T = int(inputf())

P=[0]*101
P[1]=1
P[2]=1
P[3]=1
P[4]=2
P[5]=2
P[6]=3
P[7]=4
P[8]=5
P[9]=7
P[10]=9
for i in range(11,101):
    P[i]=P[i-3]+P[i-2]

for _ in range(T):
    print(P[int(inputf())])