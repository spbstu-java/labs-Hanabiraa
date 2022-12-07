public class Main {
    public static void main(String[] args) {
        SquareMatrix m = new SquareMatrix();
        m.readMatrixFromFile("src/in.txt");
        m.writeMatrixToFile("src/out.txt", false);
        m.rotateBack90();
        m.divideAround();
        m.writeMatrixToFile("src/out.txt", true);
        m.rotateBack180();
        m.divideAround();
        m.writeMatrixToFile("src/out.txt", true);
        m.rotateBack270();
        m.divideAround();
        m.writeMatrixToFile("src/out.txt", true);
    }
}