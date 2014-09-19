package org.amr.gawi.sh.view.beans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

public class NotificationsBean {
    public NotificationsBean() {
    }

    public String showInformationMessage() {
        
        FacesContext ctx = FacesContext.getCurrentInstance();
        FacesMessage fMessage= new FacesMessage(FacesMessage.SEVERITY_INFO,null,"This message will disappear in 3 seconds");
        
        ctx.addMessage(null, fMessage);
        
        ExtendedRenderKitService erks = Service.getRenderKitService(ctx, ExtendedRenderKitService.class);
        StringBuilder builder= new StringBuilder();
        builder.append("jQuery('.auto-hide').delay(3000).hide('fast');");
        erks.addScript(ctx, builder.toString());
        
        return null;
    }
    
}
