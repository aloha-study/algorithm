import java.io.*;
import java.util.*;

/**
 * @Description 트리 순회
 */
public class _1991 {

    static class Node {
        char data;
        Node left, right;

        Node(char data) {
            this.data = data;
        }
    }

    static class Tree {
        public Node root;

        public void addNode(char data, char leftData, char rightData) {
            if (root == null) {
                root = new Node(data);
                root.left = leftData == '.' ? null : new Node(leftData);
                root.right = rightData == '.' ? null : new Node(rightData);
            } else {
                searchNode(root, data, leftData, rightData);
            }
        }

        public void searchNode(Node node, char data, char leftData, char rightData) {
            if (node == null) {
                return;
            } else if (node.data == data) {
                node.left = leftData == '.' ? null : new Node(leftData);
                node.right = rightData == '.' ? null : new Node(rightData);
            } else {
                // 재귀 탐색
                searchNode(node.left, data, leftData, rightData);
                searchNode(node.right, data, leftData, rightData);
            }
        }

        // 전위순회 : Root -> Left -> Right
        public void preOrder(Node node) {
            if (node != null) {
                System.out.print(node.data);
                if (node.left != null) preOrder(node.left);
                if (node.right != null) preOrder(node.right);
            }
        }

        // 중위순회 : Left -> Root -> Right
        public void inOrder(Node node) {
            if (node != null) {
                if (node.left != null) inOrder(node.left);
                System.out.print(node.data);
                if (node.right != null) inOrder(node.right);
            }
        }

        // 후위순회 : Left -> Right -> Root
        public void postOrder(Node node) {
            if(node != null) {
                if (node.left != null) postOrder(node.left);
                if (node.right != null) postOrder(node.right);
                System.out.print(node.data);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 노드 수
        Tree tree = new Tree();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            tree.addNode(root, left, right);
        }

        tree.preOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
        System.out.println();
        tree.postOrder(tree.root);
    }
}
