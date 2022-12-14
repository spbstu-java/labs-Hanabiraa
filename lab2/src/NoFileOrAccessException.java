public class NoFileOrAccessException extends RuntimeException {
    public NoFileOrAccessException(String path) {
        super("файла не существует или доступ к файлу невозможен по такому пути: " + path);
    }
}
