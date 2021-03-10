package com.example.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.TableRequest;
import com.example.demo.service.TableRequestService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (TableRequest)表控制层
 *
 * @author 旷彬
 * @since 2021-03-07 22:50:57
 */
@RestController
@RequestMapping("tableRequest")
public class TableRequestController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private TableRequestService tableRequestService;

    /**
     * 分页查询所有数据
     *
     * @param page         分页对象
     * @param tableRequest 查询实体
     * @return 所有数据
     */
    @PostMapping("/selectAll")
    public R selectAll(@RequestBody Page<TableRequest> page, TableRequest tableRequest) {
        return success(this.tableRequestService.page(page, new QueryWrapper<>(tableRequest)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.tableRequestService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param tableRequest 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody TableRequest tableRequest) {
        return success(this.tableRequestService.save(tableRequest));
    }

    /**
     * 修改数据
     *
     * @param tableRequest 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody TableRequest tableRequest) {
        return success(this.tableRequestService.updateById(tableRequest));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.tableRequestService.removeByIds(idList));
    }
}
