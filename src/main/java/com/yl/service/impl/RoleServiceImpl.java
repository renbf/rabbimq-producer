package com.yl.service.impl;


import com.yl.dao.RoleDao;
import com.yl.modle.Role;
import com.yl.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * @author rbf
 * @createdate 2018/12/20 06:59
 * @desriction
 */
@Service
public class RoleServiceImpl implements IRoleService{

	@Autowired
	private RoleDao roleDao;

	public List<Role> queryRoleAll(){
        return roleDao.queryRoleAll();
	}
}
