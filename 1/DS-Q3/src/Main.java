import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt() , m = sc.nextInt();
        Node [] nodes = new Node[n];
        for(int i = 0;i < n;i++)
        {
            nodes[i] = new Node(i);
        }
        for(int k = 0;k < m;k++)
        {
            int i = sc.nextInt() - 1,j = sc.nextInt() - 1;
            Node current = nodes[j];
            if(current==null)
            {
                nodes[j] = nodes[i];
                nodes[i] = null;
                continue;
            }
            while(current.next != null)
            {
                current = current.next;
            }
            current.next = nodes[i];
            nodes[i] = null;
        }
        int d = sc.nextInt() - 1;
        Node current = nodes[d];
        int count = 0;
        while(current != null)
        {
            count++;
            current = current.next;
        }
        System.out.print(count+ " ");
        current = nodes[d];
        while(current != null){
            System.out.print((current.integer+1) + " ");
            current = current.next;
        }

    }
}

class Node{
    Integer integer;
    Node next;

    public Node(Integer integer) {
        this.integer = integer;
        next = null;
    }
}
