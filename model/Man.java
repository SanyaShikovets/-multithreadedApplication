package model;

/**
 * @author Sasha Shikovets
 * @version 1.0
 */

import controller.Runner;
import exceptions.DoctorNotEmptyException;

/**
 * Class which describes man as thread
 */

public class Man implements Runnable
{
    /**
     * Name
     */
    private static String name;

    /**
     * Index doctor is hospital
     */
    private int doctorIndex;

    /**
     * Hospital
     */
    private Hospital hospital;

    /**
     * getter name
     * @return name
     */
    public static String getName() {
        return name;
    }

    /**
     * getter doctorIndex
     * @return doctorIndex
     */
    public int getDoctorIndex() {
        return doctorIndex;
    }

    /**
     * setter indexDoctor
     * @param index
     */
    void setDoctorIndex(int index) {
        this.doctorIndex = index;
    }

    /**
     * Consstuctor
     * @param name
     * @param hospital
     */
    public Man(String name, Hospital hospital){
        this.name = name;
        this.hospital = hospital;
    }

    /**
     * Thread function
     */
    public void run() {
        try {
            hospital.enterMan(name, doctorIndex);
        } catch (DoctorNotEmptyException e) {
            e.printStackTrace();
        }
        hospital.exitMan(name, doctorIndex);
    }
}