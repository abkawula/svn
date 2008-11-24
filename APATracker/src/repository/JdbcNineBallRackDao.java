package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import domain.NineBallMatch;
import domain.NineBallRack;

public class JdbcNineBallRackDao extends SimpleJdbcDaoSupport implements
		NineBallRackDao {

	@Override
	public List<NineBallRack> getNineballRacks(NineBallMatch nineBallMatch) {
		logger.info("Begin getNineBallRacks");
//		List<NineBallRack> nineBallRacks = getSimpleJdbcTemplate().query(
//				"Select id, nineBallMatchId, player1Score, innings, deadBalls, player2Score " +
//				"from NineBallRack where nineBallMatchId = " + nineBallMatch.getId(), 
//				new NineBallRackMapper());
		
		List<NineBallRack> nineBallRacks = new ArrayList<NineBallRack>();
		
		NineBallRack n1 = new NineBallRack(1,1,5,2,0,5);
		NineBallRack n2 = new NineBallRack(2,1,5,1,2,13);
		nineBallRacks.add(n1);
		nineBallRacks.add(n2);
		
		return nineBallRacks;
	}

	@Override
	public void saveNineBallRack(NineBallRack nineBallRack) {
		logger.info("Saving nineBallRack");
		
		int count = getSimpleJdbcTemplate().update("" +
				"insert into NineBallRack (nineBallMatchId, player1Score, innings, deadBalls, player2Score) " +
				"values (:nineBallMatchId, :player1Score, :innings, :deadBalls, :player2Score)", 
				new MapSqlParameterSource().addValue("nineBallMatchId", nineBallRack.getNineBallMatchId())
				.addValue("player1Score", nineBallRack.getPlayer1Score())
				.addValue("innings", nineBallRack.getInnings())
				.addValue("deadBalls", nineBallRack.getDeadBalls())
				.addValue("player2Score", nineBallRack.getPlayer2Score()));
		
		logger.info("logged " + count + " new nine ball racks");

	}
	
	private static class NineBallRackMapper implements ParameterizedRowMapper<NineBallRack> {

        public NineBallRack mapRow(ResultSet rs, int rowNum) throws SQLException {
        	NineBallRack nineBallRack = new NineBallRack();
        	nineBallRack.setId(rs.getInt("id"));
        	nineBallRack.setNineBallMatchId(rs.getInt("nineBallMatchId"));
        	nineBallRack.setPlayer1Score(rs.getInt("player1Score"));
        	nineBallRack.setInnings(rs.getInt("innings"));
        	nineBallRack.setDeadBalls(rs.getInt("deadBalls"));
        	nineBallRack.setPlayer2Score(rs.getInt("player2Score"));
            return nineBallRack;
        }
	}
}
