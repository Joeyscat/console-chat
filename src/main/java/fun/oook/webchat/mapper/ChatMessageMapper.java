package fun.oook.webchat.mapper;

import fun.oook.webchat.model.ChatMessage;
import org.apache.ibatis.annotations.Mapper;import java.util.List;

@Mapper
public interface ChatMessageMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ChatMessage record);

    int insertSelective(ChatMessage record);

    ChatMessage selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ChatMessage record);

    int updateByPrimaryKey(ChatMessage record);

    List<ChatMessage> selectAll();
}