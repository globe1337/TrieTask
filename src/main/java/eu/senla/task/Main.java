package eu.senla.task;

import eu.senla.task.builder.TrieBuilder;
import eu.senla.task.manager.TrieOperationManager;
import eu.senla.task.node.Trie;
import eu.senla.task.printer.ConsolePrintService;
import eu.senla.task.printer.PrintService;
import eu.senla.task.producer.FileWordProducer;

public class Main {

    public static void main(String[] args) {
        PrintService printer = new ConsolePrintService();
        FileWordProducer fileReaderService = new FileWordProducer(args[0]);
        TrieBuilder trieBuilder = new TrieBuilder();
        Trie trie = trieBuilder.build(fileReaderService);
        TrieOperationManager operationManager = new TrieOperationManager(printer);
        printer.println(trie.getCount());
        operationManager.printTrie(trie.getRoot());
    }
}
