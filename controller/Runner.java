package controller;

import model.Hospital;
import model.Man;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Sasha Shikovets
 * @version 1.0
 */

public class Runner
{
    /**
     * Logger, used to log information
     */
    public static final Logger logger = LogManager.getLogger();

    public static void main(String[] args)
    {

        int amount_of_doctor = 2;
        int amount_of_man = 3;

        Hospital hospital = new Hospital(amount_of_doctor);
        logger.info("Hospital crated (" + amount_of_doctor + " doctor)");

        Thread[] mens = new Thread[amount_of_man];
        logger.info("Mens created(" + amount_of_man + " man)");

        System.out.println();

        for(int i = 1; i <= amount_of_man; i++) {
            mens[i-1] = new Thread(new Man("Man", hospital));
            logger.info("Man " + i + " created");
        }

        System.out.println();

        for (int i = 1; i <= amount_of_man; i++) {
            mens[i-1].start();
            logger.info("Man " + i + " started");
        }
    }
}