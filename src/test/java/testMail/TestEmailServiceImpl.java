package testMail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import onlineShop.mail.EmailServiceImpl;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestEmailConfig.class)
public class TestEmailServiceImpl {

	@Autowired
	private EmailServiceImpl emailServiceImpl;
	
	@Test
	public void test() {
		emailServiceImpl.sendInvoice("YJianghong@gmail.com", "invoice", "you have a new order");
	}
}
