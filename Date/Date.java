public class Date implements Cloneable {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) throws InvalidDate {
        this.day = day;
        this.month = month;
        this.year = year;
        this.validate(day, month, year);
    }

    private void validate(int day, int month, int year) throws InvalidDate {
        if ( year == 0 ) {
            throw new InvalidDate("Invalid year.");
        }
        if ( month < 1 || month > 12 ) {
            throw new InvalidDate("Invalid month.");
        }
        if ( month == 4 || month == 6 || month == 9 || month == 11 ) {
            if ( day > 30 ) {
                throw new InvalidDate("Invalid day.");
            }
        }
        if ( month == 2 ) {
            if ( day > 29 ) {
                throw new InvalidDate("Invalid day.");
            }
            if ( year % 4 != 0 ) {
                if ( day > 28 ) {
                    throw new InvalidDate("Invalid day.");
                }
            }
        }
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void show() {
        System.out.print(String.format("%02d.%02d.", getDay(), getMonth()));
        if ( year < 0 ) {
            System.out.println(String.format("%04d", getYear() * -1) + " B.C.");
        } else {
            System.out.println(String.format("%04d", getYear()));
        }
    }

    public Date clone() throws CloneNotSupportedException {
        return (Date) super.clone();
    }
}