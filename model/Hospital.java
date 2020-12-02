package model;

/**
 * @author Sasha Shikovets
 * @version 1.0
 */

import controller.Runner;
import exceptions.DoctorNotEmptyException;

import java.util.concurrent.Semaphore;

/**
 * Class which describes hospital
 */
public class Hospital
{
    /**
     * Hospital
     */
    Doctor[] doctors;

    /**
     * Semaphore which is used to control man
     */
    Semaphore semaphore;

    /**
     * Constructor
     * @param size amount of doctors
     */
    public Hospital(int size)
    {
        doctors = new Doctor[size];
        for(int i = 0; i < size; i++){
            doctors[i] = new Doctor();
        }
        semaphore = new Semaphore(size);
    }

    /**
     * man comes to doctor
     * @param name man to doctor
     * @param index which doctor
     */
    public synchronized void enterMan(String name, int index) throws DoctorNotEmptyException {
        if(doctors[index].getCounter() == 1)
            throw new DoctorNotEmptyException(name);
        while (doctors[index].getCounter() >= 1) {
            try {
                wait();
            }catch (InterruptedException e) {}
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        doctors[index].setCounter(1);
        Runner.logger.info("Пациент " + name + " вошёл");
        notify();
    }

    /**
     * man lives doctor
     * @param name man to doctor
     * @param index which doctor
     */
    public synchronized void exitMan(String name, int index)
    {
        while (doctors[index].getCounter() < 1) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        doctors[index].setCounter(0);
        Runner.logger.info("Пациент " + name + " вышел");
        notify();
    }
}