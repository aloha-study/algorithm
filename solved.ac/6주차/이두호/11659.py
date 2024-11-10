"""
수  N개 / i~j 수의 합

수: (0 < 수 <= 1000)
N: 개수 (1 <= N < = 100,000)
M: 합을 구해야하는 횟수 (1 <= M <= 100,000)
1 <= i <= j <= N

5 3        N/M
5 4 3 2 1  수
1 3        => 12
2 4        => 9
5 5        => 1

12
9
1

# timeout: 10^5 * 10^5 = 10^10
# 누적합을 구한다. sum[j] - sum[i - 1]
"""
import sys

MAX = 100000
n, m = map(int, sys.stdin.readline().rstrip().split())
numbers = [0] * (MAX + 1)

result = 0
input_numbers = list(map(int, sys.stdin.readline().rstrip().split()))
for index, value in enumerate(input_numbers):
    numbers[index + 1] = result + value
    result += value

for _ in range(m):
    i, j = map(int, sys.stdin.readline().rstrip().split())
    print(numbers[j] - numbers[i - 1])
