package main.java.model.like;

import main.java.model.product.BeansDO;
import main.java.model.service.LikeService;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

public class LikeTest {

    LikeService likeService = new LikeService();

    @Test
    public void insertLikeTest() throws SQLException {

        likeService.clickLike("kilee@naver.com", 0);

        ArrayList<BeansDO> likeList = likeService.getLikeList("kilee@naver.com");
        for (BeansDO e : likeList) {
            String beanName = e.getBeanName();
            int likeCount = e.getLikeCount();
            String beanImg = e.getBeanImg();
            int beanPrice = e.getBeanPrice();

            assertThat(beanName).isEqualTo("코스타리카산");
            assertThat(likeCount).isEqualTo(0);
            assertThat(beanImg).isEqualTo("url-주소");
            assertThat(beanPrice).isEqualTo(9999);
        }
    }
}




