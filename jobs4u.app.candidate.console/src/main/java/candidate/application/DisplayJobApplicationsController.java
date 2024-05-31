package candidate.application;

import candidate.dto.JobApplicationDto;
import candidate.application.SrvProxy;

import java.io.IOException;
import java.util.List;

public class DisplayJobApplicationsController {
    public List<JobApplicationDto> jobApplicationDtos() throws IOException {
        return SrvProxy.getJobApplications();
    }

}
