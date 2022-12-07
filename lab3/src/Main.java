import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        String DICT_PATH = "src/dict.txt";
        String FILE_TO_TRANSLATE_PATH = "src/example_text.txt";

        Translator translator = new Translator(DICT_PATH);
        translator.translate(FILE_TO_TRANSLATE_PATH);
    }
}