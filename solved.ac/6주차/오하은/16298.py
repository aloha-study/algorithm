import sys
inputf = sys.stdin.readline

N,M = map(int,inputf().split())
l_dict={}
s_dict={}
for _ in range(N):
    a,b=map(int,inputf().split())
    l_dict[a] = b
for _ in range(M):
    a,b=map(int,inputf().split())
    s_dict[a] = b

ans = [0]*101
visited = [0]*101
q=[1]
while q:
    i = q.pop(0)
    if i == 100:
        print(ans[i])
        break
    for d in range(1,7):
        ni = i + d
        if ni <=100 and not visited[ni]:
            if ni in l_dict.keys():
                ni = l_dict[ni]
            elif ni in s_dict.keys():
                ni = s_dict[ni]
            if not visited[ni]:
                visited[ni] = 1
                ans[ni] = ans[i]+1
                q.append(ni)