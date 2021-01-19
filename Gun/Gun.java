public class Gun implements Cloneable {
    private int amount;
    private int capacity;
    private boolean isReady;
    private String model;
    private int totalShots;

    public Gun(String model, int capacity) {
        this.amount = 0;
        this.capacity = capacity;
        this.isReady = false;
        this.model = model;
        this.totalShots = 0;
    }

    public Gun() {
        this("Beretta", 8);
    }

    public int getAmount() {
        return amount;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean ready() {
        return isReady;
    }

    public String getModel() {
        return model;
    }

    public int getTotalShots() {
        return totalShots;
    }

    public void prepare() {
        isReady = !isReady;
    }

    public void reload() {
        amount = capacity;
    }

    public void shoot() throws NotReady, OutOfRounds {
        if ( !ready() ) {
            throw new NotReady();
        }
        if ( amount == 0 ) {
            throw new OutOfRounds();
        }
        System.out.println(getModel() + ": Bang!");
        amount -= 1;
        totalShots += 1;
    }

    public void show() {
        System.out.println("============");
        System.out.println("Model: '" + getModel() + "'");
        System.out.println("\tCapacity: " + getCapacity());
        System.out.println("\tAmount: " + getAmount() + "/" + getCapacity());
        System.out.println("Total shots: " + getTotalShots());
        if ( ready() ) {
            System.out.println("Ready to shoting.");
        } else {
            System.out.println("Not ready to shoting.");
        }
        System.out.println("============");
    }
}