package BOJ._2_Silver;

//[250212] 🔍📌

// 인접리스트 배열로 접근하게 되면, 알파벳 - 숫자 연결때문에 오히려 꽤 복잡함
// 26개수이니, 트리 자체를 구현해서 가는게 나을 듯

import java.util.*;
import java.io.*;

public class _1991_트리_순회 {
    static List<Node>[] list;

    static Node root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        list = new ArrayList[N+1];
        root = null;
        for(int i=0; i<=N; i++){
            list[i] = new ArrayList<>();
        }
        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char data = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            createNode(data,left,right);
        }

        //전위
        preOrder(root);
        System.out.println();
        //중위
        inOrder(root);
        System.out.println();
        //후위
        postOrder(root);
    }
    // 중 - 좌 - 우
    public static void preOrder(Node node){
        System.out.print(node.data);
        if(node.leftNode != null){
            preOrder(node.leftNode);
        }
        if(node.rightNode != null){
            preOrder(node.rightNode);
        }
    }
    // 좌 - 중 - 후
    public static void inOrder(Node node){
        if(node.leftNode != null){
            inOrder(node.leftNode);
        }
        System.out.print(node.data);
        if(node.rightNode != null){
            inOrder(node.rightNode);
        }
    }
    // 좌 - 우 - 중
    public static void postOrder(Node node){
        if(node.leftNode != null){
            postOrder(node.leftNode);
        }
        if(node.rightNode != null){
            postOrder(node.rightNode);
        }
        System.out.print(node.data);
    }
    public static void createNode(char data, char left, char right){
        if(root == null){
            root = new Node(data);
            root.leftNode = left=='.' ? null : new Node(left);
            root.rightNode = right == '.' ? null : new Node(right);
        } else {
            searchData(root, data,left,right);
        }
    }
    public static void searchData(Node node, char data, char left, char right){
        if(node == null){
            return;
        }else if (node.data == data){
            node.leftNode = left=='.' ? null : new Node(left);
            node.rightNode = right == '.' ? null : new Node(right);
        } else{
            searchData(node.leftNode,data,left,right);
            searchData(node.rightNode,data,left,right);
        }
    }
    static class Node{
        char data;
        Node leftNode;
        Node rightNode;
        Node(char data){
            this.data = data;
        }
    }
}
