package com.Hackathon.JCI.FittingRoomIntelligence.Service;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.Hackathon.JCI.FittingRoomIntelligence.Dao.FittingRoomIntelligenceDao;
import com.Hackathon.JCI.FittingRoomIntelligence.Model.Product;
import com.Hackathon.JCI.FittingRoomIntelligence.Model.ProductRequest;
import com.Hackathon.JCI.FittingRoomIntelligence.Model.Recommendation;

@Service
public class FittingRoomIntelligenceServiceImpl implements FittingRoomIntelligenceService {

	@Autowired
	FittingRoomIntelligenceDao fittingRoomIntelligenceDaoImpl;
	
	
	@Override
	public JSONObject getFittingRoomProductInfo(ProductRequest request) {
	
		if(request.getZoneId() == null || request.getZoneId().equals("") ||
				request.getTimeStamp() == null || request.getTimeStamp().equals("")	)
			  return null;
		
		List<Product> productList = fittingRoomIntelligenceDaoImpl.getFittingRoomArticles(request.getZoneId(), request.getTimeStamp());
		
		List<String> productCodeList = productList.stream().map(Product::getProductCode).collect(Collectors.toList());
		
		 JSONArray array = new JSONArray();
		for(String prodCode : productCodeList) {
			List<Recommendation> list = getRecommendation(prodCode);
			
			JSONObject obj = new JSONObject();
			obj.put("product", prodCode);
			obj.put("RecomendedProducts", list.stream().map(Recommendation::getProductcode).collect(Collectors.toList()));

			array.put(obj);
			
		}
		
		/*JSONObject obj1 = new JSONObject();
		obj1.put("product", "604");
		obj1.put("RecomendedProducts", Arrays.asList(new String[] {"5062401","5062419","5083381","437024075","437024198","743570501","772000833"}));
	
		JSONObject obj2 = new JSONObject();
		obj2.put("product", "851");
		obj2.put("RecomendedProducts", Arrays.asList(new String[] {"5098033","5098066","5098561","437024471","437024495","437024549","772002868"}));
		
		JSONObject obj3 = new JSONObject();
		obj3.put("product", "760");
		obj3.put("RecomendedProducts", Arrays.asList(new String[] {"5141312","5181201","5291661","5291679","437029261","437029308","437029339"}));
		
        JSONArray arr = new JSONArray();
		
        arr.put(obj1);
        arr.put(obj2);
        arr.put(obj3);*/
        
		JSONObject obj = new JSONObject();
		obj.put("FittingroomProducts", array);
		
        return obj;
	}
	
	@Override
	public JSONObject getFittingRoomProductDescription(String productCode) {
		
		List<Product> productList = fittingRoomIntelligenceDaoImpl.getFittingRoomProductDescription(productCode);
		
		JSONObject obj = new JSONObject();
		obj.put("selectedProductDescription", productList);
		
		return obj;
	}

    private List<Recommendation> getRecommendation(String productCode) {
    	
    	String req = "{\"query\": { \"match\": { \"productcode\": "+productCode+" } }}";

		final String uri = "http://10.47.82.251:9200/recomendation/_search";
		
		  HttpHeaders headers = new HttpHeaders();
		    final HttpEntity<String> entity = new HttpEntity<>(req,
		                headers);

		List<Recommendation> resultList = new ArrayList<>();
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.postForObject(uri, req , String.class);
    
	    JSONObject json=new JSONObject(result);
	    JSONObject obj = ((JSONObject) json.get("hits"));
	    JSONArray arr = obj.getJSONArray("hits");
	    
	    if(arr.isEmpty())
	       return resultList;
	    
	    JSONArray finalArray = arr.getJSONObject(0).getJSONObject("_source").getJSONArray("recomdations");
	    
	    for(int i=0; i<finalArray.length(); i++) {
	    	Recommendation recObj = new Recommendation();
	    	JSONObject object = finalArray.getJSONObject(i);
	    	
	    	recObj.setProductcode(object.get("productcode").toString());
	    	recObj.setConfidence((Double)object.get("confidence"));
	    	recObj.setLift((Double) object.get("lift"));
	    	recObj.setConviction((Double) object.get("conviction"));
	    	recObj.setSupport((Double)object.get("support"));
	    	
	    	resultList.add(recObj);
	    }
	    
	    
	    System.out.println(result);    	
    	
    	return resultList;
    }
	
	

}
