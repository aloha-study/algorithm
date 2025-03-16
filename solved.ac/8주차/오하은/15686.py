import sys

inputf = sys.stdin.readline

N,M = map(int,inputf().split())
city = []
chicken = []
house = []
for y in range(N):
    row = list(map(int,inputf().split()))
    city.append(row)
    for x in range(N):
        if city[y][x] == 2:
            chicken.append((x,y))
        elif city[y][x] == 1:
            house.append((x,y))

ans = float("inf")
visited = [0] * len(chicken)
def get_chicken_distance_dfs(idx,cnt):
    global ans
    if cnt == M:
        dist_sum = 0
        for hx,hy in house:
            dist = float("inf")
            for j in range(len(chicken)):
                if visited[j]:
                    cx,cy = chicken[j]
                    check_dist = abs(cx-hx)+abs(cy-hy)
                    dist = min(check_dist,dist)
            dist_sum += dist
        ans = min(ans,dist_sum)
        return
    
    for i in range(idx,len(chicken)):
        if not visited[i]:
            visited[i] = 1
            get_chicken_distance_dfs(i+1,cnt+1)
            visited[i] = 0

get_chicken_distance_dfs(0,0)
print(ans)