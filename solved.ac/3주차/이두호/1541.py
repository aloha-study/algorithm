# https://www.acmicpc.net/problem/1541
"""
[문제]
주어진 수식의 최소값
수식은 +, -로만 구성

1) 숫자는 0으로 시작할 수 있다
2) 가장 처음과 마지막은 숫자이다
3) 연속해서 두 개 이상의 연산자가 나타나지 않는다.

[문제 유형]
수학

[풀이 과정]
1) 최소가 되기 위해선 - 이후의 수식은 덧셈
2) +의 수식을 전부 진행항혀 값으로 만들기
3) 0번째는 + 일 수 밖에 없으므로 1번째 이후 숫자 더하여 뺼셈

[예시]
10 - 20 + 30 - 50
= 10 - 50 - 50
= -90

테스트 케이스
1) 0-0
2) 01-02
3) 009+008
"""
import sys

numbers = []

for expression in sys.stdin.readline().rstrip().split("-"):
    result = 0
    for value in expression.split("+"):
        result += int(value)
    numbers.append(result)

print(numbers[0] - sum(numbers[1:]))
