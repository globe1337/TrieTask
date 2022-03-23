package eu.senla.task.node;

public class Trie {
    private TrieNode root = new TrieNode();

    public void put(String s) {
        TrieNode node = root;
        for (char ch : s.toLowerCase().toCharArray()) {
            if (!node.getChildren().containsKey(ch)) {
                node.getChildren().put(ch, new TrieNode());
            }
            node = node.getChildren().get(ch);
        }
        node.increment();
    }

    public TrieNode getRoot() {
        return root;
    }

    public Integer getCount() {
        return findTerminalElementEntryCount(root);
    }

    private Integer findTerminalElementEntryCount(TrieNode node) {
        int count = 0;
        for (Character ch : node.getChildren().keySet()) {
            count += findTerminalElementEntryCount(node.getChildren().get(ch));
        }
        if (node.getCount() != 0) {
            count += node.getCount();
        }
        return count;
    }
}
