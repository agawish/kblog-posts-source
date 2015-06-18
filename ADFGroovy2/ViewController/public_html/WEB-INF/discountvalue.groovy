import javax.faces.context.FacesContext;
import javax.faces.application.Application;
import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;

Object resolveExpression(String expression){
       FacesContext facesContext = FacesContext.getCurrentInstance();
       Application app = facesContext.getApplication();
       ExpressionFactory elFactory = app.getExpressionFactory();
       ELContext elContext = facesContext.getELContext();
       ValueExpression valueExp =
         elFactory.createValueExpression(elContext, expression, Object.class);
       return valueExp.getValue(elContext);
}

def discount = "10";
def customerType = resolveExpression("#{discount.type}");

if(customerType == 'premium')
	discount = "30";
	
return discount;