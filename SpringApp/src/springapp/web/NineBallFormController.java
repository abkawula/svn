package springapp.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import springapp.domain.NineBallRack;
import springapp.service.NineBallRackManager;
import springapp.service.PriceIncrease;

public class NineBallFormController extends SimpleFormController {

	protected final Log logger = LogFactory.getLog(getClass());
	
	private NineBallRackManager rackManager;
	
	public ModelAndView onSubmit(Object command)
    throws ServletException {
		logger.debug("Begin onSubmit");
		
		NineBallRack nineBallRack = (NineBallRack) command;
		List<NineBallRack> nineBallRacks = new ArrayList<NineBallRack>();
		nineBallRacks.add(nineBallRack);
		rackManager.saveNineBallRacks(nineBallRacks);
		
		return new ModelAndView(new RedirectView(getSuccessView()));
	}
	
	public NineBallRackManager getRackManager() {
		return rackManager;
	}

	public void setRackManager(NineBallRackManager rackManager) {
		this.rackManager = rackManager;
	}
}
