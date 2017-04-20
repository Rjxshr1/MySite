package my.controller;

import com.jfinal.core.Controller;
import my.model.Category;
import my.service.CategoryService;

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
}
