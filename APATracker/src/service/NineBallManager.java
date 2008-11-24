package service;

import java.util.List;

import domain.NineBallMatch;

public interface NineBallManager {

	public List<NineBallMatch> getNineBallMatches();
	public void saveNineBallMatch(NineBallMatch nineBallMatch);
}
