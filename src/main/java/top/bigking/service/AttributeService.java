package top.bigking.service;

import top.bigking.entity.Attribute;

/**
 * @Author ABKing
 * @since 2020/4/13 下午10:02
 **/
public interface AttributeService {
    /**
     * 参数列表
     */
    Attribute queryByCategoryId(Integer categoryId);

    /**
     * 添加参数
     */
    Integer addAttribute(Attribute attribute);

    /**
     * 删除参数
     */
    Integer deleteById(Integer id);

    /**
     * 根据ID查询参数
     */
    Attribute queryById(Integer id);

    /**
     * 编辑提交参数（修改Attribute）
     */
    Integer updateAttribute(Attribute attribute);
}
