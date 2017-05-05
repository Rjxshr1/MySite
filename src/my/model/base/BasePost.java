package my.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BasePost<M extends BasePost<M>> extends Model<M> implements IBean {

	public void setId(java.lang.Integer id) {
		set("id", id);
	}

	public java.lang.Integer getId() {
		return get("id");
	}

	public void setTitle(java.lang.String title) {
		set("title", title);
	}

	public java.lang.String getTitle() {
		return get("title");
	}

	public void setContent(java.lang.String content) {
		set("content", content);
	}

	public java.lang.String getContent() {
		return get("content");
	}

	public void setCategoryId(java.lang.Integer categoryId) {
		set("category_id", categoryId);
	}

	public java.lang.Integer getCategoryId() {
		return get("category_id");
	}

	public void setAuthorId(java.lang.Integer authorId) {
		set("author_id", authorId);
	}

	public java.lang.Integer getAuthorId() {
		return get("author_id");
	}

	public void setPubdate(java.util.Date pubdate) {
		set("pubdate", pubdate);
	}

	public java.util.Date getPubdate() {
		return get("pubdate");
	}

}