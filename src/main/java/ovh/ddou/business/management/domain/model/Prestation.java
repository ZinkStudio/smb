package ovh.ddou.business.management.domain.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * Prestation entity implementation
 */
@Setter
@Getter
@Entity
@Table(name = "prestation")
public class Prestation extends Entite {

    private static final long serialVersionUID = 1L;

    private String libelle;
    private String description;
    private Double prixUnitaire;

}
