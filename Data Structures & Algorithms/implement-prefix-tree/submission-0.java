class PrefixTree {
    TrieNode root;
    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            if (curr.children[ch-'a'] == null) {
                curr.children[ch-'a'] = new TrieNode();
            }
            curr = curr.children[ch-'a'];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            if (curr.children[ch-'a'] == null) return false;
            curr = curr.children[ch-'a'];
        }
        return curr.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (char ch : prefix.toCharArray()) {
            if (curr.children[ch-'a'] == null) return false;
            curr = curr.children[ch-'a'];
        }

        return true;
    }
}

class TrieNode {
    TrieNode[] children;
    boolean isWord;

    TrieNode() {
        this.children = new TrieNode[26];
        isWord = false;
    }
}