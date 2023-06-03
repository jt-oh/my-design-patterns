class Adaptor {
    public static void main(String[] args) {
        HighTemperatureAlarmInterface alarm = new HighTemperatureAlarmInFahrenheit();
        float temperatureInFahrenheit;
        boolean isHighTemperature;

        temperatureInFahrenheit = 211f;
        isHighTemperature = alarm.check(temperatureInFahrenheit);
        System.out.println(temperatureInFahrenheit + " F is " + (isHighTemperature ? "High" : "Normal") + " temperature!");

        temperatureInFahrenheit = 213f;
        isHighTemperature = alarm.check(temperatureInFahrenheit);
        System.out.println(temperatureInFahrenheit + " F is " + (isHighTemperature ? "High" : "Normal") + " temperature!");
    }
}

// Adaptor Interface
interface HighTemperatureAlarmInterface {
    public boolean check(float $temperature);
}

// Concrete Adaaptor
class HighTemperatureAlarmInFahrenheit implements HighTemperatureAlarmInterface {
    // Adaptee
    private HighTemperatureAlarmInCelsius highTemperatureAlarmAdaptee;

    public HighTemperatureAlarmInFahrenheit() {
        highTemperatureAlarmAdaptee = new HighTemperatureAlarmInCelsius();
    }

    // Adapter Interface
    @java.lang.Override
    public boolean check(float temperatureInFahrenheit) {
        float temperatureInCelsius = convertToCelsius(temperatureInFahrenheit);

        return highTemperatureAlarmAdaptee.checkInCelsius(temperatureInCelsius);
    }

    private float convertToCelsius(float temperatureInFahrenheit) {
        return (temperatureInFahrenheit - 32) * 5 / 9;
    }
}

// Adaptee
class HighTemperatureAlarmInCelsius {
    private static final float NORMAL_TEMPERATURE_CEIL = 100f;

    public boolean checkInCelsius(float temperature) {
        return temperature >= NORMAL_TEMPERATURE_CEIL;
    }
}