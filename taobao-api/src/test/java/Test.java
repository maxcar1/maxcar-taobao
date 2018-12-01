import com.maxcar.core.utils.FreeMarkUtil;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.ItemAddRequest;
import com.taobao.api.response.ItemAddResponse;

public class Test {

	public static void main(String[] args) {
		String url = "http://gw.api.taobao.com/router/rest";
		String appkey = "24812065";
		String secret = "7cf5fb32a4e8a3ffc3cd339d9baedd4a";
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);

		ItemAddRequest req = new ItemAddRequest();
		req.setInputStr("LSGGF53W8CH015006,2013-01,888888万公里,0.00万元");
		req.setInputPids("143410077,20207674,30259,148656181");
		req.setProps("10265769:396242950;136152291:38915;136326248:6199399;136262505:30694075;136280418:636768829;122450261:3296643;128716001:3297117;14829532:3292081;14829532:72110507;");
		req.setSkuProperties("14829532:3292081,14829532:72110507");
		req.setSkuQuantities("1,1");
		req.setSkuPrices("2000,120000");
		req.setSkuOuterIds("3782914410043,3782914410044");
		req.setLocationState("广西");
		req.setLocationCity("玉林");
		req.setNum(1L);
		req.setPrice("120000");
		req.setType("fixed");
		req.setStuffStatus("second");
		req.setTitle("全车通测试二手车");
		req.setDesc("这是我上传的测试二手车");
		req.setApproveStatus("instock");
		req.setCid(50050566L);
		req.setFreightPayer("buyer");
		//req.setValidThru(7L);
		req.setHasInvoice(true);
		req.setHasWarranty(false);
		req.setSellerCids("1350951592,20523036");
		//选择核销门店
		req.setPostFee("999");
		req.setExpressFee("999");
		req.setSellPromise(true);
		req.setSubStock(2L);
		req.setIsOffline("3");
		req.setLocalityLifeChooseLogis("1");
		req.setLocalityLifeExpirydate("7");
		req.setLocalityLifeMerchant("0:淘宝");
		req.setLocalityLifeRefundRatio(100L);
		req.setLocalityLifeOnsaleAutoRefundRatio(100L);
		req.setLocalityLifeRefundmafee("1");
		req.setLocalityLifeEticket(";has_pos:1;");

		try {
//			System.out.print(request);
			ItemAddResponse response = client.execute(req , "6202827e9c5524d604ed4719164954c495ceg1401295ed74227823786");
			System.out.println(response.getBody());
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




	}
}
