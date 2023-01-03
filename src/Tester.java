import java.time.LocalDateTime;

public class Tester {

	public static void main(String[] args) {
//		 TODO Auto-generated method stub
		
		
		System.out.println("Hello Worlds");
		LocalDateTime localTime = java.time.LocalDateTime.now();
		
		String time = Integer.toString(localTime.getDayOfMonth());
		time += "/" + Integer.toString(localTime.getMonthValue());
		time += "/" + Integer.toString(localTime.getYear());
		
		time += " " + Integer.toString(localTime.getHour());
		time += ":" + Integer.toString(localTime.getMinute());
		
		System.out.println(time);
		
		

	}

}
