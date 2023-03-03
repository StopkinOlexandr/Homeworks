package HW32;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class HomeWork_32_1 {
  enum Season {
    WINTER,
    SPRING,
    SUMMER,
    AUTUMN,
  }

  enum Month {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER,
  }

  public static Map<Month, Integer> buildMonthsMap() {
    Map<Month, Integer> months = new HashMap<>();
    months.put(Month.JANUARY, 31);
    months.put(Month.FEBRUARY, 28);
    months.put(Month.MARCH, 31);
    months.put(Month.APRIL, 30);
    months.put(Month.MAY, 31);
    months.put(Month.JUNE, 30);
    months.put(Month.JULY, 31);
    months.put(Month.AUGUST, 31);
    months.put(Month.SEPTEMBER, 30);
    months.put(Month.OCTOBER, 31);
    months.put(Month.NOVEMBER, 30);
    months.put(Month.DECEMBER, 31);

    return months;
  }

  public static Map<Month, Season> buildMonthsSeasons() {
    Map<Month, Season> seasons = new HashMap<>();
    seasons.put(Month.JANUARY, Season.WINTER);
    seasons.put(Month.FEBRUARY, Season.WINTER);
    seasons.put(Month.MARCH, Season.SPRING);
    seasons.put(Month.APRIL, Season.SPRING);
    seasons.put(Month.MAY, Season.SPRING);
    seasons.put(Month.JUNE, Season.SUMMER);
    seasons.put(Month.JULY, Season.SUMMER);
    seasons.put(Month.AUGUST, Season.SUMMER);
    seasons.put(Month.SEPTEMBER, Season.AUTUMN);
    seasons.put(Month.OCTOBER, Season.AUTUMN);
    seasons.put(Month.NOVEMBER, Season.AUTUMN);
    seasons.put(Month.DECEMBER, Season.WINTER);

    return seasons;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("Enter the month: ");
    String month = inputReader.readLine();
    Month monthToLook = Month.valueOf(month.toUpperCase());
    Map<Month, Integer> monthDays = buildMonthsMap();
    Map<Month, Season> seasons = buildMonthsSeasons();

    if (monthDays.containsKey(monthToLook)) {
      System.out.printf("The month '%s' is '%s' and contains %d days%n", month,
          seasons.get(monthToLook), monthDays.get(monthToLook));
      System.out.printf("The month '%s' has ordinal number %d%n", month, monthToLook.ordinal() + 1);
      Season seasonToLook = Season.valueOf(seasons.get(monthToLook).toString());
      System.out.printf("The season '%s' has ordinal number %d%n",
          seasons.get(monthToLook), seasonToLook.ordinal() + 1);
      int nextMonthIndex = (monthToLook.ordinal() + 1);

      Month nextMonth = Month.values()[nextMonthIndex % Month.values().length];

      System.out.printf("The next month is '%s'%n", nextMonth);
      System.out.printf("It has %d days", monthDays.get(nextMonth));
    } else {
      System.out.println("No such month: " + month); // Нет такого месяца
    }
  }
}