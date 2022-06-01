package fairyShop.models;

import java.util.ArrayList;

public class ShopImpl implements Shop {


    @Override
    public void craft(Present present, Helper helper) {
        ArrayList<Instrument> instruments = new ArrayList<>();

        while (helper.canWork()) {
            for (int index = 0; index < helper.getInstruments().size(); index++) {
                Instrument currentInstrument = helper.getInstruments().get(index);
                while (!currentInstrument.isBroken()) {
                        helper.work();
                        currentInstrument.use();
                        if (present.isDone()) {
                            present.getCrafted();
                        }

                    }
                }

            }
        }
    }




