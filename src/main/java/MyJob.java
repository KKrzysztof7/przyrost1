import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyJob implements org.quartz.Job {

    public MyJob() {
    }

    public void execute(JobExecutionContext context) throws JobExecutionException {
        Date1.zajecia();
    }
}

