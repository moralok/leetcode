package string.implement_trie_prefix_tree;

public class Trie {

    private final Trie[] children;
    private boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie trie = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int idx = ch - 'a';
            if (trie.children[idx] == null) {
                trie.children[idx] = new Trie();
            }
            trie = trie.children[idx];
        }
        trie.isEnd = true;
    }

    public boolean search(String word) {
        Trie trie = searchPrefix(word);
        return trie != null && trie.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private Trie searchPrefix(String prefix) {
        Trie trie = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int idx = ch - 'a';
            if (trie.children[idx] == null) {
                return null;
            }
            trie = trie.children[idx];
        }
        return trie;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        assert trie.search("apple");
        assert !trie.search("app");
        assert trie.startsWith("app");
        trie.insert("app");
        assert trie.search("app");
    }
}
