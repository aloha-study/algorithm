import sys

n = int(sys.stdin.readline().rstrip())
numbers = []
i = 0

while len(numbers) < 10000:
    i += 1
    if "666" in str(i):
        numbers.append(i)

print(numbers[n - 1])
