package xml_TESTNG;
import utils.*;
public class read {

	public static void main(String[] args) {
		
		Excel_utils xl = new Excel_utils();
		
		String dat =xl.getCellData("Data", 3, 0);
		System.out.println(dat);
		System.out.println(xl.getColCount("Data"));
		System.out.println(xl.getRowCount("Data"));
		

	}

}
