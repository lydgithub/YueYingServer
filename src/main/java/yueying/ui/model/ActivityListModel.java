package yueying.ui.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonValue;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName(value = "mainuser")
public class ActivityListModel {
		private float point;
		@JsonValue
		public float getPoint() {
			return point;
		}

		public void setPoint(float point) {
			this.point = point;
		}
		
		
	

}
