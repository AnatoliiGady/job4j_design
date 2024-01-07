package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Anatolii Gadi";
        byte age = 33;
        double weight = 90.3;
        float height = 1.76f;
        int salary = 150000;
        char beginsName = 'A';
        boolean isProgrammer = true;
        long exerciseNumber = 15345674867L;
        short dayTraining = 531;
        LOG.debug("User info name : {}, age : {}, weight : {}, height : {}, salary : {}, beginsName : {}, isProgrammer : {}",
                name, age, weight, height, salary, beginsName, isProgrammer);
        LOG.debug("training information : dayTraining : {}, exerciseNumber : {}", dayTraining, exerciseNumber);
    }
}
