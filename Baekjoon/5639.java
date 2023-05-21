import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        node root = new node(Integer.parseInt(br.readLine()), null, null);
        String tmp;
        while((tmp = br.readLine()) != null){
            insert(root, Integer.parseInt(tmp));
        }
        postorderT(root);
    }

    private static void postorderT (node root) throws IOException {
        if(root == null) return;
        postorderT(root.left);
        postorderT(root.right);
        System.out.println(root.val);
    }

    private static void insert (node root, int val){
        if(root.val <= val) {
            if(root.right == null) root.right = new node(val, null, null);
            else insert(root.right, val);
        } 
        else {
            if(root.left == null) root.left = new node(val, null, null);
            else insert(root.left, val);
        }
    }
}

class node{
    int val;
    node left;
    node right;
    node(int val, node left, node right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
