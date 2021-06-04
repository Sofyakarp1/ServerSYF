package mirea.mosit.serversfy.result;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import static java.time.temporal.ChronoUnit.MINUTES;

public class GetResult {

    public static String getResultTimeData(String timeAction, String timeRele){

        boolean resR = releAlh(timeRele);
        boolean resA = actionAlh(timeAction);

        if (resA && resR){
            return "Безопасно";
        }
        else if (!resA && resR){
            return "Умеренно безопасно";
        }
        else if (resA && !resR){
            return "Умеренно безопасно";
        }
        else if (!resA && !resR){
            return "Опасность!!!!!!!!";
        }
        return "Ошибка сервера!";
    }

    public static boolean releAlh(String timeRele){
        //LocalDateTime fromAction = LocalDateTime.parse("2021-05-31T22:55:34.915470");

        LocalDateTime fromAction = LocalDateTime.parse(timeRele);
        LocalDate dataFromAction = fromAction.toLocalDate();
        LocalTime timeFromAction = fromAction.toLocalTime();


        // время конца дня
        LocalTime time_22 = LocalTime.parse("22:00:00");
        LocalTime time_24 = LocalTime.parse("23:59:59");

        // Ночное время
        LocalTime rangeNight = LocalTime.parse("23:00:00");
        LocalTime rangeMorning = LocalTime.parse("06:00:00");

        // Тащить из таблицы значения для зон
        LocalTime rangeStart_2 = LocalTime.parse("06:00:00");
        LocalTime rangeEnd_2 = LocalTime.parse("08:00:00");

        if ((timeFromAction.isAfter(rangeNight) & timeFromAction.isBefore(rangeMorning))) {
            return true;
        }
        else if(dataFromAction.equals(LocalDate.now())) {
            if (timeFromAction.isAfter(rangeStart_2) & timeFromAction.isBefore(rangeEnd_2)) {
                System.out.println("Every thing is good!");
                return true;
            } else {
                int diff = (int) MINUTES.between(timeFromAction, LocalTime.now());
                if (diff < 180) {
                    System.out.println("Safe");
                    return true;
                } else return false;
            }
        }
        else return false;
    }


    public static boolean actionAlh(String timeAction) {

        LocalDateTime fromAction = LocalDateTime.parse(timeAction);
        LocalDate dataFromAction = fromAction.toLocalDate();
        LocalTime timeFromAction = fromAction.toLocalTime();


        // время конца дня
        LocalTime time_22 = LocalTime.parse("22:00:00");
        LocalTime time_24 = LocalTime.parse("23:59:59");

        // Ночное время
        LocalTime rangeNight = LocalTime.parse("23:00:00");
        LocalTime rangeMorning = LocalTime.parse("06:00:00");

        // Тащить из таблицы значения для зон
        LocalTime rangeStart_2 = LocalTime.parse("06:00:00");
        LocalTime rangeEnd_2 = LocalTime.parse("08:00:00");

        if ((timeFromAction.isAfter(rangeNight) & timeFromAction.isBefore(rangeMorning))) {
            return true;
        } else if (dataFromAction.equals(LocalDate.now())) {
            if (timeFromAction.isAfter(rangeStart_2) & timeFromAction.isBefore(rangeEnd_2)) {
                System.out.println("Every thing is good!");
                return true;
            } else {
                int diff = (int) MINUTES.between(timeFromAction, LocalTime.now());
                if (diff < 180) {
                    System.out.println("Safe");
                    return true;
                } else return false;
            }
        }
        return false;
    }
}
