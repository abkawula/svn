package springapp.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import springapp.service.NineBallRackManager;

public class NineBallRackController implements Controller {

	protected final Log logger = LogFactory.getLog(getClass());
	
	private NineBallRackManager nineBallRackManager;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		logger.debug("Starting handleRequest");
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("nineBallRacks", nineBallRackManager.getNineBallRacks());
		
		return new ModelAndView("nineballreport", "model", model);
	}

	public void setNineBallRackManager(NineBallRackManager nineBallRackManager) {
		this.nineBallRackManager = nineBallRackManager;
	}

}
