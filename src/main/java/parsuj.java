import java.io.FileOutputStream;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class parsuj {
    public static void zapis() throws FileNotFoundException {

        int liczba;
        String tekst;
        boolean flaga = true;
        int pozycja = 0;


        Scanner in = new Scanner(System.in);
        liczba = in.nextInt();

        Scanner odczyt = new Scanner(System.in);
        tekst = odczyt.nextLine();

        if (parsuj("select", tekst) == -1) flaga = false;
            else if(parsuj("from", tekst) != -1 && parsuj("select", tekst) > parsuj("from", tekst)) flaga = false;
                else if(parsuj("where", tekst) != -1 && parsuj("from", tekst) > parsuj("where", tekst)) flaga = false;
                    else if(parsuj("order by", tekst) != -1 && parsuj("where", tekst) > parsuj("order by", tekst)) flaga = false;

        if(flaga) {
            File plik = new File("temp.txt");
            PrintWriter zapis = new PrintWriter(new FileOutputStream(new File("temp.txt"),true));
            zapis.println(liczba + " " + tekst);
            zapis.close();
        }
        else
            System.out.println("Błąd zadania.");

    }

    private static int parsuj(String szukany, String tekst) {
        int j = tekst.indexOf(szukany);
        return j;
    }

}