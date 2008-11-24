package web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import service.NineBallManager;
import springapp.service.PriceIncrease;


public class NineBallMatchFormController extends SimpleFormController {

	/** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    private NineBallManager nineBallManager;
    
    public ModelAndView onSubmit(Object command)
    throws ServletException {
		
		return new ModelAndView(new RedirectView(getSuccessView()));
    }
    
    protected Object formBackingObject(HttpServletRequest request) throws ServletException {
        
        return ;
    }

	public NineBallManager getNineBallManager() {
		return nineBallManager;
	}

	public void setNineBallManager(NineBallManager nineBallManager) {
		this.nineBallManager = nineBallManager;
	}
}
