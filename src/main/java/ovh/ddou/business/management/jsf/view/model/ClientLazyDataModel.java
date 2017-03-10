package ovh.ddou.business.management.jsf.view.model;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import ovh.ddou.business.management.domain.model.Client;
import ovh.ddou.business.management.jsf.view.sorter.LazySorter;

/**
 * Client lazy data model.
 */
public class ClientLazyDataModel extends LazyDataModel<Client> {

    private static final long serialVersionUID = 1L;

    private final List<Client> datasource;

    public ClientLazyDataModel(List<Client> clients) {

        this.datasource = clients;
    }

    @Override
    public Client getRowData(String rowKey) {

        for (Client client : datasource) {
            if (client.getId().equals(Long.valueOf(rowKey))) {
                return client;
            }
        }

        return null;
    }

    @Override
    public Object getRowKey(Client client) {

        return client.getId();
    }

    @Override
    public List<Client> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {

        List<Client> data = new ArrayList<>();

        //filter
        for (Client client : datasource) {
            boolean match = true;

            if (filters != null) {
                for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
                    try {
                        String filterProperty = it.next();
                        Object filterValue = filters.get(filterProperty);

                        Field clientField = Client.class.getDeclaredField(filterProperty);
                        clientField.setAccessible(true);
                        Object clientObject = clientField.get(client);

                        String fieldValue = String.valueOf(clientObject);

                        if (filterValue == null || fieldValue.startsWith(filterValue.toString())) {
                            match = true;
                        } else {
                            match = false;
                            break;
                        }
                    } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException e) {
                        match = false;
                    }
                }
            }

            if (match) {
                data.add(client);
            }
        }

        //sort
        if (sortField != null) {
            Collections.sort(data, new LazySorter(sortField, sortOrder));
        }

        //rowCount
        int dataSize = data.size();
        this.setRowCount(dataSize);

        //paginate
        if (dataSize > pageSize) {
            try {
                return data.subList(first, first + pageSize);
            } catch (IndexOutOfBoundsException ioobe) {
                return data.subList(first, first + (dataSize % pageSize));
            }
        }

        return data;
    }

}
