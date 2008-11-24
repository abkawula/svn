package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import domain.NineBallMatch;
import domain.NineBallRack;
import domain.Player;

public class JdbcNineBallMatchDao extends SimpleJdbcDaoSupport implements NineBallMatchDao {

	/** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
    
	@Override
	public List<NineBallMatch> getNineBallMatches(Player player) {
		logger.info("Begin getNineBallMatches");
		List<NineBallMatch> nineBallMatches = getSimpleJdbcTemplate().query(
				"Select id, player1Id, player2Id, player1Rank, player2Rank, date " +
				"from NineBallMatch where player1Id = " + player.getId() + " or player2Id = " + player.getId(), 
				new NineBallMatchMapper());
		
		NineBallRackDao rackDao = new JdbcNineBallRackDao();
		for (NineBallMatch match : nineBallMatches) {
			match.setNineBallRacks(rackDao.getNineballRacks(match));
		}
		return nineBallMatches;
	}

	@Override
	public void saveNineBallMatch(NineBallMatch nineBallMatch) {
		logger.info("Saving nineBallMatch");
		
		int count = getSimpleJdbcTemplate().update("" +
				"insert into NineBallMatch (player1Id, player2Id, player1Rank, player2Rank, date) " +
				"values(:player1Id, :player2Id, :player1Rank, :player2Rank, :date", 
				new MapSqlParameterSource().addValue("player1Id", nineBallMatch.getPlayer1Id())
				.addValue("player2Id", nineBallMatch.getPlayer2Id())
				.addValue("player1Rank", nineBallMatch.getPlayer1Rank())
				.addValue("player2Rank", nineBallMatch.getPlayer2Rank())
				.addValue("date", nineBallMatch.getDate()));
		
		nineBallMatch.setId(getSimpleJdbcTemplate().queryForInt("Select last_insert_id"));
		
		NineBallRackDao nineBallRackDao = new JdbcNineBallRackDao();
		for (NineBallRack nineBallRack: nineBallMatch.getNineBallRacks()) {
			nineBallRack.setNineBallMatchId(nineBallMatch.getId());
			nineBallRackDao.saveNineBallRack(nineBallRack);
		}
		
	}
	
	private static class NineBallMatchMapper implements ParameterizedRowMapper<NineBallMatch> {

        public NineBallMatch mapRow(ResultSet rs, int rowNum) throws SQLException {
        	NineBallMatch nineBallMatch = new NineBallMatch();
        	int id = rs.getInt("id");
        	nineBallMatch.setId(id);
        	nineBallMatch.setPlayer1Id(rs.getInt("player1Id"));
        	nineBallMatch.setPlayer2Id(rs.getInt("player2Id"));
        	nineBallMatch.setPlayer1Rank(rs.getInt("player1Rank"));
        	nineBallMatch.setPlayer2Rank(rs.getInt("player2Rank"));
        	
            return nineBallMatch;
        }

    }

}
