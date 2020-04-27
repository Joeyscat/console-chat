package fun.oook.webchat.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import fun.oook.webchat.model.UserPass;
import fun.oook.webchat.mapper.UserPassMapper;

/**
 * @author ZhouYu
 */
@Service
public class UserPassService {

    @Resource
    private UserPassMapper userPassMapper;


    public int deleteByPrimaryKey(Long id) {
        return userPassMapper.deleteByPrimaryKey(id);
    }


    public int insert(UserPass record) {
        return userPassMapper.insert(record);
    }


    public int insertSelective(UserPass record) {
        return userPassMapper.insertSelective(record);
    }


    public UserPass selectByPrimaryKey(Long id) {
        return userPassMapper.selectByPrimaryKey(id);
    }


    public int updateByPrimaryKeySelective(UserPass record) {
        return userPassMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(UserPass record) {
        return userPassMapper.updateByPrimaryKey(record);
    }

}

