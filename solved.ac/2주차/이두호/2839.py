# https://www.acmicpc.net/problem/2839
"""
[문제]
N 킬로그램 설탕을 3kg 봉지와 5kg 봉지로 나누는데, 최대한 적은 봉지를 구하시오.

[문제 유형]
그리디

[풀이 과정]
1. 5로 나누어 떨어지면 5kg 봉지를 이용
2. 나누어 떨어지지 않으면 3kg 봉지를 이용
3. 설탕이 남거나 부족하면, -1 출력
4. 설탕이 남지 않으면 전체 봉지 수 출력
"""
import sys

n = int(sys.stdin.readline().rstrip())
result = 0

while n > 0:
    if n % 5 == 0:
        result += n // 5
        n = 0
        break

    result += 1
    n -= 3

print(-1 if n else result)
