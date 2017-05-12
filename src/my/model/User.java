package my.model;

import my.model.base.BaseUser;

import java.util.List;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class User extends BaseUser<User> {
	public static final User dao = new User().dao();

	public List<Message> getMyMessages(){
		return Message.dao.find("select * from message where user_id = ?", getId());
	}
}
