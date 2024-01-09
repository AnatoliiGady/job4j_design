package ru.job4j.io.serialization.xml;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class Car {
    @XmlAttribute
    private boolean jeep;
    @XmlAttribute
    private int released;
    @XmlAttribute
    private String model;
    private Number number;
    @XmlElementWrapper(name = "statuses")
    @XmlElement(name = "status")
    private String[] statuses;

    public Car() {
    }

    public Car(boolean jeep, int released, String model, Number number, String... statuses) {
        this.jeep = jeep;
        this.released = released;
        this.model = model;
        this.number = number;
        this.statuses = statuses;
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

    public static void main(String[] args) throws Exception {
        Car car = new Car(true, 2023, "Lexus", new Number("C292KM"),
                "engine capacity 4,7", "wheel size 18");
        JAXBContext context = JAXBContext.newInstance(Car.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(car, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            Car result = (Car) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }
}
