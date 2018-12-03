import com.maxcar.core.utils.StringUtils;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.ItemAddRequest;
import com.taobao.api.response.ItemAddResponse;

import java.text.DecimalFormat;

public class Test2 {
	private final static Long TAOBAO_CID = 50050566L;
	public static void main(String[] args) {
		String url = "http://gw.api.taobao.com/router/rest";
		String appkey = "24812065";
		String secret = "7cf5fb32a4e8a3ffc3cd339d9baedd4a";
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		ItemAddRequest request = new ItemAddRequest();
		request.setCid(TAOBAO_CID);// 叶子类目id
		request.setNum(1L);// 商品数量
		request.setAuctionPoint(1L);
		request.setType("fixed");// 发布类型。可选值:fixed(一口价),auction(拍卖)
		request.setStuffStatus("second");// 新旧程度。可选值：new(新)，second(二手)，unused(闲置)
		request.setHasInvoice(true); // 发票 有
		request.setHasWarranty(false); // 保修 无
		request.setApproveStatus("instock");// instock在仓库中，onsale在售，默认在售
		request.setSubStock(2L); // 商品是否支持拍下减库存:1支持;2取消支持(付款减库存);0(默认)不更改
		Double price = Double.valueOf(14) * 10000;

		DecimalFormat df = new DecimalFormat("#.##");
		String marketPrice = df.format(price);
		if (StringUtils.isNotBlank(14)) {
			request.setPrice(marketPrice);// 商品价格
		} else {
			request.setPrice("0");// 商品价格
		}
		//设置定金
		request.setSkuProperties("14829532:3292081,14829532:72110507");
		request.setSkuQuantities("1,1");
		//订金
		String subscription = null;
		if(Double.valueOf(14)<=10.00) {
			subscription="300,";
		}else if(Double.valueOf(14)<=20&&Double.valueOf(14)>10) {
			subscription="500,";
		}else if(Double.valueOf(14)<=30&&Double.valueOf(14)>20) {
			subscription="1000,";
		}else {
			subscription="1500,";
		}

		request.setSkuPrices("1500,140000");
		request.setSkuOuterIds("3782914410043,3782914410044");
		//设置上传到仓库
		request.setApproveStatus("instock");
		request.setLocationState("江苏");// 所在省
		request.setLocationCity("常州");
		request.setValidThru(7L);// 有效期
		//request.setHasWarranty(true);//是否有保修。可选值:true,false;默认值:false(不保修)
		request.setSellPromise(true);//是否承诺退换货服务!虚拟商品无须设置此项!
		request.setIsOffline("3");//是否是线下商品。1：线上商品（默认值）；2：线上或线下商品；3：线下商品。
		request.setLocalityLifeExpirydate("7");// 电子凭证时效为7天
		request.setLocalityLifeMerchant("0:淘宝");
		request.setLocalityLifeOnsaleAutoRefundRatio(100L);
		request.setLocalityLifeRefundRatio(100L);//退款比例，百分比%前的数字,1-100的正整数值
		//设置核销门店
		request.setDesc("这是我上传的测试二手车");

		request.setLocalityLifeChooseLogis("1");//使用邮寄
		request.setFreightPayer("buyer");//买家运费承担
		request.setPostFee("999");
		request.setExpressFee("999");
//		request.setLocalityLifeObs("1");
		request.setLocalityLifeEticket(";has_pos:1;");

//		String unit = "";
//		if(car.getModelName()!=null&&car.getModelName().contains("L")) {
//			unit= car.getModelName().substring(car.getModelName().indexOf("L")-3,car.getModelName().indexOf("L")+1 );
//		}else if(car.getModelName()!=null&&car.getModelName().contains("T")) {
//			unit = car.getModelName().substring(car.getModelName().indexOf("T")-3,car.getModelName().indexOf("T")+1 );
//		}
//		String title = "二手车 "+"别克"+"2012"+"2012款"+"常州阿里智慧汽车城 "+"0519-68000111".replaceAll("二手车", "").trim();
//		if(title.length()>30) {
//			title=title.substring(0, title.indexOf("常"));
//		}
//		request.setTitle(title);


//		req.setSkuQuantities("1,1");
//		req.setSkuPrices("2000,120000");
//		req.setSkuOuterIds("3782914410043,3782914410044");
//		req.setLocationState("广西");
//		req.setLocationCity("玉林");
//		req.setNum(1L);
//		req.setPrice("120000");
//		req.setType("fixed");
//		req.setStuffStatus("second");
		request.setTitle("全车通测试二手车");
//		req.setDesc("这是我上传的测试二手车");
//		req.setApproveStatus("instock");
//		req.setCid(50050566L);
//		req.setFreightPayer("buyer");
		//req.setValidThru(7L);
//		req.setHasInvoice(true);
//		req.setHasWarranty(false);
		request.setSellerCids("1350951592,20523036");
		//选择核销门店
//		req.setPostFee("999");
//		req.setExpressFee("999");
//		req.setSellPromise(true);
//		req.setSubStock(2L);
//		req.setIsOffline("3");
//		req.setLocalityLifeChooseLogis("1");
//		req.setLocalityLifeExpirydate("7");
//		req.setLocalityLifeMerchant("0:淘宝");
//		req.setLocalityLifeRefundRatio(100L);
//		req.setLocalityLifeOnsaleAutoRefundRatio(100L);
		request.setLocalityLifeRefundmafee("1");
//		req.setLocalityLifeEticket(";has_pos:1;");

		request.setInputPids("143410077,20207674,30259,148656181");
		request.setProps("10265769:396242950;136152291:38915;136326248:6199399;136262505:30694075;136280418:636768829;122450261:3296643;128716001:3297117;14829532:3292081;14829532:72110507;");
//		request.setSkuProperties("14829532:3292081,14829532:72110507");
		request.setInputStr("LVGBJE235HG189173,2013-01,888888万公里,0.00万元");
		try {
//			System.out.print(request);
			ItemAddResponse response = client.execute(request , "6202827e9c5524d604ed4719164954c495ceg1401295ed74227823786");
			System.out.println(response.getBody());
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}






	}
}
