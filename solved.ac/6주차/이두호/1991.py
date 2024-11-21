"""
전위순회 : 루트 -> 왼 -> 오
중위순회 : 왼 -> 루트 -> 오
후위순회 : 왼 -> 오 -> 루트
"""
import sys

n = int(sys.stdin.readline().rstrip())
data = {}
start = 'A'

for _ in range(n):
    root, left, right = sys.stdin.readline().rstrip().split()
    data[root] = (left, right)


def pre_order(root):
    if root == '.':
        return

    print(root, end='')
    pre_order(data[root][0])
    pre_order(data[root][1])


def in_order(root):
    if root == '.':
        return

    in_order(data[root][0])
    print(root, end='')
    in_order(data[root][1])

def post_order(root):
    if root == '.':
        return

    post_order(data[root][0])
    post_order(data[root][1])
    print(root, end='')


pre_order(start)
print()
in_order(start)
print()
post_order(start)
print()
