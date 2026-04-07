import java.time.LocalDate;
import java.util.UUID;

public class Consultant {
    private UUID id;
    private String name;
    private Skill skill;
    private boolean availability = true;
    private double priceHour;
    private LocalDate hireDate;

    public Consultant(
            UUID id,
            String name,
            Skill skill,
            boolean availability,
            double priceHour,
            LocalDate hireDate) {

        this.id = id;
        this.name = name;
        this.skill = skill;
        this.availability = availability;
        this.priceHour = priceHour;
        this.hireDate = hireDate;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Consultant {" +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", skill = " + skill +
                ", availability = " + availability +
                ", priceHour = " + priceHour +
                ", hireDate = " + hireDate +
                '}';
    }
}
