package customer.application;

import customer.dto.JobOpeningDto;

import java.io.IOException;
import java.util.List;

public class DisplayJobOpeningsController {
    public List<JobOpeningDto> jobOpeningDtos() throws IOException {
        return SrvProxy.listJobOpenings();
    }

}
