"""
오름차순으로 된 바이토닉 수열을 찾는다.
왼쪽/오른쪽으로 바이토닉 수열을 찾는다.
i번째인 경우 겹치므로 1을 제거한 후 출력한다.
"""

import sys

n = int(sys.stdin.readline().rstrip())
numbers = list(map(int, sys.stdin.readline().rstrip().split()))


def bitonic(numbers):
    n = len(numbers)
    d = [1] * n

    for i in range(n):
        for j in range(i):
            if numbers[j] < numbers[i]:
                d[i] = max(d[i], d[j] + 1)

    return d


result = 0

left = bitonic(numbers)
right = bitonic(list(reversed(numbers)))

for i in range(n):
    result = max(result, left[i] + right[n - i - 1])
    
print(result - 1)
