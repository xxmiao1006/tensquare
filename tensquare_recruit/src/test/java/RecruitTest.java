import com.tensquare.recruit.RecruitApplication;
import com.tensquare.recruit.dto.EnterpriseDTO;
import com.tensquare.recruit.dao.EnterpriseDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RecruitApplication.class)
public class RecruitTest {

    @Autowired
    private EnterpriseDao enterpriseDao;

    @Test
    public void test() {
        /*List<Enterprise> enterprises =  enterpriseDao.findByIshot("1");
        System.out.println(enterprises.size());*/
        Collection<EnterpriseDTO> enterprises = enterpriseDao.findByNameIsLike("%传智%",EnterpriseDTO.class);
        System.out.println(enterprises);
    }

}
