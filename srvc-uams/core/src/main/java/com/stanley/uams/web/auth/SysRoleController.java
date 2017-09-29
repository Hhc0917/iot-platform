package com.stanley.uams.web.auth;

import com.stanley.common.domain.SearchParam;
import com.stanley.common.domain.mybatis.Page;
import com.stanley.common.spring.BaseController;
import com.stanley.uams.domain.auth.SysRole;
import com.stanley.uams.domain.auth.SysRoleVO;
import com.stanley.uams.service.auth.SysRoleService;
import com.stanley.utils.ExcelUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 角色管理
 * @Description
 * @date 2016-04-08
 * @since 1.0 
 * @version 1.0  
 * @author 13346450@qq.com 童晟
 */
@RestController
@RequestMapping("/system/role/*")
public class SysRoleController extends BaseController {

	@Resource
	private SysRoleService sysRoleService;

	/**
	 * 新增保存
	 * @param sysRole
	 * @author 13346450@qq.com 童晟
	 * @date 2016-04-08
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	@RequiresPermissions("system:SysRole:insert")
	public String insert(SysRole sysRole){
		return sysRoleService.insert(sysRole);
	}
	
	/**
	 * 删除单条
	 * @param idKey
	 * @author 13346450@qq.com 童晟
	 * @date 2016-04-08
	 */
	@RequestMapping(value="delete/{idKey}")
	@RequiresPermissions("system:SysRole:delete")
	public String delete(@PathVariable Integer idKey){
		return sysRoleService.delete(idKey);
	}

	/**
	 * 批量删除
	* @author 13346450@qq.com 童晟
	 * @date 2016-04-08
	 */
	@RequestMapping(value="deleteBatch")
	@RequiresPermissions("system:SysRole:delete")
	public String deleteBatch(SearchParam searchParam){
		return sysRoleService.deleteBatch(searchParam.getCheckedIds());
	}

	/**
	 * 修改保存
	 * @author 13346450@qq.com 童晟
	 * @date 2016-04-08
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	@RequiresPermissions("system:SysRole:update")
	public String update(SysRole sysRole){
		return sysRoleService.update(sysRole);
	}

	/**
	 * 分页查询
	 * @param searchParam
	 * @return
	 * @author 13346450@qq.com 童晟
	 * @date 2016-04-08
	 */
	@RequestMapping(value = "listPage")
	@RequiresPermissions("system:SysRole:select")
	public Page<SysRoleVO> listPage(SearchParam searchParam){
		return sysRoleService.selectPage(searchParam);
	}
	
	/**
	 * 导出excel
	 * @param response
	 * @param searchParam
	 * return
	 * @author 13346450@qq.com 童晟
	 * @date 2016-04-08
	 */
	@RequestMapping(value = "toExcel")
	@RequiresPermissions("system:SysRole:select")
	public void toExcel(HttpServletResponse response, SearchParam searchParam){
		ExcelUtil.outputExcel(response, "角色数据", sysRoleService.toExcel(searchParam));
	}
	
	/**
	 * 查询所有角色
	 * @return
	 * @author 13346450@qq.com 童晟 
	 * @date 2016年4月8日
	 */
	@RequestMapping(value = "listAll")
	public List<SysRole> listAll(){
		return sysRoleService.selectAllBySelective(null);
	}
	
	/**
	 * 检查用户名是否已存在
	 * @param sysRole
	 * @author 13346450@qq.com 童晟
	 * @date 2016-04-08
	 */
	@RequestMapping(value = "validate", method = RequestMethod.GET)
	@RequiresPermissions("system:SysRole:select")
	public String validate(SysRole sysRole){
		return sysRoleService.validate(sysRole);
	}

}
