package ovh.ddou.business.management.domain.service;

import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ovh.ddou.business.management.domain.model.Client;
import ovh.ddou.business.management.domain.repository.ClientRepository;

@Named
public class ClientService implements Service {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientService.class);

    @Inject
    private ClientRepository clientRepository;

    /**
     * Find all.
     *
     * @return the list
     */
    public List<Client> findAll() {

        LOGGER.debug("ClientServiceImpl.findAll()");
        return clientRepository.findAll();
    }

    /**
     * Persister un client.
     *
     * @param client Un client
     * @return Le client persisté
     */
    public Client save(Client client) {

        LOGGER.debug("ClientServiceImpl.save()");
        return clientRepository.save(client);
    }

}
