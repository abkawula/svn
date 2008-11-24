package service;

import java.util.List;

import repository.NineBallMatchDao;
import domain.NineBallMatch;
import domain.Player;

public class SimpleNineBallManager implements NineBallManager {

	private NineBallMatchDao nineBallMatchDao;
	
	public void setNineBallMatchDao(NineBallMatchDao nineBallMatchDao) {
		this.nineBallMatchDao = nineBallMatchDao;
	}

	@Override
	public List<NineBallMatch> getNineBallMatches() {
		Player adam = new Player();
		adam.setId(1);
		return nineBallMatchDao.getNineBallMatches(adam);
	}

	@Override
	public void saveNineBallMatch(NineBallMatch nineBallMatch) {
		nineBallMatchDao.saveNineBallMatch(nineBallMatch);

	}

}
