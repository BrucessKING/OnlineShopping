package top.bigking.service;

import com.github.pagehelper.PageInfo;
import top.bigking.entity.Category;


/**
 * @Author ABKing
 * @since 2020/4/13 下午9:46
 * 分类
 **/
public interface CategoryService {
    /**
     * 商品分类数据列表
     * 可选参数三个
     */
    PageInfo<Category> queryCategories(Integer catLevel, Integer pageNum, Integer pageSize);

    /**
     * 添加分类
     */
    Integer addCategory(Category category);

    /**
     * 根据ID查询分类
     */
    Category queryById(Integer id);

    /**
     * 编辑提交分类（修改分类）
     */
    Integer updateCategory(Category category);

    /**
     * 删除分类
     */
    Integer deleteById(Integer id);



}
