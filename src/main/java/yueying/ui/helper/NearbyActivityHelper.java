package yueying.ui.helper;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import yueying.dto.entity.Activity;
import yueying.dto.entity.Cinema;
import yueying.dto.entity.User;
import yueying.service.NearbyActivityService;
import yueying.ui.model.ActivityInfoModel;
import yueying.ui.model.ActivityModel;
import yueying.ui.model.FilmModel;
import yueying.ui.model.NearbyListModel;

@Component
public class NearbyActivityHelper {
	
	private NearbyActivityService nearbyActivityService;
	
	public NearbyActivityService getNearbyActivityService() {
		return nearbyActivityService;
	}

	@Autowired
	public void setNearbyActivityService(NearbyActivityService nearbyActivityService) {
		this.nearbyActivityService = nearbyActivityService;
	}


	public NearbyListModel getNearbyActivity(float xPoint,float yPoint,int listid){
		//getNearbyActivity
		ArrayList slist = (ArrayList)this.getNearbyActivityService().getAllActivity(xPoint,yPoint,listid);
		if(slist==null)
    		return null;
		
		NearbyListModel nearbyListModel = new NearbyListModel();
		List<ActivityInfoModel> nearbyActivityList = new ArrayList<ActivityInfoModel>();
		
		 
		Iterator iterator = slist.iterator();  
		while (iterator.hasNext()) {   
			ActivityInfoModel activityInfoModel = new ActivityInfoModel();
			
			Object[] o = (Object[]) iterator.next();   
			Activity activity = (Activity) o[0];   
			User user = (User) o[1];   
			Cinema cinema = (Cinema) o[2];
			
			activityInfoModel.setId(activity.getId());
			activityInfoModel.setPartnerGentle(activity.getGentle());
			activityInfoModel.setStyle(activity.getStyle());
			activityInfoModel.setExpectation(activity.getExpectation());
			activityInfoModel.setStartTime(activity.getStarttime());
			
			activityInfoModel.setLaunchUserId(user.getId());
			activityInfoModel.setPhotoUrl(user.getPhoto());
			activityInfoModel.setName(user.getName());
			activityInfoModel.setGentle(user.getGentle());
			//count the age
			//activityInfoModel.setAge(activity.get);
			activityInfoModel.setTag(user.getTag());
			
			activityInfoModel.setCinemaId(cinema.getId());
			activityInfoModel.setCinemaName(cinema.getName());
			activityInfoModel.setCinemaAddress(cinema.getAddress());
			//count the distance
			//activityInfoModel.setDistance(distance);
			
			activityInfoModel.setFilmId(activity.getFilmId());
			
			//调用聚合接口，取得影片信息
			//that is ok
			nearbyActivityList.add(activityInfoModel);
		}
		
		nearbyListModel.setNearbylist(nearbyActivityList);
    	return nearbyListModel;
    }
	
	//
	public FilmModel getSomeFilm(String filmId){
		String movieid = "137724";//参数
		String url = "http://v.juhe.cn/movie/query?key=";//url为请求的api接口地址
	    String key= "a1f06bc326d0728cf68296396df57d2b";//申请的对应key
		String urlAll = new StringBuffer(url).append(key).append("&movieid=").append(movieid).toString(); 
		String charset ="UTF-8";
		
		String jsonResult = get(urlAll, charset);//得到JSON字符串
	
		JSONObject object = JSONObject.fromObject(jsonResult);//转化为JSON类
		String code = object.getString("error_code");//得到错误码
		//错误码判断
		if(code.equals("0")){
			//根据需要取得数据
			JSONObject jsonObject =  (JSONObject)object.getJSONArray("result").get(0);
			System.out.println(jsonObject.getJSONObject("citynow").get("AQI"));
		}else{
			System.out.println("error_code:"+code+",reason:"+object.getString("reason"));
		}
		
	}
/**
 * 
 * @param urlAll:请求接口
 * @param charset:字符编码
 * @return 返回json结果
 */
public static String get(String urlAll,String charset){
	   BufferedReader reader = null;
	   String result = null;
	   StringBuffer sbf = new StringBuffer();
	   String userAgent = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";//模拟浏览器
	   try {
		   URL url = new URL(urlAll);
		   HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		   connection.setRequestMethod("GET");
		   connection.setReadTimeout(30000);
		   connection.setConnectTimeout(30000);
		   connection.setRequestProperty("User-agent",userAgent);
		   connection.connect();
		   InputStream is = connection.getInputStream();
		   reader = new BufferedReader(new InputStreamReader(
					is, charset));
			String strRead = null;
			while ((strRead = reader.readLine()) != null) {
				sbf.append(strRead);
				sbf.append("\r\n");
			}
			reader.close();
			result = sbf.toString();
		   
	   } catch (Exception e) {
		e.printStackTrace();
	   }
	   return result;
	}


}
