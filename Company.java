package test4.mockito.verfiy;

import java.util.ArrayList;
import java.util.List;

public class Company {

    public List<Developer> developers;

    public Company() {
        developers = new ArrayList<Developer>();
    }

    public void updateDeveloper(Developer developer) {
        if (developer == null || !(developer instanceof Developer)) {
            throw new IllegalArgumentException();
        }
        developer.setName(developer.name);

        developer.setLastName(developer.lastName);
    }

    public void registerNewDeveloper(Developer developer) {
        if (developer == null || !(developer instanceof Developer)) {
            return;
        }
        developers.add(developer);
    }
}
