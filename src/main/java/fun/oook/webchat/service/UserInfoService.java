package fun.oook.webchat.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import fun.oook.webchat.model.UserInfo;
import fun.oook.webchat.mapper.UserInfoMapper;

import java.util.List;

/**
 * @author ZhouYu
 */
@Service
public class UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;


    public int deleteByPrimaryKey(Long id) {
        return userInfoMapper.deleteByPrimaryKey(id);
    }


    public int insert(UserInfo record) {
        return userInfoMapper.insert(record);
    }


    public int insertSelective(UserInfo record) {
        return userInfoMapper.insertSelective(record);
    }


    public UserInfo selectByPrimaryKey(Long id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }

    public List<UserInfo> selectAll() {
        return userInfoMapper.selectAll();
    }

    public int updateByPrimaryKeySelective(UserInfo record) {
        return userInfoMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(UserInfo record) {
        return userInfoMapper.updateByPrimaryKey(record);
    }

    public UserInfo select(final UserInfo record) {
        final List<UserInfo> userInfos = userInfoMapper.select(record);
        // TODO x
        return userInfos.get(0);
    }
}

