package my.controller;

import com.jfinal.core.Controller;
import com.jfinal.kit.LogKit;
import my.model.Category;
import my.service.CategoryService;
import my.service.ServiceException;

import java.util.List;

/**
 * Created by Administrator on 2017/4/20 0020.
 */
public class CategoryController extends Controller {

    private static CategoryService categoryService = new CategoryService();

    public void index() {
        list();
    }


    public void list() {
        List<Category> categories = categoryService.getAllCategories();
        setAttr("categories", categories);
        renderFreeMarker("category-list.ftl");
    }

    public void save() {
        Category category = getModel(Category.class, true);
        try {
            categoryService.save(category);
        } catch (ServiceException ex) {
            LogKit.error("添加分类失败:" + ex.getMessage());
            redirect("/admin/category/list?errorMsg=添加分类失败");
        }
        redirect("/admin/category/list");
    }
}
