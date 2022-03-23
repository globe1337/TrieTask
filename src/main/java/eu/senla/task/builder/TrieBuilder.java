package eu.senla.task.builder;

import eu.senla.task.node.Trie;
import eu.senla.task.producer.WordProducer;
import lombok.SneakyThrows;

import java.util.List;

public class TrieBuilder {
    public TrieBuilder() {
    }

    @SneakyThrows
    public Trie build(WordProducer wordProducer) {
        Trie trie = new Trie();
        List<String> stringList = wordProducer.readWords();
        stringList.forEach(trie::put);
        return trie;
    }
}
