"""
R: 뒤집기
D: 첫 번째 수 버리기 -> 배열이 비어있는 경우 에러 발생
"RDD" -> 뒤집고 버리고 버리기
최종 결과를 구하는 프로그램 작성

1 <= t <= 10 ** 2
1 <= p <= 10 ** 6
1 <= n <= 10 ** 6

R이 몇 번 나왔는지 계산
D보다 주어진 배열이 크기가 큰 겅우 -> error
D보다 작은 경우 pop
D가 없는 경우 R에 따라 출력

D == 0     -> 그대로 출력
0 < D < n  -> R이면 뒤집기 / R이 아닌 경우 방향에 따라 drop
D > n      -> error

"""
import sys
import ast
from collections import deque

t = int(sys.stdin.readline().rstrip())

for _ in range(t):
    commands = list(sys.stdin.readline().rstrip())
    n = int(sys.stdin.readline().rstrip())
    numbers = deque(list(ast.literal_eval(sys.stdin.readline().rstrip())))
    is_reversed = False

    if commands.count('D') > n:
        print('error')
        continue

    for command in commands:
        if command == 'R':
            is_reversed = not is_reversed
        else:
            if is_reversed:
                numbers.pop()
            else:
                numbers.popleft()

    if is_reversed:
        print(str(list(numbers)[::-1]).replace(" ", ""))
    else:
        print(str(list(numbers)).replace(" ", ""))
