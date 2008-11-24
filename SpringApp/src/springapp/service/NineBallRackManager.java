package springapp.service;

import java.util.List;

import springapp.domain.NineBallRack;

public interface NineBallRackManager {

	List<NineBallRack> getNineBallRacks();
	
	void saveNineBallRacks(List<NineBallRack> nineBallRacks);
}
