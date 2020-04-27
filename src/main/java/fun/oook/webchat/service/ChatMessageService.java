package fun.oook.webchat.service;

import fun.oook.webchat.mapper.ChatMessageMapper;
import fun.oook.webchat.model.ChatMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ChatMessageService {

    @Resource
    private ChatMessageMapper chatMessageMapper;


    public int deleteByPrimaryKey(Long id) {
        return chatMessageMapper.deleteByPrimaryKey(id);
    }


    public int insert(ChatMessage record) {
        return chatMessageMapper.insert(record);
    }


    public int insertSelective(ChatMessage record) {
        return chatMessageMapper.insertSelective(record);
    }


    public ChatMessage selectByPrimaryKey(Long id) {
        return chatMessageMapper.selectByPrimaryKey(id);
    }


    public int updateByPrimaryKeySelective(ChatMessage record) {
        return chatMessageMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(ChatMessage record) {
        return chatMessageMapper.updateByPrimaryKey(record);
    }

}

