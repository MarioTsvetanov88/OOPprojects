package fairyShop.core;

import fairyShop.models.*;
import fairyShop.repositories.HelperRepository;
import fairyShop.repositories.PresentRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static fairyShop.common.ConstantMessages.*;
import static fairyShop.common.ExceptionMessages.*;

public class ControllerImpl implements Controller{
    private HelperRepository helpers;
    private PresentRepository presents;
    private int countCraftedPresents = 0;


    public ControllerImpl() {
        this.helpers = new HelperRepository();
        this.presents = new PresentRepository();
    }


    @Override
    public String addHelper(String type, String helperName) {
        Helper helper;
        if (type.equals("Happy")) {
            helper = new Happy(helperName);
        }else if (type.equals("Sleepy")) {
            helper = new Sleepy(helperName);
        }else {
            throw new IllegalArgumentException(HELPER_TYPE_DOESNT_EXIST);
        }
        this.helpers.add(helper);
        return String.format(ADDED_HELPER,type, helperName);
    }

    @Override
    public String addInstrumentToHelper(String helperName, int power) {
        Helper helper = this.helpers.findByName(helperName);
        if (helper == null) {
            throw new IllegalArgumentException(HELPER_DOESNT_EXIST);
        }

        helper.addInstrument(new InstrumentImpl(power));


        return String.format(SUCCESSFULLY_ADDED_INSTRUMENT_TO_HELPER,power, helperName);
    }

    @Override
    public String addPresent(String presentName, int energyRequired) {
        Present present;
        present = new PresentImpl(presentName, energyRequired);

        return String.format(SUCCESSFULLY_ADDED_PRESENT, presentName);
    }

    @Override
    public String craftPresent(String presentName) {
        Present present = this.presents.findByName(presentName);
        List<Helper> helper = new ArrayList<>();
       // Helper helper = helpers.getModels().stream().findFirst().filter(e -> e.getEnergy() > 50).orElse(null);
        for (Helper model : helpers.getModels()) {
            if (model.getEnergy() > 50) {
                helper.add(model);
            }

        }
        if (helper.isEmpty()) {
            throw new IllegalArgumentException(NO_HELPER_READY);
        }
        ShopImpl shop = new ShopImpl();

        for (Helper value : helper) {
            shop.craft(present, value);
            if (present.isDone()) {
                String done = "done";
                countCraftedPresents++;
                return String.format(PRESENT_DONE, presentName, present.isDone());
            } else {
                String false1 = "false";
                return String.format(PRESENT_DONE, presentName, present.isDone());
            }
        }
            return null;
        }


    @Override
    public String report() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s presents are done!",countCraftedPresents));
        builder.append(System.lineSeparator());
        builder.append("Helpers info:");
        builder.append(System.lineSeparator());
        for (Helper model : helpers.getModels()) {
            builder.append(model);
        }
        return builder.toString();
    }
    }

