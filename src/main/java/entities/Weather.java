package entities;

import java.time.LocalDateTime;

public class Weather {
    private double value;
    private String raining;
    private LocalDateTime createdAt;
    private Sensor sensor;

    public Weather() {
    }

    public Weather(double value, String raining, LocalDateTime createdAt, Sensor sensor) {
        this.value = value;
        this.raining = raining;
        this.createdAt = createdAt;
        this.sensor = sensor;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getRaining() {
        return raining;
    }

    public void setRaining(String raining) {
        this.raining = raining;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
