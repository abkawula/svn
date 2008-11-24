package web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import service.NineBallManager;
import domain.NineBallMatch;

public class NineBallMatchController implements Controller {

	protected final Log logger = LogFactory.getLog(getClass());
	
	private NineBallManager nineBallManager;
	
	public void setNineBallManager(NineBallManager nineBallManager) {
		this.nineBallManager = nineBallManager;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		logger.info("Begin handleRequest");
		
		Map<String, Object> myModel = new HashMap<String, Object>();
		
		List<NineBallMatch> nineBallMatches = nineBallManager.getNineBallMatches();
		myModel.put("nineBallMatches", nineBallMatches);
		
		return new ModelAndView("nineballmatches", "model", myModel);
	}

}
