public class InvalidDate extends Exception {
    final private String text;

    public InvalidDate(String text) {
        this.text = text;
    }

    public String toString() {
        return text;
    }
}
