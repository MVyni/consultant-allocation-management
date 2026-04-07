import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ConsultancySystem {
    private List<Consultant> consultants = new ArrayList<>();
    private List<Skill> skills = new ArrayList<>();
    private List<Allocation> allocations = new ArrayList<>();

    private void printAvailableConsultants() {
        for (Consultant consultant : consultants) {
            if (consultant.isAvailability()) {
                System.out.println(consultant);
            }
        }
    }

    private void printActiveProjects() {
        if (allocations.isEmpty()) {
            System.out.println("There are no active projects at the moment.");
            return;
        }

        System.out.println("Active projects:");
        for (Allocation allocation : allocations) {
            System.out.println(allocation);
        }
    }

    private void printExitSummary() {
        System.out.println("Total consultants allocated today: " + allocations.size());
    }

    public static void main(String[] args) {
        ConsultancySystem system = new ConsultancySystem();

        Skill javaSkill = new Skill(UUID.randomUUID(), "Java", "Júnior");
        Skill nodeSkill = new Skill(UUID.randomUUID(), "Node.js", "Pleno");
        Skill reactSkill = new Skill(UUID.randomUUID(), "React.js", "Sênior");

        Consultant vyni = new Consultant(
                UUID.randomUUID(),
                "Vynicius",
                javaSkill,
                true,
                20.5,
                LocalDate.now()
        );

        Consultant carol = new Consultant(
                UUID.randomUUID(),
                "Carol",
                reactSkill,
                true,
                23.0,
                LocalDate.of(2026,9,26)
        );

        Consultant nabo = new Consultant(
                UUID.randomUUID(),
                "Nabo",
                nodeSkill,
                true,
                19.2,
                LocalDate.of(2020,5,25)
        );

        system.consultants.add(vyni);
        system.consultants.add(carol);
        system.consultants.add(nabo);

        Scanner scan = new Scanner(System.in); // to read the terminal input

        System.out.println("Would you like to manage the talent allocation? (Yes / No)");
        String res = scan.nextLine();

        if (res.equalsIgnoreCase("No")) {
            System.out.println("Ok! The system is shutting down now.");
            system.printExitSummary();
            scan.close();
            return;
        }

        if (res.equalsIgnoreCase("Yes")) {
            system.printAvailableConsultants();
            System.out.println("Choose a consultant by name.");
            String resConsultant = scan.nextLine();

            System.out.println("Write down the client to which the consultant will be allocated.");
            String resClient = scan.nextLine();

            System.out.println("Write down the project to which the consultant will be allocated.");
            String resProject = scan.nextLine();

            System.out.println("Write down the start date of the project to which the consultant will be allocated, ex: 07/04/2026");
            String resStartProject = scan.nextLine();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dateStart = LocalDate.parse(resStartProject, formatter);

            System.out.println("Write down the expect end date of the project to which the consultant will be allocated, ex: 07/04/2026");
            String resExpectEndProject = scan.nextLine();
            LocalDate dateEnd = LocalDate.parse(resExpectEndProject, formatter);

            boolean consultantAllocated = false;

            for (Consultant consultant : system.consultants) {
                if (resConsultant.equalsIgnoreCase(consultant.getName()) && consultant.isAvailability()) {
                    Allocation allocation = new Allocation(UUID.randomUUID(),
                            consultant,
                            resClient,
                            resProject,
                            dateStart,
                            dateEnd);
                    system.allocations.add(allocation);
                    consultant.setAvailability(false);
                    consultantAllocated = true;

                    System.out.println("The consultant " + consultant.getName() + " already assigned to the project of " +
                            resClient + ".");
                    break;
                }
            }

            if (!consultantAllocated) {
                System.out.println("No available consultant was found with that name.");
            }

            system.printActiveProjects();
            system.printExitSummary();
            scan.close();
            return;
        }

        System.out.println("Invalid option. The system is shutting down now.");
        system.printExitSummary();
        scan.close();
    }
}
