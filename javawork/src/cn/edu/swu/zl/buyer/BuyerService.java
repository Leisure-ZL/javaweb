package cn.edu.swu.zl.buyer;

public class BuyerService {
	
	public static Buyer toBuyer(Integer id,String name,String userName,String pass) {
		Buyer b = new Buyer();
		b.setId(id);
		b.setName(name);
		b.setPassword(pass);
		b.setUserName(userName);
		
		return b;
	}
	
	
}
