public class _5 {
}

class WordDictionary {

    int size = 26;

    class TrieNode {
        boolean isEndOfWord;
        TrieNode[] children = new TrieNode[size];

        public TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < size; i++) {
                children[i] = null;
            }
        }
    }

    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new TrieNode();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        int level;
        int length = word.length();
        int index;
        TrieNode runner = root;
        for (level = 0; level < length; level++) {
            index = word.charAt(level) - 'a';
            if (runner.children[index] == null) {
                runner.children[index] = new TrieNode();
            }
            runner = runner.children[index];
        }
        runner.isEndOfWord = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        int level = 0;
        int length = word.length();
        int index = 0;
        TrieNode runner = root;
        return search(word, level, length, index, runner);
    }

    private boolean search(String word, int level, int length, int index, TrieNode runner) {
        if (level >= length) return runner != null && runner.isEndOfWord;
        if (runner == null) return false;
        char ch = word.charAt(level);
        if (ch == '.') {
            boolean future = false;
            for (int i = 0; i < size; i++) {
                future = future || search(word, level + 1, length, index, runner.children[i]);
                if (future) return true;
            }
            return false;
        } else {
            index = word.charAt(level) - 'a';
            if (runner.children[index] == null) return false;
            runner = runner.children[index];
            return search(word, level + 1, length, index, runner);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
