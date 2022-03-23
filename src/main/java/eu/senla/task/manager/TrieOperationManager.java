package eu.senla.task.manager;

import eu.senla.task.node.TrieNode;
import eu.senla.task.printer.PrintService;

import java.util.HashMap;
import java.util.Map;

public class TrieOperationManager {
    private final PrintService printService;
    private Map<Integer, String> levelSpacesMap = new HashMap<>();

    public TrieOperationManager(PrintService printService) {
        this.printService = printService;
    }

    public void printTrie(TrieNode node) {
        print(node, 0);
    }

    public boolean find(String text, TrieNode trieNode) {
        for (char ch : text.toLowerCase().toCharArray()) {
            if (!trieNode.getChildren().containsKey(ch)) {
                return false;
            } else {
                trieNode = trieNode.getChildren().get(ch);
            }
        }
        return true;
    }

    private void print(TrieNode node, int level) {
        for (Character ch : node.getChildren().keySet()) {
            printService.println(getSpace(level) + ch);
            print(node.getChildren().get(ch), level + 1);
        }
        if (node.getCount() != 0) {
            printService.println();
        }
    }

    private String getSpace(int level) {
        String result = levelSpacesMap.get(level);
        if (result == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < level; i++) {
                sb.append(" ");
            }
            result = sb.toString();
            levelSpacesMap.put(level, result);
        }
        return result;
    }
}
