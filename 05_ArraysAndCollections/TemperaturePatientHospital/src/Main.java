import java.util.Locale;

public class Main {

  public static void main(String[] args) {
    final int COUNTS_PATIENT = 30;
    final float MINIMUM_TEMPERATURE = 32;
    final float MAXIMUM_TEMPERATURE = 40;
    final float MINIMUM_TEMPERATURE_HEALTHY = 36.2f;
    final float MAXIMUM_TEMPERATURE_HEALTHY = 36.9f;
    int healthyPatient = 0;
    float sumTemperaturePatient = 0;
    float[] temperaturePatient = new float[COUNTS_PATIENT];
    for (int i = 0; i < temperaturePatient.length; i++) {
      temperaturePatient[i] =
          MINIMUM_TEMPERATURE + (float) ((MAXIMUM_TEMPERATURE - MINIMUM_TEMPERATURE) * Math
              .random());
      sumTemperaturePatient += temperaturePatient[i];
      if (temperaturePatient[i] > MINIMUM_TEMPERATURE_HEALTHY
          && temperaturePatient[i] < MAXIMUM_TEMPERATURE_HEALTHY) {
        healthyPatient++;
      }
    }
    System.out.print("Температуры пациентов: ");
    for (float patientTemperature : temperaturePatient) {
      System.out.printf(Locale.ENGLISH, "%.1f, ", patientTemperature);
    }
    System.out.printf(Locale.ENGLISH, "\nСредняя температура: %.2f",
        sumTemperaturePatient / COUNTS_PATIENT);
    System.out.println("\nКоличество здоровых: " + healthyPatient);
  }
}
