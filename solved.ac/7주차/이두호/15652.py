"""
Back Tracking
- Decision Spac
- 진행할 필요가 없는 경우 계산 x
- 새로운 가능성을 나타냄
-> BT 종료 조건이 있어야한다.

   O  O  O
 O O O O O O


"""
import sys

n, m = map(int, sys.stdin.readline().rstrip().split())

result = []

def backTracking(index, num, candidate):
    if index == m:
        result.append(candidate)
        return
    
    for i in range(num, n + 1):
        backTracking(index + 1, i, candidate + [i])


backTracking(0, 1, [])

for value in result:
    print(*value, sep=" ")
