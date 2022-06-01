package fairyShop.repositories;

import fairyShop.models.Helper;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class HelperRepository implements Repository<Helper>{

    private Map<String, Helper> helpers;


    public HelperRepository() {
        this.helpers = new LinkedHashMap<>();
    }

    @Override
    public Collection<Helper> getModels() {
        return this.helpers.values();
    }

    @Override
    public void add(Helper model) {
        this.helpers.put(model.getName(), model);
    }

    @Override
    public boolean remove(Helper model) {
        return helpers.remove(model.getName(), model);
    }

    @Override
    public Helper findByName(String name) {
        return this.helpers.get(name);
    }
}
