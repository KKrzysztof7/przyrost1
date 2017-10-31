import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.io.FileNotFoundException;

import static org.quartz.JobBuilder.newJob;

public class Scheduler1 {

    public static void main(String[] args) throws InterruptedException, SchedulerException, FileNotFoundException {

        JobKey jobKey1 = new JobKey("job1", "group1");
        JobDetail job1 = JobBuilder.newJob(MyJob.class)
                .withIdentity(jobKey1).build();

        JobKey jobKey2 = new JobKey("job2", "group1");
        JobDetail job2 = JobBuilder.newJob(MyJob2.class)
                .withIdentity(jobKey2).build();


        Trigger trigger1 = TriggerBuilder
                .newTrigger()
                .withIdentity("trigger1", "group1")
                .withSchedule(
                        CronScheduleBuilder.cronSchedule("0 * * ? * *"))
                .build();

        Trigger trigger2 = TriggerBuilder
                .newTrigger()
                .withIdentity("trigger2", "group1")
                .withSchedule(
                        CronScheduleBuilder.cronSchedule("*/30 * * * * ?"))
                .build();

        Scheduler scheduler = new StdSchedulerFactory().getScheduler();

        scheduler.start();
        scheduler.scheduleJob(job1, trigger1);
        scheduler.scheduleJob(job2, trigger2);
        while(true)
        {
            parsuj.zapis();
        }

    }
}