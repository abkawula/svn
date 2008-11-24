package repository;

import java.util.List;

import domain.NineBallMatch;
import domain.NineBallRack;

public interface NineBallRackDao {
	
	public List<NineBallRack> getNineballRacks(NineBallMatch nineBallMatch);

    public void saveNineBallRack(NineBallRack nineBallRack);

}
