package ovh.ddou.business.management.jsf.util;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class JSFUtil {

    public static FacesContext facesContext() {

        return FacesContext.getCurrentInstance();
    }

    public static ExternalContext externalContext() {

        return facesContext().getExternalContext();
    }

    public Application application() {

        return facesContext().getApplication();
    }

    public static UIViewRoot viewRoot() {

        return facesContext().getViewRoot();
    }

    public static String viewId() {

        return viewRoot().getViewId();
    }

    public void addMessage(String detail) {

        addMessage(null, detail);
    }

    public static void addMessage(String summary, String detail) {

        facesContext().addMessage(null, new FacesMessage(summary, detail));
    }

    public static void addSuccessMessage(String detail) {

        addSuccessMessage(null, detail);
    }

    public static void addSuccessMessage(String summary, String detail) {

        facesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail));
    }

    public static void addWarningMessage(String detail) {

        addWarningMessage(null, detail);
    }

    public static void addWarningMessage(String summary, String detail) {

        facesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, summary, detail));
    }

    public static void addErrorMessage(String detail) {

        addErrorMessage(null, detail);
    }

    public static void addErrorMessage(String summary, String detail) {

        facesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail));
    }

}
