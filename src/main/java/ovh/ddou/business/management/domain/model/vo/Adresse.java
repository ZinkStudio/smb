package ovh.ddou.business.management.domain.model.vo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

/**
 * Adresse value object implementation.
 *
 * @see https://developer.laposte.fr/products/controladresse/latest
 */
@Setter
@Getter
@Embeddable
public class Adresse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String numero;
    private String libelle;
    private String lieuDit;
    private String codePostal;
    private String cedex;
    private String commune;

}
