package fun.oook.webchat.mapper;

import com.github.javafaker.Faker;
import fun.oook.webchat.model.UserInfo;
import fun.oook.webchat.util.IdUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@SpringBootTest
class UserInfoMapperTest {

    @Resource
    private UserInfoMapper mapper;
    private Faker faker;

    @BeforeEach
    void setUp() {
        faker = new Faker(Locale.CHINA);
    }


    @Test
    void deleteByPrimaryKey() {
    }

    private UserInfo fakeUserInfo() {
        return UserInfo.builder()
                .id(IdUtils.longNumericId())
                .nickname(faker.name().fullName())
                .avatar(faker.avatar().image())
                .email(faker.internet().emailAddress())
                .userCode(IdUtils.shortId())
                .build();
    }

    @Test
    void insert() {
        final UserInfo record = fakeUserInfo();
        mapper.insert(record);
    }

    @Test
    void insertSelective() {
        final UserInfo record = fakeUserInfo();
        mapper.insertSelective(record);
    }

    @Test
    void selectByPrimaryKey() {
        final UserInfo userInfo = mapper.selectByPrimaryKey(1L);
    }

    @Test
    void updateByPrimaryKeySelective() {

    }

    @Test
    void updateByPrimaryKey() {

    }

    @Test
    @Disabled
    void shortId() {
        final int times = 10000000;
        final Map<String, String> map = new HashMap<>(times);

        for (int i = 0; i < times; i++) {
//            final String s = RandomStringUtils.randomAlphabetic(8);
//            final String s = RandomStringUtils.randomAlphanumeric(8);
            final String s = RandomStringUtils.randomNumeric(20);
            map.put(s, "randomAlphabetic");
        }

        Assertions.assertEquals(times, map.size());
        System.out.println(map.size());
    }
}
