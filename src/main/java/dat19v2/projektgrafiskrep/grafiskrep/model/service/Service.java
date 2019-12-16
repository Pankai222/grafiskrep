package dat19v2.projektgrafiskrep.grafiskrep.model.service;

import dat19v2.projektgrafiskrep.grafiskrep.model.Machine;
import dat19v2.projektgrafiskrep.grafiskrep.model.MachinePart;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Service {
    private LocalDateTime date;
    private Machine machine;

    public Service() {
    }

    public Service(LocalDateTime date, Machine machine) {
        this.date = date;
        this.machine = machine;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }
}