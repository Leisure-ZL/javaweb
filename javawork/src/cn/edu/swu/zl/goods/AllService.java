package cn.edu.swu.zl.goods;

public class AllService {
	public static BuyGoods sGoodTobGood(SellGoods sGood,int buyerId) {
		BuyGoods bGood = new BuyGoods();
		
		bGood.setbuyerId(buyerId);
		bGood.setCount(sGood.getCount());
		bGood.setDscp(sGood.getDscp());
		bGood.setImg(sGood.getImg());
		bGood.setName(sGood.getName());
		bGood.setPrice(sGood.getPrice());
		
		return bGood;
	}
}
