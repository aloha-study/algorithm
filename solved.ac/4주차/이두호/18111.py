"""
[문제]
1. 블록을 제거하여 인벤토리에 넣는다. (2초)
2. 인벤토리에서 블록 하나를 꺼내어 가장 위에 있는 블록 위에 놓는다. (1초)

땅을 평탄하게 한다.
최소 시간과 그 경우 땅의 높이를 구하시오.


3 3 0
23 21 17
44 18 29
25 16 32

90 25

1 7 10
65 64 64 64 63 62 0
"""
import sys

n, m, b = map(int,input().split())
block = []

for _ in range(n):
    block.append([int(x) for x in sys.stdin.readline().rstrip().split()])

answer = int(1e9)
level = 0

for height in range(257):
    use_block = 0
    take_block = 0
    
    for x in range(n):
        for y in range(m):
            if block[x][y] > height:
                take_block += block[x][y] - height
            else:
                use_block += height - block[x][y]

    if use_block > take_block + b:
        continue

    count = take_block * 2 + use_block

    if count <= answer:
        answer = count
        level = height

print(answer, level)
