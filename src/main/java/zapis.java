import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class zapis
{
    public static void zapisdopliku() throws IOException {
        File plik = new File("temp.txt");
        String odczyt = "";
        PrintWriter wyjscie = new PrintWriter(new FileOutputStream(new File("odp.txt"),true ));
        try
        {
            Scanner wczyt = new Scanner(plik);
            while (wczyt.hasNextLine())
            {
                odczyt = wczyt.nextLine();
                wyjscie.println(odczyt);
            }
            PrintWriter czysc = new PrintWriter("temp.txt");
            czysc.print("");
            czysc.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Brak pliku");
        }
        wyjscie.close();
        try {
            sortuj();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sortuj() throws IOException {
        ArrayList<String> wiersz = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new FileReader("odp.txt"));

        String s;
        while((s = reader.readLine())!=null)
            wiersz.add(s);
        Collections.sort(wiersz);
        FileWriter writer = new FileWriter("odp.txt");
        for(String cur: wiersz)
        {
            writer.write(cur+"\n");
        }
        reader.close();
        writer.close();
    }
}
