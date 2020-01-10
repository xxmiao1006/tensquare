import com.tensquare.recruit.RecruitApplication;
import com.tensquare.recruit.dao.EnterpriseDao;
import com.tensquare.recruit.dao.SpecificationFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RecruitApplication.class)
public class RecruitTest {

    @Autowired
    private EnterpriseDao enterpriseDao;

    @Test
    public void test() {
        List enterprises = null;
        /*List<Enterprise> enterprises =  enterpriseDao.findByIshot("1");
        System.out.println(enterprises.size());*/
        /*Collection<EnterpriseDTO> enterprises = enterpriseDao.findByNameIsLike("%传智%",EnterpriseDTO.class);*/

        enterprises = enterpriseDao.findAll(SpecificationFactory.containsLike("name","传智"));

        /*enterprises = enterpriseDao.findAll(SpecificationFactory.equal("coordinate","1019,2223"));*/

        /*enterprises = enterpriseDao.findAll(Specification.where(SpecificationFactory.containsLike("name","传智"))
                .and(SpecificationFactory.equal("coordinate","1019,2223")));*/

        System.out.println(enterprises);
    }

}
