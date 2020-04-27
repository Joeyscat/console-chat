package fun.oook.webchat.mapper;

import fun.oook.webchat.model.UserPass;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserPassMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserPass record);

    int insertSelective(UserPass record);

    UserPass selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserPass record);

    int updateByPrimaryKey(UserPass record);
}