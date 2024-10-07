import sys

inputf=sys.stdin.readline

T = int(inputf())
for _ in range(T):
    N, M = map(int,inputf().split())
    q = list(map(int,inputf().split()))
    ans = 1
    cnt = 0
    while q:
        max_n = max(q)
        cur = q.pop(0)
        if max_n == cur:
            cnt+=1
            if M == 0:
                print(cnt)
                break
        else:
            q.append(cur)
            if M == 0:
                M = len(q)
        M -= 1



# 시도했지만 틀린 풀이
# - 중요도가 같은 값이 있는 경우를 고려하지 않음
# for _ in range(T):
#     N, M = map(int,inputf().split())
#     arr = list(map(int,inputf().split()))
#     dic = dict()
#     # 출력되는 순서대로 정렬
#     sorted_arr = sorted(arr,reverse=True)
#     # {key(값) : value(출력되는 순서) }
#     for i in range(len(arr)):
#         dic[sorted_arr[i]] = i
#     # M번째로 입력된 값 -> 크기에 따라 정렬되어 인쇄된 순번 출력
#     ans.append(dic[arr[M]])
