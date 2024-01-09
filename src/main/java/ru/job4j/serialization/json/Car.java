package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class Car {
    private final boolean jeep;
    private final int released;
    private final String model;
    private final Number number;
    private final String[] statuses;

    public Car(boolean jeep, int released, String model, Number number, String[] statuses) {
        this.jeep = jeep;
        this.released = released;
        this.model = model;
        this.number = number;
        this.statuses = statuses;
    }

    public static void main(String[] args) {
        Car car = new Car(true, 2023, "Lexus", new Number("C292KM"),
                new String[]{"engine capacity 4,7", "wheel size 18"});
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(car));

        final String carJson =
                "{"
                        + "\"jeep\":true,"
                        + "\"released\":2023,"
                        + "\"model\":Lexus,"
                        + "\"number\":"
                        + "{"
                        + "\"number\":\"C292KM\""
                        + "},"
                        + "\"statuses\":"
                        + "[\"engine capacity 4,7\",\"wheel size 18\"]"
                        + "}";

        final Car carMod = gson.fromJson(carJson, Car.class);
        System.out.println(carMod);
    }
    @Override
    public String toString() {
        return "Car{"
                + "jeep=" + jeep
                + ", released=" + released
                + ", model='" + model + '\''
                + ", number=" + number
                + ", statuses=" + Arrays.toString(statuses)
                + '}';
    }
}
