import java.util.*;
import java.io.*;
import java.math.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        String o = st.nextToken();
        String l = st.nextToken();
        String r = st.nextToken();
        Node hl = l.equals(".") ? null : new Node(l, null, null);
        Node hr = r.equals(".") ? null : new Node(r, null, null);
        Node root = new Node(o,hl,hr);
        
        for(int i = 1; i<n;i++){
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            String c = st.nextToken();
            Node ln = b.equals(".") ? null : new Node(b, null, null);
            Node rn = c.equals(".") ? null : new Node(c, null, null);
            insert(root, new Node(a, ln, rn));
        }
        preorder(root);
        System.out.print("\n");
        inorder(root);
        System.out.print("\n");
        postorder(root);
    }
    
    private static void insert(Node root, Node insertnode){
        if(root == null) return;
        if(root.val.equals(insertnode.val)){
            root.left = insertnode.left;
            root.right = insertnode.right;
            return;
        }
        insert(root.left, insertnode);
        insert(root.right, insertnode);
    }

    private static void preorder(Node root){
        if(root == null) return;
        System.out.print(root.val);
        preorder(root.left);
        preorder(root.right);
    }

    private static void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.val);
        inorder(root.right);
    }

    private static void postorder(Node root){
        if(root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val);
    }
}

class Node{
    public Node(String val, Node left, Node right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
    Node left;
    Node right;
    String val;
}

