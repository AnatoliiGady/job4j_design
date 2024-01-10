package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public boolean getJeep() {
        return jeep;
    }

    public int getReleased() {
        return released;
    }

    public String getModel() {
        return model;
    }

    public Number getNumber() {
        return number;
    }

    public String[] getStatuses() {
        return statuses;
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

    public static void main(String[] args) {
        JSONObject jsonNumber = new JSONObject("{\"number\":\"С570ЕР\"}");
        List<String> list = new ArrayList<>();
        list.add("engine capacity 5");
        list.add("wheel size 20");
        JSONArray jsonStatuses = new JSONArray(list);
        Car car = new Car(true, 2023, "Lexus", new Number("C292KM"),
                new String[]{"engine capacity 4,7", "wheel size 18"});
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("jeep", car.getJeep());
        jsonObject.put("released", car.getReleased());
        jsonObject.put("model", car.getModel());
        jsonObject.put("number", jsonNumber);
        jsonObject.put("statuses", jsonStatuses);
        System.out.println(jsonObject);
        System.out.println(new JSONObject(car));
    }
}
