package fun.oook.webchat.mapper;

import com.github.javafaker.Faker;
import fun.oook.webchat.model.UserInfo;
import fun.oook.webchat.util.IdUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

class UserInfoMapperTest {
    private SqlSession session;
    private UserInfoMapper mapper;
    private Faker faker;

    @BeforeEach
    void setUp() throws IOException {
        final String resource = "config/mybatis-config.xml";
        final InputStream input = Resources.getResourceAsStream(resource);
        final SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(input);
        session = sessionFactory.openSession();
        mapper = session.getMapper(UserInfoMapper.class);
        faker = new Faker(Locale.CHINA);
    }

    @AfterEach
    void tearDown() {
        if (session != null) {
            session.close();
        }
    }


    @Test
    void deleteByPrimaryKey() {
    }

    private UserInfo fakeUserInfo() {
        return UserInfo.builder()
                .id(Long.valueOf(IdUtils.longNumericId()))
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

        session.commit();
    }

    @Test
    void insertSelective() {
        final UserInfo record = fakeUserInfo();
        mapper.insertSelective(record);

        session.commit();
    }

    @Test
    void selectByPrimaryKey() {
        final UserInfo userInfo = mapper.selectByPrimaryKey(1L);
    }

    @Test
    void updateByPrimaryKeySelective() {

        session.commit();
    }

    @Test
    void updateByPrimaryKey() {

        session.commit();
    }

    @Test
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
