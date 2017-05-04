package my.controller;

import com.jfinal.core.Controller;
import my.service.CategoryService;

/**
 * Created by Administrator on 2017/4/20 0020.
 */
public class CategoryController extends Controller {

    private static CategoryService categoryService = new CategoryService();

    public void index() {
        list();
    }


    public void list() {

    }
}
