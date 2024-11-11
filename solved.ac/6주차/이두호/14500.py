"""
폴리오미노: 1x1인 정사각형을 여러 개 이어서 붙인 도형

- 정사각형은 겹치면 안됨
- 도형은 모두 연결
- 정사각형의 변끼리 연결되어야 함

1)
----

2)
|
|
|_

3)
|
--
 |

4)
--
--

5)
---
 |

회전/대칭 가능

1/2/3/4/5 번 케이스를 회전/대칭하며 점수를 구함.
최대값은?

5 5
1 2 3 20 5
5 4 3 2 1
2 3 4 5 6
6 5 4 3 2
1 2 1 2 1
"""
import sys

n, m = map(int, sys.stdin.readline().rstrip().split())
maps = []
answer = []

for _ in range(n):
    numbers = list(map(int, sys.stdin.readline().rstrip().split()))
    maps.append(numbers)

## I
max_result = 0

for y in range(m):
    for x in range(n - 3):
        result = maps[x][y] + maps[x + 1][y] + maps[x + 2][y] + maps[x + 3][y]
        max_result = max(max_result, result)

answer.append(max_result)

## I 90도 회전
max_result = 0

for y in range(m - 3):
    for x in range(n):
        result = maps[x][y] + maps[x][y + 1] + maps[x][y + 2] + maps[x][y + 3]
        max_result = max(max_result, result)

answer.append(max_result)

## ㅁ
max_result = 0

for y in range(m - 1):
    for x in range(n - 1):
        result = maps[x][y] + maps[x][y + 1] + maps[x + 1][y] + maps[x + 1][y + 1]
        max_result = max(max_result, result)

answer.append(max_result)

## L
max_result = 0

for y in range(m - 1):
    for x in range(n - 2):
        result = maps[x][y] + maps[x + 1][y] + maps[x + 2][y] + maps[x + 2][y + 1]
        max_result = max(max_result, result)

answer.append(max_result)

## L 시계 방향 90도 회전
max_result = 0

for y in range(m - 2):
    for x in range(n - 1):
        result = maps[x + 1][y] + maps[x][y] + maps[x][y + 1] + maps[x][y + 2]
        max_result = max(max_result, result)

answer.append(max_result)

## L 시계 방향 180도 회전
max_result = 0

for y in range(m - 1):
    for x in range(n - 2):
        result = maps[x][y] + maps[x][y + 1] + maps[x + 1][y + 1] + maps[x + 2][y + 1]
        max_result = max(max_result, result)

answer.append(max_result)

## L 시계 방향 270도 회전
max_result = 0

for y in range(m - 2):
    for x in range(n - 1):
        result = maps[x + 1][y] + maps[x + 1][y + 1] + maps[x + 1][y + 2] + maps[x][y + 2]
        max_result = max(max_result, result)

answer.append(max_result)

## L y축 대칭
max_result = 0

for y in range(m - 1):
    for x in range(n - 2):
        result = maps[x][y + 1] + maps[x + 1][y + 1] + maps[x + 2][y + 1] + maps[x + 2][y]
        max_result = max(max_result, result)

answer.append(max_result)

## L y축 대칭 90도 회전
max_result = 0

for y in range(m - 2):
    for x in range(n - 1):
        result = maps[x][y] + maps[x + 1][y] + maps[x + 1][y + 1] + maps[x + 1][y + 2]
        max_result = max(max_result, result)

answer.append(max_result)

## L y축 대칭 180도 회전
max_result = 0

for y in range(m - 1):
    for x in range(n - 2):
        result = maps[x][y + 1] + maps[x][y] + maps[x + 1][y] + maps[x + 2][y]
        max_result = max(max_result, result)

answer.append(max_result)

## L y축 대칭 270도 회전
max_result = 0

for y in range(m - 2):
    for x in range(n - 1):
        result = maps[x][y] + maps[x][y + 1] + maps[x][y + 2] + maps[x + 1][y + 2]
        max_result = max(max_result, result)

answer.append(max_result)

## S
max_result = 0

for y in range(m - 1):
    for x in range(n - 2):
        result = maps[x][y] + maps[x + 1][y] + maps[x + 1][y + 1] + maps[x + 2][y + 1]
        max_result = max(max_result, result)

answer.append(max_result)

## S 90도 회전
max_result = 0

for y in range(m - 2):
    for x in range(n - 1):
        result = maps[x + 1][y] + maps[x + 1][y + 1] + maps[x][y + 1] + maps[x][y + 2]
        max_result = max(max_result, result)

answer.append(max_result)

## S y축 대칭
max_result = 0

for y in range(m - 1):
    for x in range(n - 2):
        result = maps[x][y + 1] + maps[x + 1][y + 1] + maps[x + 1][y] + maps[x + 2][y]
        max_result = max(max_result, result)

answer.append(max_result)

## S y축 대칭 90도 회전
max_result = 0

for y in range(m - 2):
    for x in range(n - 1):
        result = maps[x][y] + maps[x][y + 1] + maps[x + 1][y + 1] + maps[x + 1][y + 2]
        max_result = max(max_result, result)

answer.append(max_result)

## ㅜ
max_result = 0

for y in range(m - 2):
    for x in range(n - 1):
        result = maps[x][y] + maps[x][y + 1] + maps[x][y + 2] + maps[x + 1][y + 1]
        max_result = max(max_result, result)

answer.append(max_result)

## ㅓ
max_result = 0

for y in range(m - 1):
    for x in range(n - 2):
        result = maps[x + 1][y] + maps[x][y + 1] + maps[x + 1][y + 1] + maps[x + 2][y + 1]
        max_result = max(max_result, result)

answer.append(max_result)

## ㅗ
max_result = 0

for y in range(m - 2):
    for x in range(n - 1):
        result = maps[x + 1][y] + maps[x + 1][y + 1] + maps[x + 1][y + 2]  + maps[x][y + 1]
        max_result = max(max_result, result)

answer.append(max_result)

## ㅏ
max_result = 0

for y in range(m - 1):
    for x in range(n - 2):
        result = maps[x][y] + maps[x + 1][y] + maps[x + 2][y] + maps[x + 1][y + 1]
        max_result = max(max_result, result)

answer.append(max_result)

print(max(answer))
