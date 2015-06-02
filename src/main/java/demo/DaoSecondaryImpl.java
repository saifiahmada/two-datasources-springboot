package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DaoSecondaryImpl implements DaoSecondary {
	
	@Autowired
	@Qualifier("jdbcSecondary")
	private JdbcTemplate jdbcSecondary;
	
	public List<Barang> getBarangs(){
		String sql = "select * from barang";
		List<Barang> list = new ArrayList<Barang>();
		
		List<Map<String, Object>> listMap = jdbcSecondary.queryForList(sql);
		for (Map<String, Object> map : listMap) {
			Barang b = new Barang();
			b.setId( (String) map.get("id"));
			b.setNama( (String) map.get("nama"));
			b.setGambar( (String) map.get("gambar"));
			list.add(b);
		}
		
		return list;
	}

}
