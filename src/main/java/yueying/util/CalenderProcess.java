package yueying.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalenderProcess {
	
	/**
	  * @author jerry.chen
	  * @param brithday
	  * @return
	  * @throws ParseException
	  *             �������ջ�ȡ����;
	  */
	 @SuppressWarnings("deprecation")
	public static int getCurrentAgeByBirthdate(Date brithday)throws ParseException, Exception 
	 {
	  try {
	   Calendar calendar = Calendar.getInstance();
	   SimpleDateFormat formatDate = new SimpleDateFormat("YYYY-MM-dd");
	   String currentTime = formatDate.format(calendar.getTime());
	   Date today = formatDate.parse(currentTime);
	   Date brithDay = brithday;
	 
	   return today.getYear() - brithDay.getYear();
	  } catch (Exception e) {
	   return 0;
	  }
	 }
	 
	 public static String transferTimestampToString(Timestamp time,String utf){
		 SimpleDateFormat df = new SimpleDateFormat(utf);//�����ʽ������ʾ����
		 String startTimeStr = df.format(time);
		 return startTimeStr;
	 }
	 
}
