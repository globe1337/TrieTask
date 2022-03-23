package eu.senla.task.producer;

import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileWordProducer implements WordProducer {
    private static final String WORD_REGEXP = "\\s*(\\s|,|!|\\.)\\s*";

    private final String path;

    public FileWordProducer(String path) {
        this.path = path;
    }

    @SneakyThrows
    @Override
    public List<String> readWords() {
        return Files.readAllLines(Paths.get(path))
                .stream()
                .flatMap(s -> Stream.of(s.split(WORD_REGEXP)))
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());
    }
}
