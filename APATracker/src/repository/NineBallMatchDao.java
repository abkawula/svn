package repository;

import java.util.List;

import domain.NineBallMatch;
import domain.Player;

public interface NineBallMatchDao {

	public List<NineBallMatch> getNineBallMatches(Player player);

    public void saveNineBallMatch(NineBallMatch nineBallMatch);
    
}
