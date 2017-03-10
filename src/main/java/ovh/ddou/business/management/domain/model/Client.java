package ovh.ddou.business.management.domain.model;

import ovh.ddou.business.management.domain.model.vo.Adresse;
import java.util.Date;
import java.util.List;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import ovh.ddou.business.management.domain.model.enums.Civilite;

/**
 * Client entity implementation
 */
@Setter
@Getter
@Entity
@Table(name = "client")
public class Client extends Entite {

    private static final long serialVersionUID = 1L;

    private String code;

    @Enumerated(EnumType.STRING)
    private Civilite civilite;

    @NotNull(message = "Le « nom » est obligatoire")
    @Size(min = 3, max = 40, message = "Le « nom » doit avoir au minimum 3 caractères et au maximum 40 caractères")
    private String nom;

    @NotNull(message = "Le « prénom » est obligatoire")
    @Size(min = 3, max = 40, message = "Le « prénom » doit avoir au minimum 3 caractères et au maximum 40 caractères")
    private String prenom;

    @Temporal(TemporalType.DATE)
    private Date naissance;

    @Embedded
    private Adresse adresse;

    @Email(message = "Le « courriel » est invalide")
    private String email;

    private String fixe;

    private String mobile;

    private Boolean estMasque;

    private Boolean autoriseNewsletter;

    private String commentaire;

    @OneToMany(mappedBy = "client")
    private List<Facture> factures;

    public void removeFacture(Facture facture) {
        this.factures.remove(facture);
    }

    public void addFacture(Facture facture) {
        this.factures.add(facture);
    }

}
