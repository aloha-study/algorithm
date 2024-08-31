import sys
inputf = sys.stdin.readline
N = int(inputf())
size = list(map(int,inputf().split()))
T,P = map(int,inputf().split())
cnt_T = 0
for i in size:
    if i % T == 0:
        cnt_T+=i//T
    else:
        cnt_T+=i//T+1
print(cnt_T)
print(*[N//P,N%P])