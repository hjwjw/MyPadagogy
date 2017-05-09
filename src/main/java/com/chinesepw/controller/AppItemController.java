package com.chinesepw.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.chinesepw.po.Appitem;
import com.chinesepw.po.AppitemCustom;
import com.chinesepw.po.Apptype;
import com.chinesepw.po.Apptypelist;
import com.chinesepw.po.Keywordlist;
import com.chinesepw.po.User;
import com.chinesepw.service.IAppItemService;
import com.chinesepw.service.IApptypelistService;
import com.chinesepw.service.IKeywordListService;
import com.chinesepw.service.IKeywordService;
import com.chinesepw.service.ITypeService;
import com.chinesepw.service.IUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author HJW
 * @date 2017年4月23日
 * App的管理
 */

@Controller
@RequestMapping(value="appItem")
public class AppItemController {
	
	@Autowired
	IAppItemService iAppItemService;
	@Autowired
	ITypeService iTypeService;
	@Autowired
	IKeywordService iKeywordService;
	@Autowired
	IKeywordListService ikeywordListService;
	@Autowired
	IApptypelistService iApptypelistService;
	@Autowired
	IUserService iUserService;
	
	/**
	 * 查询所有APP列表
	 * @param model
	 * @param pageNum
	 * @param pageSize
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping(value="/queryAll",method=RequestMethod.GET)
	public String queryAll(Model model, @RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "10") int pageSize, HttpServletRequest req, HttpServletResponse resp) {
		PageHelper.startPage(pageNum, pageSize);
		List<AppitemCustom> appitemList = iAppItemService.queryAll();
		for (AppitemCustom ac : appitemList) {
			ac.setUserName(iUserService.selectByPrimaryKey(ac.getUserId()).getUsername());
			ac.setTypeName(this.getTypeName(ac.getAppId()));
			if (ac.getState()) {
				ac.setStateStr("已通过");
			}else{
				ac.setStateStr("未通过");
			}
		} 
		PageInfo<AppitemCustom> pageInfo = new PageInfo<AppitemCustom>(appitemList);
		model.addAttribute("appList", appitemList);
		model.addAttribute("page", pageInfo);
		return "/WEB-INF/manager/appList";
	}
	
	/**
	 * 查询未通过审核的APP
	 * @param model
	 * @param pageNum
	 * @param pageSize
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping(value="/queryPending",method =RequestMethod.GET)
	public String queryPending(Model model, @RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "10") int pageSize, HttpServletRequest req, HttpServletResponse resp) {
		PageHelper.startPage(pageNum, pageSize);
		List<AppitemCustom> appitemPendingList = iAppItemService.queryPending();
		for (AppitemCustom ac : appitemPendingList) {
			ac.setUserName(iUserService.selectByPrimaryKey(ac.getUserId()).getUsername());
			ac.setTypeName(this.getTypeName(ac.getAppId()));
			ac.setStateStr("未通过");
		} 
		PageInfo<AppitemCustom> pageInfo = new PageInfo<AppitemCustom>(appitemPendingList);
		model.addAttribute("appList", appitemPendingList);
		model.addAttribute("page", pageInfo);
		return "/WEB-INF/manager/pendingItem";
	}
	
	/**
	 * 删除指定APP ，关联删除apptypelist关系
	 * @param appId
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping(value="/del/{id}",method=RequestMethod.GET)
	public String deleteByPrimaryKey(@PathVariable("id") Integer appId,HttpServletRequest req, HttpServletResponse resp) {
		/*关联删除*/
		iApptypelistService.deleteByappId(appId);
		ikeywordListService.deleteByappId(appId);
		iAppItemService.deleteByPrimaryKey(appId);
		if (req.getParameter("p").equals("pending")) {
			return "redirect: ../queryPending";
		}else{
			return "redirect: ../queryAll";
		}
	}
	
	/**
	 * 多选删除操作 关联删除apptypelist关系
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping(value="/selectDel",method=RequestMethod.POST)
	public String selectDeleteByPrimaryKey(HttpServletRequest req, HttpServletResponse resp) {
		String[] appinfos = req.getParameterValues("appinfo");
		for (String appId : appinfos) {
			if (appId != null) {
				iApptypelistService.deleteByappId(Integer.parseInt(appId));
				ikeywordListService.deleteByappId(Integer.parseInt(appId));
				iAppItemService.deleteByPrimaryKey(Integer.parseInt(appId));			
			}
		}
		if (req.getParameter("p").equals("pending")) {
			return "redirect: queryPending";
		}else{
			return "redirect: queryAll";
		}
	}

	/**
	 * 中转到APP添加页面,带入类别与标签
	 * @return
	 */
	@RequestMapping(value="/toAdd",method=RequestMethod.GET)
	public String toAdd(Model model) {
		model.addAttribute("rootTypeList", iTypeService.selectByParentId(0));
		model.addAttribute("keywordList", iKeywordService.queryAll());
		return "/WEB-INF/manager/addApp";
	}
	
	/**
	 * 根据父ID查找其下的子分类
	 * @param parentId
	 * @return
	 */
	@RequestMapping(value="typeList" ,method = RequestMethod.GET)
	@ResponseBody
	public List<Apptype> getTypeList(Integer parentId) {
		List<Apptype> apptypes = iTypeService.selectByParentId(parentId);
		return apptypes;
	}
	
	/**
	 * 新增APP
	 * @param record
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String insertSelective(@RequestParam(value = "iconPic", required = false) MultipartFile file,Appitem record,HttpServletRequest req,HttpServletResponse resp)throws IOException {
		String path = req.getSession().getServletContext().getRealPath("upload/Appicon");  
        String fileName = file.getOriginalFilename();  
        System.out.println(path);  
        File targetFile = new File(path, fileName);  
        if(!targetFile.exists()){  
            targetFile.mkdirs();  
        }  
        //保存  
        try {  
            file.transferTo(targetFile);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        String iconPath = "upload/Appicon/"+fileName;
		
		HttpSession session = req.getSession();
		session.setAttribute("userId", 1);
		Integer userId = (Integer)session.getAttribute("userId");
		String[] keyIds = req.getParameterValues("keyId[]");
		String[] typeIds = req.getParameterValues("typeSelect");
		Date createtime = new Date();
		record.setUserId(userId);
		record.setCreatetime(createtime);
		record.setLogo(iconPath);
		Integer appId = iAppItemService.insertSelective(record);
		//插入类型与APP关系
		Apptypelist apptypelist = new Apptypelist();
		apptypelist.setAppId(appId);
		for (String typeId : typeIds) {
			apptypelist.setTypeId(Integer.parseInt(typeId));
			if (iApptypelistService.isHave(apptypelist.getTypeId(), apptypelist.getAppId())) {
				iApptypelistService.insert(apptypelist);
			}
		}
		
		
		//插入标签与APP关系 
		Keywordlist keywordlist = new Keywordlist();
		for (String keyId : keyIds) {
			keywordlist.setKeyId(Integer.parseInt(keyId));
			keywordlist.setAppId(appId);
			if (ikeywordListService.isHave(keywordlist.getKeyId(), keywordlist.getAppId())) {
				ikeywordListService.insertSelective(keywordlist);
			}
		}
		
		
		return "redirect: queryPending";
	}
	
	
	/**
	 * 返回指定APP对象
	 * @param appId
	 * @return
	 */
	@RequestMapping(value="select/{id}",method=RequestMethod.GET)
	public Appitem selectByPrimaryKey(@PathVariable("id") Integer appId) {
		return iAppItemService.selectByPrimaryKey(appId);
	}

	/**
	 * 更新前获取需要更新的APP内容
	 * @param model
	 * @param appId
	 * @return
	 */
	@RequestMapping(value="up/{id}",method=RequestMethod.GET)
	public String updateBefore(Model model, @PathVariable("id") Integer appId) {
		Appitem appitem = iAppItemService.selectByPrimaryKey(appId);
		model.addAttribute("rootTypeList", iTypeService.selectByParentId(0));
		model.addAttribute("appItemType", iApptypelistService.getTypeListByAppId(appId));
		model.addAttribute("keywordList", iKeywordService.queryAll());
		model.addAttribute("appItemKeywordList", ikeywordListService.selectKeywordByAppId(appId));
		model.addAttribute("appItem", appitem);
		return "/WEB-INF/manager/updateApp";
	}
	
	/**
	 * 更新
	 * @param record
	 * @return
	 */
	@RequestMapping(value="update/{appId}",method=RequestMethod.POST)
	public String updateByPrimaryKeyWithBLOBs(@RequestParam(value = "iconPic", required = false) MultipartFile file,Appitem record,HttpServletRequest req,HttpServletResponse resp) {
		Appitem appitem = iAppItemService.selectByPrimaryKey(record.getAppId());
		String[] keyIds = req.getParameterValues("keyId[]");
		String[] typeIds = req.getParameterValues("typeSelect");
		List<Integer> typeIdList = iApptypelistService.getTypeListByAppId(appitem.getAppId());
		if (!file.isEmpty()) {
			String path = req.getSession().getServletContext().getRealPath("upload/Appicon");  
	        String fileName = file.getOriginalFilename();  
	        System.out.println(path);  
	        File targetFile = new File(path, fileName);  
	        if(!targetFile.exists()){  
	            targetFile.mkdirs();  
	        }  
	        //保存  
	        try {  
	            file.transferTo(targetFile);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        String iconPath = "upload/Appicon/"+fileName;
	        record.setLogo(iconPath);
		}else{
			record.setLogo(appitem.getLogo());
		}
		if (record.getImg1().isEmpty()) {
			record.setImg1(appitem.getImg1());
		}
		if (record.getImg2().isEmpty()) {
			record.setImg2(appitem.getImg2());
		}
		if (record.getImg3().isEmpty()) {
			record.setImg3(appitem.getImg3());
		}
		record.setState(appitem.getState());
		record.setUserId(appitem.getUserId());
		record.setCount(appitem.getCount());
		record.setDislike(appitem.getDislike());
		record.setSupport(appitem.getSupport());
		record.setCreatetime(new Date());
		//插入类型与APP关系
		
		if (typeIds !=null) {
			Apptypelist apptypelist = new Apptypelist();
			apptypelist.setAppId(appitem.getAppId());
			iApptypelistService.deleteByappId(appitem.getAppId());
			for (String typeId : typeIds) {
				apptypelist.setTypeId(Integer.parseInt(typeId));
				if (iApptypelistService.isHave(apptypelist.getTypeId(), apptypelist.getAppId())) {
					iApptypelistService.insert(apptypelist);
				}
			}
		}
		
		//插入标签与APP关系 
		Keywordlist keywordlist = new Keywordlist();
		for (String keyId : keyIds) {
			keywordlist.setKeyId(Integer.parseInt(keyId));
			keywordlist.setAppId(appitem.getAppId());
			if (ikeywordListService.isHave(keywordlist.getKeyId(), keywordlist.getAppId())) {
				ikeywordListService.insertSelective(keywordlist);
			}
			
		}

		iAppItemService.updateByPrimaryKeyWithBLOBs(record);
		return "redirect: ../queryAll";
	}
	
	/**
	 * 批量修改审核状态 
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping(value="/changeState",method=RequestMethod.POST)
	public String changeState(HttpServletRequest req, HttpServletResponse resp) {
		String[] appinfos = req.getParameterValues("appinfo");
		for (String appId : appinfos) {
			if (appId !=null) {
				System.out.println(iAppItemService.selectByPrimaryKey(Integer.parseInt(appId)).getState());
				Appitem appitem = iAppItemService.selectByPrimaryKey(Integer.parseInt(appId));
				if (appitem.getState()) {
					appitem.setState(false);
				}else {
					appitem.setState(true);
				}
				iAppItemService.updateByPrimaryKeyWithBLOBs(appitem);
			}
		}
		if (req.getParameter("p").equals("pending")) {
			return "redirect: queryPending";
		}else{
			return "redirect: queryAll";
		}
	}

	/**
	 * 修改单个APP的审核状态
	 * @param appId
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping(value="/changeStateById/{id}",method=RequestMethod.GET)
	public String changeStateById(@PathVariable("id") Integer appId,HttpServletRequest req, HttpServletResponse resp) {
		if (appId !=null) {
			Appitem appitem = iAppItemService.selectByPrimaryKey(appId);
			if (appitem.getState()) {
				appitem.setState(false);
			}else {
				appitem.setState(true);
			}
			iAppItemService.updateByPrimaryKeyWithBLOBs(appitem);
		}
		System.out.println("P:" + req.getParameter("p"));
		if (req.getParameter("p").equals("pending")) {
			return "redirect: ../queryPending";
		}else{
			return "redirect: ../queryAll";
		}
		
	}	
	
	
	/**
	 * 关联apptypelist 与 apptype表找出APP的所有类别的名称
	 * @param appId
	 * @return 
	 */
	public String[] getTypeName(Integer appId) {
		List<Integer> typeIdList = iApptypelistService.getTypeListByAppId(appId);
		System.out.println(typeIdList);
		List<String> typeNameList = new ArrayList<String>();
		for (Integer typeId : typeIdList) {
			typeNameList.add(iTypeService.selectByPrimaryKey(typeId).getName());
		}
		String[] typeNameStr = new String[typeNameList.size()];
		typeNameList.toArray(typeNameStr);
		return typeNameStr;
	}
	
	/**
	 * 关联apptypelist 与 apptype,appitem表找出这个类别下的的所有app
	 * @param typeId
	 * @return
	 */
	public List<Appitem> getAppName(Integer typeId) {
		List<Integer> appIdList = iApptypelistService.getAppListByTypeId(typeId);
		List<Appitem> appitemList = new ArrayList<Appitem>();
		for (Integer appId : appIdList) {
			appitemList.add(iAppItemService.selectByPrimaryKey(appId));
		}
		return appitemList;
	}
	
	//summernote中的图片上传
	@RequestMapping(value="/uploadFileEdit",method = RequestMethod.POST )
	@ResponseBody
	public String uploadFileEdit(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request)throws IOException {
		String path = request.getSession().getServletContext().getRealPath("upload/article");  
        String fileName = file.getOriginalFilename();  
        System.out.println(path);  
        File targetFile = new File(path, fileName);  
        if(!targetFile.exists()){  
            targetFile.mkdirs();  
        }  
        //保存  
        try {  
            file.transferTo(targetFile);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        String filePath = request.getContextPath()+"/upload/article/"+fileName;
		return filePath;
	}
	
	/**
	 * 焦点图上传
	 * @param myFile
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/uploadPics")
    @ResponseBody
	public Map<String, Object> uploadPics(@RequestParam("focusPic") MultipartFile myFile,HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> json = new HashMap<String, Object>();
        try {
            //输出文件后缀名称
            System.out.println(myFile.getOriginalFilename());
            DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
            //图片名称
            String name = df.format(new Date());

            Random r = new Random();
            for(int i = 0 ;i<3 ;i++){
                name += r.nextInt(10);
            }
            String ext = FilenameUtils.getExtension(myFile.getOriginalFilename());
            //保存图片       File位置 （全路径）   /upload/fileName.jpg
            String url = request.getSession().getServletContext().getRealPath("upload/focusPic");
            //相对路径
            String path = "/"+name + "." + ext;
            File file = new File(url);
            if(!file.exists()){
                file.mkdirs();
            }
            myFile.transferTo(new File(url+path));
            json.put("success", "upload/focusPic"+path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json ;
	}

}
