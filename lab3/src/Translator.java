import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Translator {
    private static final Logger logger = Logger.getLogger(Translator.class.getName());
    private final Map<String, String> dict;

    public Translator(String path) {
        this.dict = this.loadDict(path);
    }

    public void translate(String path) {
        try (FileInputStream in = new FileInputStream(path)) {
            Scanner scanner = new Scanner(in);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().toLowerCase();
                for (String key : this.dict.keySet()) {
                    Pattern replaceWordPattern = Pattern.compile("\\b" + key + "\\b");
                    line = line.replaceAll(String.valueOf(replaceWordPattern), this.dict.get(key));
                }
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            logger.log(Level.WARNING, "File not found for path: " + path);
            throw new RuntimeException();
        } catch (IOException e) {
            logger.log(Level.WARNING, "IO exception while reading translating file");
            throw new RuntimeException();
        }
    }

    private Map<String, String> loadDict(String path) {
        Map<String, String> local_dict = new LinkedHashMap<String, String>();
        try (FileInputStream in = new FileInputStream(path)) {
            Scanner scanner = new Scanner(in);

            while (scanner.hasNext()) {
                List<String> tokens = List.of(scanner.nextLine().split("\\|", 2));
                tokens = tokens.stream().map(String::trim).map(String::toLowerCase).collect(Collectors.toList());

                String key = tokens.get(0);
                String value = tokens.get(1);
                if (local_dict.containsKey(key)) {
                    if (local_dict.get(key).length() > value.length()) {
                        value = local_dict.get(key);
                    }
                }
                local_dict.put(key, value);
            }
        } catch (FileNotFoundException e) {
            logger.log(Level.WARNING, "File not found for path: " + path);
            throw new RuntimeException();
        } catch (IOException e) {
            logger.log(Level.WARNING, "IO exception while reading dict");
            throw new RuntimeException();
        }
        return local_dict;
    }

}
