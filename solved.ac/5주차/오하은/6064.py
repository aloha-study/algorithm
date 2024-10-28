import sys

inputf = sys.stdin.readline
k = int(inputf())

def find(m, n, x, y):
    k = x 
    while k <= m * n: 
        if (k - x) % m == 0 and (k - y) % n == 0: 
            return k
        k += m 
    return -1


for _ in range(k):
    M,N,x,y = map(int, sys.stdin.readline().split())
    print(find(M,N,x,y))



# 틀린 풀이

# def find(M,N,x,y):
#     for i in range(M+1):
#         for j in range(N+1):
#             if M*i+x == N*j+y:
#                 return M*i+x
#     return -1

# for _ in range(k):
#     M,N,x,y = map(int,inputf().split())
#     print(find(M,N,x,y))

# ?? = M*i +x , N*j +y