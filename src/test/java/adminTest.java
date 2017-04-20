
import com.chinesepw.controller.AdminController;
import com.chinesepw.po.Admin;

public class adminTest {

	public static void main(String[] args) {
		
		AdminController adminController = new AdminController();
		
		Admin admin = new Admin();
		admin.setName("hjw");
		admin.setPwd("123");
		
		int test = adminController.insertSelective(admin);
		System.out.println("是否成功？  ==="+test);
		
	}

}
