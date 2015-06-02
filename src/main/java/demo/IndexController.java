package demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
	
	@Autowired
	private DaoPrimary daoPrimary;
	
	@Autowired
	private DaoSecondary daoSecondary;
	
	
	@RequestMapping(value={"","/"})
	public String index(){
		return "index";
	}
	
	@RequestMapping("/primary")
	public @ResponseBody List<Barang> primary(){
		return daoPrimary.getBarangs();
	}
	
	@RequestMapping("/secondary")
	public @ResponseBody List<Barang> secondary(){
		return daoSecondary.getBarangs();
	}

}
