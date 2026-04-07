import java.util.UUID;

public class Skill {
    private UUID id;
    private String name;
    private String seniority;

    public Skill(UUID id, String name, String seniority) {
        this.id = id;
        this.name = name;
        this.seniority = seniority;
    }

    @Override
    public String toString() {
        return "Skill {" +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", seniority = " + seniority +
                '}';
    }
}
