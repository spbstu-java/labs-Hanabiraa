public class SimpleClass {
    @RepeatedAnnotation(repeatNum = 2)
    final public String publicMethod1() {
        return "public method 1";
    }

    public String publicMethod2() {
        return "public method 2";
    }

    @RepeatedAnnotation(repeatNum = 2)
    protected String protectedMethod1() {
        return "protected method 1";
    }

    protected String protectedMethod2() {
        return "protected method 2";
    }

    @RepeatedAnnotation(repeatNum = 2)
    private String privateMethod1() {
        return "private method 1";
    }

    private String privateMethod2() {
        return "private method 2";
    }
}
