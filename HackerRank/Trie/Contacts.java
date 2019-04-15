/*
https://www.hackerrank.com/challenges/contacts/problem
*/

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

 class TrieNode {
    public Map<Character, TrieNode> children = new HashMap<>();
    public int size = 0;

    public void putChildrenIfAbsent(Character ch) {
        children.putIfAbsent(ch, new TrieNode());
    }

    public TrieNode getChild(Character ch) {
        return children.get(ch);
    }

    @Override
    public String toString() {
        return "TrieNode [children=" + children + ", size=" + size + "]";
    }

}

class Trie {

    public TrieNode root = new TrieNode();

    Trie() {

    }

    Trie(String[] words) {
        for (String word : words) {
            add(word);
        }
    }

    public void add(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            Character ch = word.charAt(i);
            curr.putChildrenIfAbsent(ch);
            curr = curr.getChild(ch);
            curr.size++;
        }
    }

    public int find(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            Character ch = word.charAt(i);
            curr = curr.getChild(ch);
            if (curr == null) {
                return 0;
            }
        }
        return curr.size;
    }

}

public class Solution {

   

   

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

       
        int n = sc.nextInt();sc.nextLine();
        Trie trie = new Trie();
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");
            if (input[0].equals("add")) {
                trie.add(input[1]);
            }
            if (input[0].equals("find")) {
                bufferedWriter.write(String.valueOf(trie.find(input[1])));
                bufferedWriter.write("\n");
                //System.out.println(trie.find(input[1]));
            }
        }

       
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
