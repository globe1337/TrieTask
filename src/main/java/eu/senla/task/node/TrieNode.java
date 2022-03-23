package eu.senla.task.node;

import java.util.Map;
import java.util.TreeMap;

public class TrieNode {
    private Map<Character, TrieNode> children = new TreeMap<>();
    private Integer count = 0;

    public void increment() {
        count++;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Map<Character, TrieNode> getChildren() {
        return children;
    }

    public void setChildren(Map<Character, TrieNode> children) {
        this.children = children;
    }
}
