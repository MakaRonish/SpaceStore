package ca.sheridancollege.makaju.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;


import ca.sheridancollege.makaju.beans.Gadget;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class GadgetRepositories {
	private NamedParameterJdbcTemplate jdbc;
	
	public void addArt(Gadget gadget) { 
		MapSqlParameterSource params = new MapSqlParameterSource();

		
		String query = "INSERT INTO Space_gadget"
				+ "(Name, Price, Durability, Range, Weight, Special_Abilities)"
				+ "VALUES"
				+ "(:n, :p, :d,:r,:w,:sa)";
		
		params.addValue("n", gadget.getName());
		params.addValue("p", gadget.getPrice());
		params.addValue("d", gadget.getDurability());
		params.addValue("r", gadget.getRange());
		params.addValue("w", gadget.getWeight());
		params.addValue("sa", gadget.getSpecial_Abilities());

		
		
		
				jdbc.update(query, params);
	}
	public ArrayList<Gadget> getGadget() {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "Select * from Space_Gadget";
		ArrayList<Gadget> gadget = new ArrayList<Gadget>();
		List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);
		
		for (Map<String, Object> row : rows) 
		{
		Gadget g = new Gadget();
		g.setID((int)(row.get("ID")));
		g.setName((String)(row.get("Name")));
		g.setPrice((String)(row.get("Price")));
		g.setDurability((String)(row.get("Durability")));
		g.setRange((String)(row.get("Range")));
		g.setWeight((String)(row.get("Weight")));
		g.setSpecial_Abilities((String)(row.get("Special_Abilities")));
		gadget.add(g);
		}
		
		return gadget;
		}
	public Gadget getGadgetsById(int ID) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT * FROM Space_Gadget WHERE id=:id";
		parameters.addValue("id", ID);
		ArrayList<Gadget> gadgets =
		(ArrayList<Gadget>)jdbc.query(query, parameters,
		new BeanPropertyRowMapper<Gadget>(Gadget.class));
		if (gadgets.size()>0)
		return gadgets.get(0);
		return null;
		}
	public void editGadget(Gadget gadgets) {
	    MapSqlParameterSource params = new MapSqlParameterSource();

	    String query = "UPDATE Space_gadget SET "
	            + "Name=:n, "
	            + "Price=:p, "
	            + "Durability=:d, "
	            + "Range=:r, "
	            + "Weight=:w, "
	            + "Special_Abilities=:sa WHERE id=:ID"; 
	    params.addValue("ID", gadgets.getID()); 
	    params.addValue("n", gadgets.getName());
	    params.addValue("p", gadgets.getPrice());
	    params.addValue("d", gadgets.getDurability());
	    params.addValue("r", gadgets.getRange());
	    params.addValue("w", gadgets.getWeight());
	    params.addValue("sa", gadgets.getSpecial_Abilities());
	    
	    jdbc.update(query, params);
	}
	public void deleteGadget(Gadget gadgets, int id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
	    
	    String query = "DELETE FROM Space_gadget WHERE id=:id";
	    params.addValue("id", id);
	    jdbc.update(query, params);
		
	}


}
