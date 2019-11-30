package dat19v2.projektgrafiskrep.grafiskrep.model;

import java.time.LocalDate;
import java.util.List;

public class Service {
    private LocalDate date;
    private List<Repair> repairs;

    public Service() {
    }

    public Service(LocalDate date, List<Repair> repairs) {
        this.date = date;
        this.repairs = repairs;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Repair> getRepairs() {
        return repairs;
    }

    public void setRepairs(List<Repair> repairs) {
        this.repairs = repairs;
    }
}
