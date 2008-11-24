package springapp.repository;

import java.util.List;

import springapp.domain.NineBallRack;

public interface NineBallRackDao {

	public List<NineBallRack> getNineBallRackList();

    public void saveNineBallRack(NineBallRack nineBallRack);
}
