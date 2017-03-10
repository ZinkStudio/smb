package ovh.ddou.business.management.domain.model.enums;

import lombok.Getter;

@Getter
public enum Civilite {

    MR("Monsieur", "mr", "monsieur"),
    MME("Madame", "mme", "madame"),
    MLLE("Mademoiselle", "mlle", "mademoiselle");

    private final String label;
    private final String acronyme;
    private final String styleClass;

    private Civilite(String label, String acronyme, String styleClass) {
        this.label = label;
        this.acronyme = acronyme;
        this.styleClass = styleClass;
    }

}
