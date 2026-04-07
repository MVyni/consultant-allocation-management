import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Allocation {
    private UUID id;
    private Consultant consultant;
    private String clientName;
    private String projectName;
    private LocalDate startDate;
    private LocalDate expectEndDate;

    public Allocation(
            UUID id,
            Consultant consultant,
            String clientName,
            String projectName,
            LocalDate startDate,
            LocalDate expectEndDate
            ) {

        this.id = id;
        this.consultant = consultant;
        this.clientName = clientName;
        this.projectName = projectName;
        this.startDate = startDate;
        this.expectEndDate = expectEndDate;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return "Allocation {" +
                "id = " + id +
                ", consultant = '" + consultant.getName() + '\'' +
                ", clientName = '" + clientName + '\'' +
                ", projectName = '" + projectName + '\'' +
                ", startDate = " + startDate.format(formatter) +
                ", expectEndDate = " + expectEndDate.format(formatter) +
                '}';
    }
}
