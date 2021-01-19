public class Pen implements Cloneable {
    private int inkAmount;
    private int inkCapacity;


    public Pen(int inkCapacity) {
        this.inkCapacity = inkCapacity;
        this.inkAmount = inkCapacity;
    }

    public Pen() {
        this(4096);
    }

    public int getInkAmount() {
        return inkAmount;
    }

    public int getInkCapacity() {
        return inkCapacity;
    }

    public int symbolQty(String message) {
        int symbols = message.length();
        int whiteSpaseCounter = 0;
        for ( char element : message.toCharArray()) {
            if ( element == ' ' || element == '\n') {
                whiteSpaseCounter += 1;
            }
        }
        symbols -= whiteSpaseCounter;
        return symbols;
    }

    int cutIndex(String message, int inkAmount) {
        int index = 0;
        int counter = 0;
        for ( char element : message.toCharArray()) {
            if ( element != ' ' && element != '\n') {
                counter += 1;
            }
        }
        return index;
    }

    public void write(Paper paper, String message) throws OutOfInkException, OutOfSpaceException  {
        if ( inkAmount == 0 ) {
            throw new OutOfInkException();
        }

        int symbols = symbolQty(message);

        if ( inkAmount >= symbols ) {
            paper.addContent(message);
            inkAmount -= symbols;
        } else {
            paper.addContent(message.substring(0, cutIndex(message, inkAmount)));
            inkAmount = 0;
            throw new OutOfInkException();
        }
    }

    public void refill() {
        inkAmount = inkCapacity;
    }
}