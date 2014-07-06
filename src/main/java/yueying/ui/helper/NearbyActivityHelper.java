package yueying.ui.helper;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import yueying.dto.entity.Activity;
import yueying.dto.entity.Cinema;
import yueying.dto.entity.User;
import yueying.service.NearbyActivityService;
import yueying.ui.model.ActivityInfoModel;
import yueying.ui.model.FilmModel;
import yueying.ui.model.NearbyListModel;
import yueying.util.JuheConfiguration;
import yueying.util.JuheHelper;

@Component
public class NearbyActivityHelper {
	
	private NearbyActivityService nearbyActivityService;
	private JuheConfiguration juheConfiguration;
	
	public NearbyActivityService getNearbyActivityService() {
		return nearbyActivityService;
	}

	@Autowired
	public void setNearbyActivityService(NearbyActivityService nearbyActivityService) {
		this.nearbyActivityService = nearbyActivityService;
	}

	private JuheConfiguration getJuheConfiguration(){
		return juheConfiguration;
	}
	@Autowired
	private void setJuheConfiguration(JuheConfiguration juheConfiguration) {
		this.juheConfiguration=juheConfiguration;
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
			
			String filmId = "137724";
			activityInfoModel.setFilmId(filmId);
			try {
				//获取聚合json数据
				FilmModel fm = getSomeFilm(filmId);
				
				activityInfoModel.setFilmName(fm.getName());
				activityInfoModel.setFilmType(fm.getType());
				activityInfoModel.setCountry(fm.getCountry());
				activityInfoModel.setScore(fm.getScore());
				activityInfoModel.setPlayMinutes(fm.getPlayMinutes());
				activityInfoModel.setShowTime(fm.getShowTime());
				activityInfoModel.setFilmUrl(fm.getPhotoUrl());
				
				System.out.println("poster" + fm.getPhotoUrl());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			nearbyActivityList.add(activityInfoModel);
		}
		
		nearbyListModel.setNearbylist(nearbyActivityList);
    	return nearbyListModel;
    }
	
	//
	public FilmModel getSomeFilm(String movieid) throws ParseException{
		//String movieid = "137724";//参数
		String url = this.getJuheConfiguration().getProperty(JuheConfiguration.QUERY_MOVIE_URL);//url为请求的api接口地址
	    String key= this.getJuheConfiguration().getProperty(JuheConfiguration.KEY);//申请的对应key
		String urlAll = new StringBuffer(url).append("?key=").append(key).append("&movieid=").append(movieid).toString(); 
		String charset ="UTF-8";
		
		String jsonResult = JuheHelper.get(urlAll, charset);//得到JSON字符串
	
		JSONObject object = JSONObject.fromObject(jsonResult);//转化为JSON类
		String code = object.getString("error_code");//得到错误码
		//错误码判断
		if(code.equals("0")){
			//根据需要取得数据
			System.out.println("get the data");
			
			FilmModel fm = new FilmModel();
			JSONObject jsonObject =  (JSONObject)object.getJSONObject("result");
			
			fm.setId(jsonObject.getString("movieid"));
			fm.setName(jsonObject.getString("title"));
			fm.setType(jsonObject.getString("genres"));
			fm.setCountry(jsonObject.getString("country"));
			String runtime = jsonObject.getString("runtime");
			System.out.println(runtime);
			System.out.println(runtime.length());
			
			if(!runtime.equals("null") && runtime != null && runtime.length() != 0){
				System.out.println("error!");
				fm.setPlayMinutes(Integer.parseInt(runtime));
			}
				
			System.out.println(jsonObject.getInt("release_date"));
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
			Integer release_date = new Integer(jsonObject.getInt("release_date"));
			Date dt=sdf.parse(release_date.toString());
			fm.setShowTime(dt); 
			
			String rating = jsonObject.getString("rating");
			if(!rating.isEmpty())
				fm.setScore(Float.parseFloat(rating));
			
			fm.setPhotoUrl(jsonObject.getString("poster"));
			
			System.out.println("runtime:" + jsonObject.getString("runtime"));
			
			return fm;
		}else{
			System.out.println("error_code:"+code+",reason:"+object.getString("reason"));
		}
		return null;
		
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
