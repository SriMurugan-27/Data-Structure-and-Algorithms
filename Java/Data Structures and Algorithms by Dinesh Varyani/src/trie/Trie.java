package trie;

public class Trie {

    private TrieNode root;
    public class TrieNode{
        private TrieNode[] children;
        private boolean isWord;

        public TrieNode(){
            this.children = new TrieNode[26];
            this.isWord = false;
        }
    }

    public Trie(){
        this.root = new TrieNode();
    }

    public void insert(String word){
        TrieNode current = root;
        int n = word.length();

        for(int i = 0; i < n; i++){
            char c = word.charAt(i);
            int index = c - 'a';

            if(current.children[index] == null){
                TrieNode newNode = new TrieNode();
                current.children[index] = newNode;
                current = newNode;
            }else{
                current = current.children[index];
            }
        }

        current.isWord = true;
    }

    public boolean search(String word){
        TrieNode current = root;
        int n = word.length();

        for(int i = 0; i < n; i++){
            char c = word.charAt(i);
            int index = c - 'a';

            if(current.children[index] == null){
                return false;
            }

            current = current.children[index];
        }

        return true;
    }

    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("dog");
        t.insert("cat");
        t.insert("sun");
        t.insert("son");
        t.insert("their");
        t.insert("there");

        System.out.println(t.search("dad"));
        System.out.println(t.search("son"));
        System.out.println(t.search("mike"));
        System.out.println(t.search("their"));
        System.out.println(t.search("there"));
    }
}
