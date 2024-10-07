import sys

inputf = sys.stdin.readline
S = inputf().rstrip()
q  = []
num = []
op = []
minus = []
for s in S:
    if s == "+" or s =="-":
        num.append(int(''.join(q)))
        op.append(s)
        q = []
    else:
        q.append(s)
if q:
    num.append(int(''.join(q)))

# 연산자가 - 인 경우를 만나면 다음 - 를 만날 때까지 minus[i]에 값을 더해가면서 저장, 가장 큰 음수 값을 구함
for i in range(len(op)):
    if op[i] == "-":
        minus.append(num[i+1])
    else:
        if minus:
            minus[-1] += num[i+1]

print(sum(num)-sum(minus)*2)