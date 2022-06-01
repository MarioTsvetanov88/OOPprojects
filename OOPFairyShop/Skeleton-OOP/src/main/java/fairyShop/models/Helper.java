package fairyShop.models;

import java.util.Collection;
import java.util.List;

public interface Helper {
    void work();

    void addInstrument(Instrument instrument);

    boolean canWork();

    String getName();

    int getEnergy();

    List<Instrument> getInstruments();
}
