"""
[문제]
동전은 총 N 종류 / 각각의 동전은 매우 많이 가지고 있다.
동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다.
필요한 동전 개수의 최솟값은?

[문제 유형]
그리디

[문제풀이]
1. 동전의 끝에서부터 차례대로 나눈다.
2. 나머지를 구한 후 반복한다.

"""
import sys

n, k = map(int, sys.stdin.readline().rstrip().split())
coins = []
for _ in range(n):
    coins.append(int(sys.stdin.readline().rstrip()))

result = 0

for i in range(n - 1, -1, -1):
    coin = coins[i]
    result += k // coin
    k %= coin

print(result)
