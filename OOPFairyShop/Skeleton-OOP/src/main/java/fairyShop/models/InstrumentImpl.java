package fairyShop.models;

import static fairyShop.common.ExceptionMessages.INSTRUMENT_POWER_LESS_THAN_ZERO;

public class InstrumentImpl implements Instrument{
    private int power;

    public InstrumentImpl(int power) {
        this.power = power;
    }

    public void setPower(int power) {
        if (power < 0) {
            throw new IllegalArgumentException(INSTRUMENT_POWER_LESS_THAN_ZERO);
        }
        this.power = power;
    }

    @Override
    public int getPower() {
        return power;
    }

    @Override
    public void use() {
        int powerPoints = this.getPower() - 10;
        if (powerPoints < 0) {
            this.setPower(0);
        }else {
            this.setPower(powerPoints);
        }
    }

    @Override
    public boolean isBroken() {
        return this.getPower() == 0;
    }
}
