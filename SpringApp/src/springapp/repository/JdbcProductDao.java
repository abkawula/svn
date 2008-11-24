package springapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import springapp.domain.NineBallRack;
import springapp.domain.Product;

public class JdbcProductDao extends SimpleJdbcDaoSupport implements ProductDao, NineBallRackDao {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());


    public List<Product> getProductList() {
        logger.info("Getting products!");
        List<Product> products = getSimpleJdbcTemplate().query(
                "select id, description, price from products", 
                new ProductMapper());
        return products;
    }

    public void saveProduct(Product prod) {
        logger.info("Saving product: " + prod.getDescription());
        int count = getSimpleJdbcTemplate().update(
            "update products set description = :description, price = :price where id = :id",
            new MapSqlParameterSource().addValue("description", prod.getDescription())
                .addValue("price", prod.getPrice())
                .addValue("id", prod.getId()));
        logger.info("Rows affected: " + count);
    }
    
    private static class ProductMapper implements ParameterizedRowMapper<Product> {

        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
            Product prod = new Product();
            prod.setId(rs.getInt("id"));
            prod.setDescription(rs.getString("description"));
            prod.setPrice(new Double(rs.getDouble("price")));
            return prod;
        }

    }

	@Override
	public List<NineBallRack> getNineBallRackList() {
		logger.info("Getting nineBallRacks!");
        List<NineBallRack> nineBallRacks = getSimpleJdbcTemplate().query(
                "select id, player1Score, player2Score, deadBalls, innings from NineBallRack", 
                new NineBallRackMapper());
        return nineBallRacks;
	}

	@Override
	public void saveNineBallRack(NineBallRack nineBallRack) {
		logger.info("Saving nineBallRack!");
		int count = getSimpleJdbcTemplate().update(
				"insert into NineBallRack (player1Score, player2Score, deadBalls, innings) " +
				"values (:player1Score, :player2Score, :deadBalls, :innings)",
				new MapSqlParameterSource().addValue("player1Score", nineBallRack.getPlayer1Score())
				.addValue("player2Score", nineBallRack.getPlayer2Score())
				.addValue("deadBalls", nineBallRack.getDeadBalls())
				.addValue("innings", nineBallRack.getInnings()));
		logger.info("Rows affected: " + count);
		
	}
	private static class NineBallRackMapper implements ParameterizedRowMapper<NineBallRack> {

        public NineBallRack mapRow(ResultSet rs, int rowNum) throws SQLException {
        	NineBallRack nineBallRack = new NineBallRack();
        	nineBallRack.setId(rs.getInt("id"));
        	nineBallRack.setPlayer1Score(rs.getInt("player1Score"));
        	nineBallRack.setPlayer2Score(rs.getInt("player2Score"));
        	nineBallRack.setDeadBalls(rs.getInt("deadBalls"));
        	nineBallRack.setInnings(rs.getInt("innings"));
            return nineBallRack;
        }

    }

}