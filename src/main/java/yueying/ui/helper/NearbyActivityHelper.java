package yueying.ui.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import yueying.ui.model.FilmModel;
import yueying.ui.model.NearbyListModel;
import yueying.util.CalenderProcess;
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

	public JuheConfiguration getJuheConfiguration(){
		return juheConfiguration;
	}
	@Autowired
	public void setJuheConfiguration(JuheConfiguration juheConfiguration) {
		this.juheConfiguration=juheConfiguration;
	}
	
	
	public NearbyListModel getNearbyActivity(double xPoint,double yPoint,int listid){
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
			
			//获得当前活动报名人数和收藏人数
			long activityId = activity.getId();
			ArrayList applyCountList = (ArrayList)getNearbyActivityService().getCount(activityId, 1);
			int applyCount = 0;
			Iterator iterator2 = applyCountList.iterator();
			while(iterator2.hasNext()){
				Long object =(Long)iterator2.next();
				applyCount = object.intValue(); 
			}
			
			System.out.println(UUID.randomUUID().toString() );
			
			
			System.out.println(applyCount);
		
			/*
			Object collectCountObject = o[4];
			
			*/
			//System.out.println("applycount:" + applyCountObject);
			
			activityInfoModel.setId(activity.getId());
			System.out.println(activity.getId());
			activityInfoModel.setPartnerGentle(activity.getGentle());
			activityInfoModel.setStyle(activity.getStyle());
			activityInfoModel.setExpectation(activity.getExpectation());
			//transfer timestamp to string
			activityInfoModel.setStartTime(CalenderProcess.transferTimestampToString(activity.getStarttime(),"yyyy-MM-dd HH:mm:ss"));
			
			activityInfoModel.setLaunchUserId(user.getId());
			activityInfoModel.setPhotoUrl(user.getPhoto());
			activityInfoModel.setName(user.getName());
			activityInfoModel.setGentle(user.getGentle());
			//count the age
			try {
				if(user.getBirthday() != null)	
					activityInfoModel.setAge(CalenderProcess.getCurrentAgeByBirthdate(user.getBirthday()));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
			/*
			System.out.println(runtime);
			System.out.println(runtime.equals("\"null\""));
			*/
			if(runtime != null && !runtime.equals("\"null\"") && runtime.length() != 0){
				fm.setPlayMinutes(Integer.parseInt(runtime));
			}				
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
			Integer releaseDate = new Integer(jsonObject.getInt("release_date"));
			Date dt=sdf.parse(releaseDate.toString());
			SimpleDateFormat sdfother=new SimpleDateFormat("yyyy-MM-dd");
			String showTime = sdfother.format(dt);
			fm.setShowTime(showTime); 
			
			String rating = jsonObject.getString("rating");
			if(!rating.equals("\"null\"") && rating != null && rating.length() != 0)
				fm.setScore(Float.parseFloat(rating));
			
			fm.setPhotoUrl(jsonObject.getString("poster"));
					
			return fm;
		}else{
			System.out.println("error_code:"+code+",reason:"+object.getString("reason"));
		}
		return null;
		
	}

}
