package eu.senla.task.printer;

public class ConsolePrintService implements PrintService {
    @Override
    public void println(String text) {
        System.out.println(text);
    }

    @Override
    public void println(Integer number) {
        System.out.println(number);
    }

    @Override
    public void println() {
        System.out.println();
    }
}
