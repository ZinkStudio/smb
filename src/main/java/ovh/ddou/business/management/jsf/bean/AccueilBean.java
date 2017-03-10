package ovh.ddou.business.management.jsf.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Named
@ViewScoped
public class AccueilBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private final List<String> submittedValues = new ArrayList<>();

    private String field;

}
