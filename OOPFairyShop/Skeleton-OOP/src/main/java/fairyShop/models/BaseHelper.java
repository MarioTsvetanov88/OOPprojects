package fairyShop.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static fairyShop.common.ExceptionMessages.HELPER_NAME_NULL_OR_EMPTY;

public abstract class BaseHelper implements Helper{
    private String name;
    private int energy;
    private  List<Instrument> instruments;

    public BaseHelper(String name, int energy) {
        this.setName(name);
        this.setEnergy(energy);
        this.instruments = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(HELPER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    @Override
    public void work() {
        this.setEnergy(Math.max(0, this.energy - 10));
    }

    @Override
    public void addInstrument(Instrument instrument) {
        this.instruments.add(instrument);
    }

    @Override
    public boolean canWork() {
        return this.energy > 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getEnergy() {
        return this.energy;
    }

    @Override
    public List<Instrument> getInstruments() {
        return this.instruments;
    }

    @Override
    public String toString() {
        int notBrokenInstruments = 0;
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Name: %s",name));
        builder.append(System.lineSeparator());
        builder.append(String.format("Energy: %d", energy));
        builder.append(System.lineSeparator());
        for (Instrument instrument : instruments) {
            if (!instrument.isBroken()) {
                notBrokenInstruments++;
            }
        }
        builder.append(String.format("Instruments: %d not broken left",notBrokenInstruments));
        return  builder.toString();
    }
}
