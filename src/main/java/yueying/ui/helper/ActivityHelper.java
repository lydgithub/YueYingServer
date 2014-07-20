package yueying.ui.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



import yueying.service.ActivityService;
import yueying.ui.model.ActivityModel;
import yueying.ui.model.CinemaListModel;
import yueying.ui.model.CinemaModel;
import yueying.ui.model.FilmBriefListModel;
import yueying.ui.model.FilmBriefModel;
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
	public SaveActivityModel saveActivity(long activityId,ActivityModel activityModel,
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

	public FilmBriefListModel getFilm(String cityName) {
		//String cityName = locationModel.getPlace();//������������
		System.out.println(cityName);
		String url = this.getJuheConfiguration().getProperty(JuheConfiguration.SHOW_FILM_URL);//url�����������������api������������
	    String key= this.getJuheConfiguration().getProperty(JuheConfiguration.KEY);//�������������������key
	    Properties cityNTI= this.getCityConfiguration().getProperties();
	    String cityId=cityNTI.getProperty(cityName);
		String urlAll = new StringBuffer(url).append("?key=").append(key).append("&cityid=").append(cityId).toString(); 
		String charset ="UTF-8";
		
		String jsonResult = JuheHelper.get(urlAll, charset);//��������JSON��������
		
		JSONObject object = JSONObject.fromObject(jsonResult);//����������JSON������
		String code = object.getString("error_code");//��������������������������
		//��������������������������
		if(code.equals("0")){
			//����������������������������������
			JSONArray jsonArray =  (JSONArray)object.getJSONArray("result");
			FilmBriefListModel filmBriefListModel=new FilmBriefListModel();
			filmBriefListModel.setFilmBriefModels(new ArrayList<FilmBriefModel>());
			for(int i=0;i<jsonArray.size();i++){
				FilmBriefModel filmBriefModel=new FilmBriefModel();
				JSONObject jsonObject=jsonArray.getJSONObject(i);
				String idString=jsonObject.getString("movieId");
				filmBriefModel.setId(idString);
				String name=jsonObject.getString("movieName");
				filmBriefModel.setName(name);
				String picUrl=jsonObject.getString("pic_url");
				filmBriefModel.setpicUrl(picUrl);
				filmBriefListModel.getFilmBriefModels().add(filmBriefModel);
			}
			return filmBriefListModel;
		}else{
			System.out.println("error_code:"+code+",reason:"+object.getString("reason"));
			return null;
		}
		
	}

	public CinemaListModel getCinemas(double xPoint, double yPoint,
			String cityName, String movieId) {
		Map<String, Integer> cinemasIdMap=getCinemasIdByFilm(cityName,movieId);
		if(cinemasIdMap==null){
			return null;
		}
		return getCinemasByLocation(xPoint, yPoint, cityName, cinemasIdMap);
	}
	
	public CinemaListModel getCinemasByLocation(double xPoint,double yPoint,String cityName,Map<String, Integer> cinemasIdMap){
		String url = this.getJuheConfiguration().getProperty(JuheConfiguration.SHOW_CINEMA_BY_LOCATION_URL);//url�����������������api������������
	    String key= this.getJuheConfiguration().getProperty(JuheConfiguration.KEY);//�������������������key
	    
	    Properties cityNTI= this.getCityConfiguration().getProperties();
	    String cityId=cityNTI.getProperty(cityName);
	    //TODO
	    yPoint = 116.3393;
	    
		String urlAll = new StringBuffer(url).append("?key=").append(key).append("&dtype=json&lat=").append(xPoint).append("&lon=").append(yPoint).append("&radius=2000").toString(); 
		String charset ="UTF-8";
		String jsonResult = JuheHelper.get(urlAll, charset);//��������JSON��������
		JSONObject object = JSONObject.fromObject(jsonResult);//����������JSON������
		String code = object.getString("error_code");//��������������������������
		//��������������������������
		if(code.equals("0")){
			System.out.println(xPoint + " " + yPoint);
			//����������������������������������
			JSONArray jsonArray =  (JSONArray)object.getJSONArray("result");
			CinemaListModel cinemaListModel=new CinemaListModel();
			cinemaListModel.setCinemaModels(new ArrayList<CinemaModel>());
			
			System.out.println(jsonArray.size());
			for(int i=0;i<jsonArray.size();i++){
				
				JSONObject jsonObject=jsonArray.getJSONObject(i);
				
				String id=jsonObject.getString("id");
				System.out.println("cinemaid" + id);
				if (cinemasIdMap.containsKey(id)) {
					CinemaModel cinemaModel=new CinemaModel();
					cinemaModel.setId(id);
					String name = jsonObject.getString("cinemaName");
					cinemaModel.setName(name);
					String address = jsonObject.getString("address");
					cinemaModel.setAddress(address);
					String distance = jsonObject.getString("distance");
					cinemaModel.setDistance(distance);
					double lat = jsonObject.getDouble("latitude");
					cinemaModel.setLatitude(lat);
					double lon = jsonObject.getDouble("longitude");
					cinemaModel.setLogitude(lon);
					cinemaListModel.getCinemaModels().add(cinemaModel);
				}
			}
			return cinemaListModel;
		}else{
			System.out.println("error_code:"+code+",reason:"+object.getString("reason"));
			return null;
		}
	}
	public Map<String,Integer>  getCinemasIdByFilm(String cityName,String movieId){
		String url = this.getJuheConfiguration().getProperty(JuheConfiguration.SHOW_CINEMA_BY_FILM_URL);//url�����������������api������������
	    String key= this.getJuheConfiguration().getProperty(JuheConfiguration.KEY);//�������������������key
	    
	    Properties cityNTI= this.getCityConfiguration().getProperties();
	    String cityId=cityNTI.getProperty(cityName);
		String urlAll = new StringBuffer(url).append("?key=").append(key).append("&cityid=").append(cityId).append("&movieid=").append(movieId).toString(); 
		String charset ="UTF-8";
		
		String jsonResult = JuheHelper.get(urlAll, charset);//��������JSON��������
		JSONObject object = JSONObject.fromObject(jsonResult);//����������JSON������
		
		String code = object.getString("error_code");//��������������������������
		//��������������������������
		if(code.equals("0")){
			//����������������������������������
			JSONArray jsonArray =  (JSONArray)object.getJSONArray("result");
			Map<String, Integer> cinemasIdMap=new HashMap<String,Integer>();
			for(int i=0;i<jsonArray.size();i++){
				JSONObject jsonObject=jsonArray.getJSONObject(i);
				String id=jsonObject.getString("cinemaId");
				
				//System.out.println("byfilm" +id);
				
				cinemasIdMap.put(id, 1);
			}
			return cinemasIdMap;
		}else{
			System.out.println("error_code:"+code+",reason:"+object.getString("reason"));
			return null;
		}
	}
	
	public CinemaListModel getCinemasByFilm(String cityName,String movieId){
		System.out.println(cityName);
		String url = this.getJuheConfiguration().getProperty(JuheConfiguration.SHOW_CINEMA_BY_FILM_URL);//url�����������������api������������
	    String key= this.getJuheConfiguration().getProperty(JuheConfiguration.KEY);//�������������������key
	    Properties cityNTI= this.getCityConfiguration().getProperties();
	    String cityId=cityNTI.getProperty(cityName);
		String urlAll = new StringBuffer(url).append("?key=").append(key).append("&cityid=").append(cityId).append("&movieid=").append(movieId).toString(); 
		String charset ="UTF-8";
		String jsonResult = JuheHelper.get(urlAll, charset);//��������JSON��������
		JSONObject object = JSONObject.fromObject(jsonResult);//����������JSON������
		String code = object.getString("error_code");//��������������������������
		//��������������������������
		if(code.equals("0")){
			//����������������������������������
			JSONArray jsonArray =  (JSONArray)object.getJSONArray("result");
			CinemaListModel cinemaListModel=new CinemaListModel();
			cinemaListModel.setCinemaModels(new ArrayList<CinemaModel>());
			
			for(int i=0;i<jsonArray.size();i++){
				CinemaModel cinemaModel=new CinemaModel();
				JSONObject jsonObject=jsonArray.getJSONObject(i);
				String name=jsonObject.getString("cinemaName");
				cinemaModel.setName(name);
				String id=jsonObject.getString("cinemaId");
				cinemaModel.setId(id);
				String address=jsonObject.getString("address");
				cinemaModel.setAddress(address);
				cinemaListModel.getCinemaModels().add(cinemaModel);
			}
			return cinemaListModel;
		}else{
			System.out.println("error_code:"+code+",reason:"+object.getString("reason"));
			return null;
		}
	}
	
	//get the 

	

}
