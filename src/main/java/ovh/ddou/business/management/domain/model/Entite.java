package ovh.ddou.business.management.domain.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Abstract entity implementation.
 */
@Setter
@Getter
@MappedSuperclass
public abstract class Entite implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (this.id == null) {
            return false;
        }

        if (obj instanceof Entite && obj.getClass().equals(getClass())) {
            return this.id.equals(((Entite) obj).getId());
        }

        return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.id);
        return hash;
    }

}
