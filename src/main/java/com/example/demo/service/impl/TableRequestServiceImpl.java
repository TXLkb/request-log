package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.TableRequestDao;
import com.example.demo.entity.TableRequest;
import com.example.demo.service.TableRequestService;
import org.springframework.stereotype.Service;

/**
 * (TableRequest)表服务实现类
 *
 * @author 旷彬
 * @since 2021-03-07 22:50:57
 */
@Service("tableRequestService")
public class TableRequestServiceImpl extends ServiceImpl<TableRequestDao, TableRequest> implements TableRequestService {

}
