import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node [] nodes = new Node[n];
        for(int i = 0;i < n;i++)
        {
            nodes[i] = new Node();
        }
        for(int i = 0;i < n;i++)
        {
            Node node = nodes[sc.nextInt()-1];
            int tmp = sc.nextInt();
            Node left = null;
            Node right = null;
            if(tmp != -1)
                left = nodes[tmp-1];
            tmp = sc.nextInt();
            if(tmp != -1)
                right = nodes[tmp-1];
            node.rightChild = right;
            node.leftChild = left;
            if(left != null) left.parent = node;
            if(right != null) right.parent = node;
        }
        Node root = null;
        for(int i = 0;i < n;i++)
        {
            if(nodes[i].parent == null) {
                root = nodes[i];
                break;
            }
        }
        root.walk();
        for(Node node : nodes)
        {
            System.out.print(node.value + " ");
        }
    }
}

class Node{
    Integer value;
    Node leftChild;
    Node rightChild;
    Node parent;
    static int v = 0;
    public void walk()
    {
        if(leftChild != null)
            leftChild.walk();
        v++;
        value = v;
        if(rightChild != null)
            rightChild.walk();
    }
}
