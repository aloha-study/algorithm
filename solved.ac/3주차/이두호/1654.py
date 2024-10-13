# https://www.acmicpc.net/problem/1654
"""
[문제]
박
- N개의 랜선 필요
오
- K개의 랜선 보유
- K개의 랜선 길이 제각각
조건
- 랜선을 자르고 남은 랜선은 버려야 함
- 모두 N개의 같은 길이의 랜선으로 만들고 싶음
- 기존 K개의 랜선으로 N개의 랜선을 만들 수 없는 경우 없음
- 정수 단위 만큼 자름
- N개보다 많이 만드는 경우도 N개를 만드는 것에 포함

Q: 최대 랜선의 길이는?

[문제 유형]
이진 탐색

[풀이 과정]
============
==========
========
=====

1) 탐색을 최대한 줄이기 위해 가장 작은 길이를 기준으로 지정
2) left, right의 중간(mid)으로 나눌 수 있는지 확인
3) 개수가 충분한 경우 left 기준을 mid로 지정 후 다음 진행 (why? 최대 길이를 찾아야 하기 때문)
4) 개수가 부족한 경우 right 기준을 mid로 지정 후 다음 진행
5) left == right 인 경우 출력

457 / 2 = 228
228 / 2 = 114

114로 나누는 경우 가능
171로 나누는 경우 가능
199로 나누는 경우 가능
213로 나누는 경우 불가능
205로 나누는 경우 불가능
202로 나누는 경우 불가능
200으로 나누는 경우 가능
201로 나누는 경우 불가능

200 = 200 종료


[예시]
300cm -> 140cm / 2개 / 20cm 버림

4 11
802  200 * 4 / 201 * 4 = 804
743  200 * 3 / 201 * 3 = 603
457  200 * 2 / 201 * 2 = 402
539  200 * 2 / 201 * 2  = 402

4+3+2+2 = 11

[테스트 케이스]
1 2
50
--
25

1 3
100
--
33

4 11
802
743
457
539
--
200

5 5
1
2
3
4
5
--
2

1 2
1
--
0

1 1
10
--
10

2 1
10
1
--
10
"""
import sys


def binary_search(numbers, n):
    left = 1
    right = sorted(numbers)[-1]
    
    while left <= right:
        mid = int((left + right) / 2)
        total = sum([value // mid for value in numbers])

        if total >= n:
            left = mid + 1
        else:
            right = mid - 1

    return right



k, n = map(int, sys.stdin.readline().rstrip().split())
numbers = []
for _ in range(k):
    numbers.append(int(sys.stdin.readline().rstrip()))


print(binary_search(numbers, n))
