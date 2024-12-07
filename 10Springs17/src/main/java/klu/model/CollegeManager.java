package klu.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Service //-> Used for Dependency injection
public class CollegeManager {

	JdbcTemplate jt;
	
	@Autowired
	public CollegeManager(JdbcTemplate jt) {
		this.jt = jt;
	}
	
	//INSERT OPERATION USING JDBC TEMPLATE	
	public String saveData(College C) {
		
		try {
		String qry = "insert into college values('"+C.getName()+"','"+C.getAcronym()+"')";
		jt.update(qry);
		return "NEW COLLEGE DATA ADDED";
		}catch (Exception e) {
			return e.getMessage();
		}
		
	}
	
	//UPDATE OPERATION
	public String updateData(College C) {
	    try {
	        String qry = "UPDATE college SET name = ? WHERE acronym = ?";
	        jt.update(qry, C.getName(), C.getAcronym());
	        return "Data has been updated successfully";
	    } catch (Exception e) {
	        return e.getMessage();
	    }
	}

	
	//DELETE OPERATION
	public String deleteData(String acronym) {
		try {
			
			String qry = "delete from college where acronym='"+acronym+"'";
			jt.update(qry);
			return "DATA DELETED";
			
		}catch (Exception e) {
			// TODO: handle exception
			return e.getMessage();
		}
	}
	
	//READ OPERATION
	public List<String> readData(){
		String qry = "select * from college" ;
		List<College> clist = jt.query(qry, new RowMapper<College>() {

			@Override
			public College mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				College ct = new College();
				ct.setName(rs.getString(1));
				ct.setAcronym(rs.getString(2));
				return ct;
			}});
		
		List<String> res = new ArrayList<String>();
		for(College C:clist) { //->For each Loop
			res.add(toJson(clist));
		}
		return res;
	}
	
	//CONVERTING JAVA OBJECT TO JSON
	public String toJson(Object obj) {
		Gson G = new GsonBuilder().create();
		return G.toJson(obj);
	}
}
