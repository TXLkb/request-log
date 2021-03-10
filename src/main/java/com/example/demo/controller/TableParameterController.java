package com.example.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.TableParameter;
import com.example.demo.service.TableParameterService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (TableParameter)表控制层
 *
 * @author 旷彬
 * @since 2021-03-07 22:50:56
 */
@RestController
@RequestMapping("tableParameter")
public class TableParameterController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private TableParameterService tableParameterService;

    /**
     * 分页查询所有数据
     *
     * @param page           分页对象
     * @param tableParameter 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<TableParameter> page, TableParameter tableParameter) {
        return success(this.tableParameterService.page(page, new QueryWrapper<>(tableParameter)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.tableParameterService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param tableParameter 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody TableParameter tableParameter) {
        return success(this.tableParameterService.save(tableParameter));
    }

    /**
     * 修改数据
     *
     * @param tableParameter 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody TableParameter tableParameter) {
        return success(this.tableParameterService.updateById(tableParameter));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.tableParameterService.removeByIds(idList));
    }
}
