package ovh.ddou.business.management.jsf.view.sorter;

import java.lang.reflect.Field;
import java.util.Comparator;
import org.primefaces.model.SortOrder;
import ovh.ddou.business.management.domain.model.Client;

public class LazySorter implements Comparator<Client> {

    private final String sortField;

    private final SortOrder sortOrder;

    public LazySorter(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }

    @Override
    public int compare(Client client, Client other) {
        try {
            Field clientField = Client.class.getDeclaredField(this.sortField);
            clientField.setAccessible(true);
            Object clientObject = clientField.get(client);

            Field otherField = Client.class.getDeclaredField(this.sortField);
            otherField.setAccessible(true);
            Object otherObject = otherField.get(other);

            int value = ((Comparable) clientObject).compareTo(otherObject);

            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;

        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

}
