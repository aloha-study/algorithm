"""
index: 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
value: 1, 1, 1, 2, 2, 3, 4, 5, 7, 9

array[0] + array[1] = array[3]
array[1] + array[2] = array[4]
array[2] + array[3] = array[5]

"""
import sys

t = int(sys.stdin.readline().rstrip())
array = [0] * 100

array[0] = 1
array[1] = 1
array[2] = 1

for i in range(3, 100):
    array[i] = array[i - 3] + array[i - 2]

for _ in range(t):
    n = int(sys.stdin.readline().rstrip())
    print(array[n - 1])
