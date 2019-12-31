package controller;

import model.dao.JDBCModel;
import model.vo.Employee;

public class TestMain {
	public static void main(String[] args) {
		JDBCModel model = new JDBCModel();
		// 占쎌읈筌ｏ옙 鈺곌퀬�돳
		//  model.testJDBC();
		
		// 占쎄텢甕곤옙 占쎌읈占쎈뼎占쎈릭占쎈연 鈺곌퀬�돳
		// model.testJDBC2(7499);
		
		// 揶쏆빘猿� 占쎄문占쎄쉐 占쎌뜎 占쎄땜占쎌뿯
//		 Employee emp = new Employee(7777, "JARON", "ANALYST", 9999, 12000 ,99, 10);
//		 new JDBCModel().testInsert(emp);
		
		
		// 占쎄땜占쎌뿯占쎈립 占쎈뻬 鈺곌퀬�돳
		// model.testJDBC2(7777);
		
		// 揶쏆빘猿� 占쎄문占쎄쉐 占쎌뜎 占쎈땾占쎌젟
//		 Employee e = new Employee(7777, "chairman", 5000000, 1000000);
//		 model.testUpdate(e);
		
		// 占쎈씜占쎈쑓占쎌뵠占쎈뱜 占쎌뜎 占쎌읈筌ｏ옙 鈺곌퀬�돳
		// model.testJDBC();
		
		// 占쎄텢甕곤옙 占쎌읈占쎈뼎 占쎌뜎 占쎄텣占쎌젫
//		model.testDelete(7777);
		
		// 占쎄텣占쎌젫 占쎌뜎 占쎌읈筌ｋ똻�쒙옙�돳
//		model.testJDBC();
	}
}
