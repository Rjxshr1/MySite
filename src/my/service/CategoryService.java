package my.service;

import com.jfinal.plugin.activerecord.ActiveRecordException;
import my.model.Category;

import java.util.List;

/**
 * Created by Administrator on 2017/4/20 0020.
 */
public class CategoryService {
    public static final Category dao = Category.dao;
    public List<Category> getAllCategories(){
        return dao.find("SELECT * FROM category");
    }

    public Category getById(int categoryId){
        return dao.findById(categoryId);
    }

    public void paginate(int pageNumber, int pageSize){
        dao.paginate(pageNumber, pageSize, "SELECT *",
                "FROM CATEGORY");
    }

    public void save(Category category) throws ServiceException{
        try{
            category.save();
        }catch(ActiveRecordException ex){
            throw new ServiceException(ex.toString());
        }
    }

    public void update(Category category) throws ServiceException{
        try{
            category.save();
        }catch(ActiveRecordException ex){
            throw new ServiceException(ex.toString());
        }
    }
}
