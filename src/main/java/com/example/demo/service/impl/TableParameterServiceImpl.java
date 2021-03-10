package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.TableParameterDao;
import com.example.demo.entity.TableParameter;
import com.example.demo.service.TableParameterService;
import org.springframework.stereotype.Service;

/**
 * (TableParameter)表服务实现类
 *
 * @author 旷彬
 * @since 2021-03-07 22:50:55
 */
@Service("tableParameterService")
public class TableParameterServiceImpl extends ServiceImpl<TableParameterDao, TableParameter> implements TableParameterService {

}
