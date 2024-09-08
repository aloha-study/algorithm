import sys

inputf=sys.stdin.readline
N=int(inputf())
s=inputf().rstrip()
r=31
M=1234567891
ans = 0
for i in range(N):
    ans+=(ord(s[i])-96)*(r**i)
print(ans%M)