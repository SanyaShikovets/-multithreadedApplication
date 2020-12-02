package model;

/**
 * @author Sasha Shikovets
 * @version 1.0
 */

/**
 * Class which doctor
 */
public class Doctor
{
    /**
     * name doctor
     */
    private String name;

    /**
     * counter man of doctor
     */
    private int counter = 0;

    /**
     * getter Name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * getter counter
     * @return counter
     */
    public int getCounter() {
        return counter;
    }

    /**
     * setter counter
     * @param counter
     */
    public void setCounter(int counter) {
        this.counter = counter;
    }

    /**
     * Constructor
     */
    public Doctor() {}
}