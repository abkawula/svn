package springapp.service;

import java.util.List;

import springapp.domain.NineBallRack;
import springapp.repository.NineBallRackDao;

public class SimpleNineBallRackManager implements NineBallRackManager {

	private NineBallRackDao nineBallRackDao;
	
	public void setNineBallRackDao(NineBallRackDao nineBallRackDao) {
		this.nineBallRackDao = nineBallRackDao;
	}

	@Override
	public List<NineBallRack> getNineBallRacks() {
		return nineBallRackDao.getNineBallRackList();
	}

	@Override
	public void saveNineBallRacks(List<NineBallRack> nineBallRacks) {
		for (NineBallRack nineBallRack: nineBallRacks) {
			nineBallRackDao.saveNineBallRack(nineBallRack);
		}

	}

}
