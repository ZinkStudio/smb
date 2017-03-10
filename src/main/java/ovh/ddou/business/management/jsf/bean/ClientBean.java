package ovh.ddou.business.management.jsf.bean;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;
import ovh.ddou.business.management.domain.model.Client;
import ovh.ddou.business.management.domain.service.ClientService;
import ovh.ddou.business.management.jsf.util.JSFUtil;
import ovh.ddou.business.management.jsf.view.model.ClientLazyDataModel;

@Setter
@Getter
@Named
@ViewScoped
public class ClientBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private ClientService clientService;

    private LazyDataModel<Client> lazyModel;

    private Client selectedClient;

    private Client client;

    @PostConstruct
    public void load() {

        lazyModel = new ClientLazyDataModel(clientService.findAll());
    }

    public void save() {

        JSFUtil.addMessage("Client Saved: ", this.client.toString());
        clientService.save(this.client);
    }

    public void onRowSelect(SelectEvent event) {

        JSFUtil.addMessage("Client Selected: ", ((Client) event.getObject()).getEmail());
    }

}
