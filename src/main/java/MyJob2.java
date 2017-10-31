import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.io.FileNotFoundException;
import java.io.IOException;


public class MyJob2 implements org.quartz.Job {

    public MyJob2() {

    }

    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            zapis.zapisdopliku();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}