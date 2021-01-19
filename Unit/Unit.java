public class Unit implements Cloneable {
    private int damage;
    private int hitPoints;
    private int hitPointsLimit;
    private String name;

    private void ensureIsAlive() throws UnitIsDead {
        if ( hitPoints == 0 ) {
            throw new UnitIsDead();
        }
    }

    public Unit(String name, int hp, int dmg) {
        this.name = name;
        this.hitPointsLimit = hp;
        this.damage = dmg;
        this.hitPoints = hitPointsLimit;
    }

    public int getDamage() {
        return damage;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getHitPointsLimit() {
        return hitPointsLimit;
    }

    public String getName() {
        return name;
    }

    public void addHitPoints(int hp) throws UnitIsDead {
        ensureIsAlive();
        hitPoints += hp;
        if ( hitPoints > hitPointsLimit ) {
            hitPoints = hitPointsLimit;
        }
        System.out.println(String.format("%s: HP is restored (%d/%d)", name, hitPoints, hitPointsLimit));
    }

    public void takeDamage(int dmg) throws UnitIsDead{
        ensureIsAlive();
        if ( dmg >= hitPoints ) {
            hitPoints = 0;
            System.out.println(String.format("%s is dead", name));
        } else {
            hitPoints -= dmg;
            System.out.println(String.format("%s -%dHP", name, dmg));
        }
    }

    public void attack(Unit enemy) throws UnitIsDead{
        System.out.println(String.format("%s attacked %s", name, enemy.name));
        enemy.takeDamage(damage);
        if ( enemy.hitPoints > 0 ) {
            counterAttack(enemy);
        }
    }

    public void counterAttack(Unit enemy) throws UnitIsDead{
        System.out.println(String.format("%s counter attacked", enemy.name));
        takeDamage(enemy.damage / 2);
    }

    public void show() {
        System.out.println("-----------");
        System.out.println("Name: " + getName());
        System.out.println(String.format("\tHP: %d/%d", hitPoints, hitPointsLimit));
        System.out.println("\tDamege: " + damage);
        System.out.println("-----------");
    }

    public Unit clone() throws CloneNotSupportedException {
        return (Unit) super.clone();
    }
}