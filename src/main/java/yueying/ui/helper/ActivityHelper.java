package yueying.ui.helper;

import java.util.Properties;
import java.util.UUID;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



import yueying.service.ActivityService;
import yueying.ui.model.ActivityModel;
import yueying.ui.model.FilmModel;
import yueying.ui.model.LocationModel;
import yueying.ui.model.SaveActivityModel;
import yueying.util.CityConfiguration;
import yueying.util.JuheConfiguration;
import yueying.util.JuheHelper;
@Component
public class ActivityHelper {
	private ActivityService activityService;
	public ActivityService getActivityService() {
		return activityService;
	}

	@Autowired
	public void setActivityService(ActivityService activityService) {
		this.activityService = activityService;
	}
	
	private JuheConfiguration juheConfiguration;
	private JuheConfiguration getJuheConfiguration(){
		return juheConfiguration;
	}
	@Autowired
	private void setJuheConfiguration(JuheConfiguration juheConfiguration) {
		this.juheConfiguration=juheConfiguration;
	}
	
	private CityConfiguration cityConfiguration;
	private CityConfiguration getCityConfiguration(){
		return cityConfiguration;
	}
	@Autowired
	private void setCityConfiguration(CityConfiguration cityConfiguration) {
		this.cityConfiguration=cityConfiguration;
		
	}
	public SaveActivityModel saveActivity(UUID activityId,ActivityModel activityModel,
			long userId) {
		/*Activity activity=new Activity();
		activity.setId(activityModel.getId());
		activity.setFilmId(activityModel.getFilmId());
		activity.setCinemaId(activityModel.getCinemaId());
		activity.setGentle(activityModel.getGentle());
		activity.setPay(activityModel.getPay());
		activity.setTime(activityModel.getTime());
		activity.setUser(null);*/
		boolean success=false;
		if(userId!=activityModel.getLaunchUserId())
			success=false;
		else{
			success=this.getActivityService().saveActivity(activityId,activityModel,userId);
		}
		SaveActivityModel saveActivityModel=new SaveActivityModel();
		saveActivityModel.setSuccess(success);
		if(success){
			saveActivityModel.setRes(activityId);
		}
		return saveActivityModel;
	}

	public FilmModel getFilm(LocationModel locationModel) {
		String cityName = locationModel.getPlace();//参数
		String url = this.getJuheConfiguration().getProperty(JuheConfiguration.SHOW_FILM_URL);//url为请求的api接口地址
	    String key= this.getJuheConfiguration().getProperty(JuheConfiguration.KEY);//申请的对应key
	    Properties cityNTI= this.getCityConfiguration().getProperties();
	    String cityId=cityNTI.getProperty(cityName);
		String urlAll = new StringBuffer(url).append("?key=").append(key).append("&cityid=").append(cityId).toString(); 
		String charset ="UTF-8";
		String jsonResult = JuheHelper.get(urlAll, charset);//得到JSON字符串
		JSONObject object = JSONObject.fromObject(jsonResult);//转化为JSON类
		String code = object.getString("error_code");//得到错误码
		//错误码判断
		if(code.equals("0")){
			//根据需要取得数据
			JSONObject jsonObject =  (JSONObject)object.getJSONArray("result").get(0);
			//System.out.println(jsonObject.getJSONObject("citynow").get("AQI"));
		}else{
			System.out.println("error_code:"+code+",reason:"+object.getString("reason"));
		}
		return null;
	}


	

}
