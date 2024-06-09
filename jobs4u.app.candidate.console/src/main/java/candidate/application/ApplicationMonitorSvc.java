package candidate.application;

import candidate.dto.JobApplicationDto;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ApplicationMonitorSvc {

    private final ScheduledExecutorService scheduler;

    public ApplicationMonitorSvc() {
        this.scheduler = Executors.newScheduledThreadPool(1);
    }

    public void startMonitoring() {
        scheduler.scheduleAtFixedRate(() -> {
            try {
                List<JobApplicationDto> applications = jobApplicationDtos();
                if (applications != null) {
                    for (JobApplicationDto dto : applications) {
                        System.out.println("STATUS UPDATED: " + dto);
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }, 0, 10, TimeUnit.SECONDS);
    }

    private List<JobApplicationDto> jobApplicationDtos() throws IOException {
        List<JobApplicationDto> changedApplications = SrvProxy.hasApplicationStateChanged();
        return changedApplications.isEmpty() ? null : changedApplications;
    }

    public void stopMonitoring() {
        scheduler.shutdown();
        try {
            if (!scheduler.awaitTermination(1, TimeUnit.SECONDS)) {
                scheduler.shutdownNow();
                if (!scheduler.awaitTermination(1, TimeUnit.SECONDS))
                    System.err.println("Scheduler did not terminate");
            }
        } catch (InterruptedException ie) {
            scheduler.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
