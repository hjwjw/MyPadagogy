package com.chinesepw.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinesepw.po.Apptype;
import com.chinesepw.po.TypeLev;
import com.chinesepw.service.ITypeService;
import com.chinesepw.util.Result;

/**
 * @author HJW
 * @date 2017年4月23日
 * 
 */
@Controller
@RequestMapping(value = "/type")
public class TypeController {

	@Autowired
	ITypeService iTypeService;

	/**
	 * 转发到类型管理页面(页面位于WEB-INF下不能直接访问)
	 * @return
	 */
	@RequestMapping(value = "/to", method = RequestMethod.GET)
	public String to() {
		return "/WEB-INF/manager/typeList";
	}

	/**
	 * 返回所有的类型记录
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/queryAll", method = RequestMethod.GET)
	public List<Apptype> query() {
		return iTypeService.query();
	}

	/*@ResponseBody
	@RequestMapping(value = "/queryTypeLev", method = RequestMethod.GET)
	public List<List<TypeLev>> queryAllTypeLev() {
		List<Apptype> apptypes = iTypeService.query();
		List<TypeLev> typeLevs = new ArrayList<TypeLev>();
		List<List<TypeLev>> AllTypeLev = new ArrayList<List<TypeLev>>();
		for (Apptype apptype : apptypes) {
			if (apptype.getParentId() == 0) {
				typeLevs = iTypeService.queryTypeLev(apptype.getTypeId());
				AllTypeLev.add(typeLevs);
			}
		}
		return AllTypeLev;
	}*/
	
	/**
	 * 返回zTree 格式的JSON数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/typeIteration", method = RequestMethod.GET)
	public List<Map<String, Object>> typeIteration() {
		
		List<Map<String, Object>> jsonStr = new ArrayList<Map<String, Object>>();
		List<Apptype> typeList = iTypeService.query();
		for (Apptype apptype : typeList) {
			Map<String, Object> jsonAttr = new HashMap<String, Object>();
			jsonAttr.put("id", apptype.getTypeId());
			jsonAttr.put("pId", apptype.getParentId());
			jsonAttr.put("name", apptype.getName());
			jsonStr.add(jsonAttr);
		}
		return jsonStr;
		
	}

	/*@ResponseBody
	@RequestMapping(value = "/queryTypeLev/{id}", method = RequestMethod.GET)
	public List<TypeLev> queryTypeLevByTypeId(@PathVariable("id") Integer typeId) {
		return iTypeService.queryTypeLev(typeId);
	}*/
	
	/**
	 * 根据typeid 删除指定对象。并把其它的的子分类一并删除
	 * @param typeId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
	public Result<Integer> deleteByPrimaryKey(@PathVariable("id") Integer typeId) {
		List<Apptype> nodes = iTypeService.selectByParentId(typeId);
		if (nodes.size() > 0) {
			for (Apptype apptype : nodes) {
				List<Apptype> nodes2 = iTypeService.selectByParentId(apptype.getTypeId());
				if (nodes2.size() > 0) {
					for (Apptype apptype2 : nodes2) {
						List<Apptype> nodes3 = iTypeService.selectByParentId(apptype2.getTypeId());
						if (nodes3.size() > 0) {
							for (Apptype apptype3 : nodes3) {
								iTypeService.deleteByPrimaryKey(apptype3.getTypeId());
								iTypeService.deleteByPrimaryKey(apptype2.getTypeId());
								iTypeService.deleteByPrimaryKey(apptype.getTypeId());
								iTypeService.deleteByPrimaryKey(typeId);
							}
						}else {
							iTypeService.deleteByPrimaryKey(apptype2.getTypeId());
						}
					}
					
				}else{
					iTypeService.deleteByPrimaryKey(apptype.getTypeId());
				}
			}
		}else{
			iTypeService.deleteByPrimaryKey(typeId);
		}
		return new Result<Integer>("success",1,1);
	}

	/**
	 * 新增一个类型记录
	 * @param record
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public int insertSelective(Apptype record) {
		return iTypeService.insertSelective(record);
	}
	
	/**
	 * 返回指定typeId的类型对象 
	 * @param typeId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/selectById", method = RequestMethod.GET)
	public Apptype selectByPrimaryKey(Integer typeId) {
		return iTypeService.selectByPrimaryKey(typeId);
	}
	
	/**
	 * 根据typeId修改指定的类型对象
	 * @param record
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "updateById", method = RequestMethod.POST)
	public int updateByPrimaryKey(Apptype record) {
		return iTypeService.updateByPrimaryKey(record);
	}
}
