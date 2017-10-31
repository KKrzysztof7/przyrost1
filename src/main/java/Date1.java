import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.EnumSet;

import static java.time.temporal.ChronoUnit.MINUTES;

public class Date1 {

    public static void Datemain()
    {
        zajecia();
    }

    private static void spr(LocalTime date1, LocalTime czasod, LocalTime czasdo, LocalTime czas3)
    {
        boolean flaga = false;
        int minuty = 0;
        if(date1.isAfter(czasod) && date1.isBefore(czasdo))
        {
                flaga = true;
                minuty = (int) MINUTES.between(date1, czasdo);
                System.out.println (minuty + " minut do końca zajęć");
        }
        if(date1.isAfter(czasdo) && date1.isBefore(czas3))
        {
            minuty = (int) MINUTES.between(date1, czas3);
            System.out.println (minuty + " minut do końca przerwy");
        }
        return;
    }

    public static void zajecia()
    {
        LocalTime datenow = LocalTime.now();

        LocalTime[] date = new LocalTime[13];
        date[1] = LocalTime.of(8, 15);
        date[2] = LocalTime.of(9, 45);
        date[3] = LocalTime.of(10, 00);
        date[4] = LocalTime.of(11, 30);
        date[5] = LocalTime.of(11, 45);
        date[6] = LocalTime.of(13, 15);
        date[7] = LocalTime.of(13, 45);
        date[8] = LocalTime.of(15, 15);
        date[9] = LocalTime.of(15, 30);
        date[10] = LocalTime.of(17, 00);
        date[11] = LocalTime.of(17, 15);
        date[12] = LocalTime.of(18, 45);
        if(EnumSet.of( DayOfWeek.MONDAY , DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY ).contains( LocalDate.now( ZoneId.of( "Europe/Paris" ) ).getDayOfWeek() ) && datenow.isAfter(LocalTime.of(8,15)) && datenow.isBefore(LocalTime.of(18, 45)))
        {
            for (int i = 1; i < 12; i = i + 2)
            {
                spr(datenow, date[i], date[i + 1], date[i + 2]);
            }
            return;
        }
    }
}