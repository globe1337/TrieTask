package eu.senla.task.producer;

import java.io.IOException;
import java.util.List;

public interface WordProducer {
    List<String> readWords() throws IOException;
}
