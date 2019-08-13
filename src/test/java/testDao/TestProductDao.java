package testDao;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import onlineShop.dao.ProductDao;
import onlineShop.model.Product;
import onlineShop.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=TestConfiguration.class,
                      loader=AnnotationConfigContextLoader.class)
public class TestProductDao {
	
	@Autowired
	ProductDao productDao;
	@Test
	public void testGetProductById() {
		Product product = new Product();
		product.setProductPrice(2.5);
		product.setProductName("Orange");
		productDao.addProduct(product);
		assertThat(productDao.getProductById(product.getId())).isEqualTo(product);		
	}
	


}
