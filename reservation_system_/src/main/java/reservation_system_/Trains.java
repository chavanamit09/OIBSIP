package reservation_system_;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Trains {
	@Id
	int trainNo;
	String trainName;
	public int getTrainNo() {
		return trainNo;
	}
	public void setTrainNo(int trainNo) {
		this.trainNo = trainNo;
	}
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	

}
