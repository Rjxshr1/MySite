package my.service;

import com.anna.config.Ioc.Service;
import com.jfinal.plugin.activerecord.ActiveRecordException;
import my.model.Message;

import java.util.List;

/**
 * Created by Administrator on 2017/4/20 0020.
 */
@Service
public class MessageService {
    public static final Message dao = Message.dao;

    public List<Message> getAllMessages() {
        return dao.find("SELECT * FROM message");
    }

    public Message getById(int messageId) {
        return dao.findById(messageId);
    }

    public void paginate(int pageNumber, int pageSize) {
        dao.paginate(pageNumber, pageSize, "SELECT *",
                "FROM message");
    }

    public void save(Message message) throws ServiceException {
        try {
            message.save();
        } catch (ActiveRecordException ex) {
            throw new ServiceException(ex.toString());
        }
    }

    public void update(Message message) throws ServiceException {
        try {
            message.save();
        } catch (ActiveRecordException ex) {
            throw new ServiceException(ex.toString());
        }
    }
}
