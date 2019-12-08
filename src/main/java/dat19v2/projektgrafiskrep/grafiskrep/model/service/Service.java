package dat19v2.projektgrafiskrep.grafiskrep.model.service;

import dat19v2.projektgrafiskrep.grafiskrep.model.Machine;
import dat19v2.projektgrafiskrep.grafiskrep.model.MachinePart;

import java.time.LocalDateTime;
import java.util.List;

public class Service {
    private LocalDateTime date;
    private Machine machine;
    private List<MachinePart> machineParts;

    public Service() {
    }

    public Service(LocalDateTime date, Machine machine, List<MachinePart> machineParts) {
        this.date = date;
        this.machine = machine;
        this.machineParts = machineParts;
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

    public List<MachinePart> getMachineParts() {
        return machineParts;
    }

    public void setMachineParts(List<MachinePart> machineParts) {
        this.machineParts = machineParts;
    }
}