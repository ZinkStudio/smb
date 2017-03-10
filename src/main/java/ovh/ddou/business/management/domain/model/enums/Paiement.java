package ovh.ddou.business.management.domain.model.enums;

import lombok.Getter;

@Getter
public enum Paiement {

    ESPECES("Espèces", "especes"),
    CARTE_BANCAIRE("Carte bancaire", "cb"),
    PAYPAL("PayPal", "paypal"),
    PRELEVEMENT("Prélèvement", "prelevement"),
    VIREMENT("Virement", "virement");

    private final String label;
    private final String code;

    private Paiement(String label, String code) {
        this.label = label;
        this.code = code;
    }

}
