package ovh.ddou.business.management.domain.model;

import ovh.ddou.business.management.domain.model.vo.Adresse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;
import lombok.Getter;
import lombok.Setter;
import ovh.ddou.business.management.domain.model.enums.Paiement;

/**
 * Facture entity implementation
 */
@Setter
@Getter
@Entity(name = "Facture")
@Table(name = "facture")
public class Facture extends Entite {

    private static final long serialVersionUID = 1L;

    @Past
    @Temporal(TemporalType.DATE)
    private Date emission;

    @ManyToOne
    private Client client;

    @Embedded
    private Adresse adresse;

    @ElementCollection
    @CollectionTable(name = "facture_prestation")
    @MapKeyJoinColumn(name = "prestations_id")
    @Column(name = "quantite")
    private Map<Prestation, Double> prestations = new HashMap<Prestation, Double>();

    @Enumerated(EnumType.STRING)
    private Paiement paiement;

    private Boolean devis;

    private Boolean reglee;

    public void removePrestation(Prestation prestation) {
        this.prestations.remove(prestation);
    }

    public void addPrestation(Prestation prestation, Double quantite) {
        this.prestations.put(prestation, quantite);
    }

}
