package com.chinesepw.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.chinesepw.po.Keyword;
import com.chinesepw.service.IKeywordListService;
import com.chinesepw.service.IKeywordService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author HJW
 * @date 2017年4月24日
 * 
 */
@Controller
@RequestMapping(value = "/keyword")
public class KeywordController {

	@Autowired
	IKeywordService iKeywordService;
	@Autowired
	IKeywordListService iKeywordListService;

	/**
	 * 查询标签列表
	 * 
	 * @param model
	 * @param pageNum
	 * @param pageSize
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping(value = "/queryAll", method = RequestMethod.GET)
	public String queryAll(Model model, @RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "4") int pageSize, HttpServletRequest req, HttpServletResponse resp) {
		List<Keyword> keywordList = new ArrayList<Keyword>();
		PageHelper.startPage(pageNum, pageSize);
		keywordList = iKeywordService.queryAll();
		PageInfo<Keyword> pageInfo = new PageInfo<Keyword>(keywordList);
		for (Keyword keyword : keywordList) {
			keyword.setAppCount(iKeywordListService.selectAppItemByKeyId(keyword.getKeyId()).size());
		}
		model.addAttribute("keywordList", keywordList);
		model.addAttribute("page", pageInfo);
		return "/WEB-INF/manager/labelList";
	}

	/**
	 * 删除指定标签
	 * 
	 * @param keyId
	 * @return
	 */
	@RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
	public String deleteByPrimaryKey(@PathVariable("id") Integer keyId) {
		iKeywordService.deleteByPrimaryKey(keyId);
		return "redirect: ../queryAll";
	}

	/**
	 * 多选操作 删除
	 * 
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping(value = "/selectDel", method = { RequestMethod.POST })
	public String SelectDeleteByPrimaryKey(HttpServletRequest req, HttpServletResponse resp) {
		String[] keywordInfos = req.getParameterValues("keywordInfo");
		for (String keyId : keywordInfos) {
			if (keyId != null) {
				iKeywordService.deleteByPrimaryKey(Integer.parseInt(keyId));
			}
		}
		return "redirect: queryAll";

	}

	/**
	 * 跳转到管理员新增页面（web-inf下的页面不能直接访问）
	 * 
	 * @return
	 */
	@RequestMapping(value = "/toAdd", method = RequestMethod.GET)
	public String toAdd() {
		return "/WEB-INF/manager/addKeyword";
	}

	/**
	 * 新增标签
	 * 
	 * @param record
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String insertSelective(@RequestParam(value = "iconPic", required = false) MultipartFile file, Keyword record,
			HttpServletRequest req, HttpServletResponse resp) {
		if (!file.isEmpty()) {
		String path = req.getSession().getServletContext().getRealPath("upload/keyWordicon");  
        String fileName = file.getOriginalFilename(); 
        System.out.println("path:");
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
        String iconPath = "upload/keyWordicon/"+fileName;
        record.setIconUrl(iconPath);
		}
		iKeywordService.insertSelective(record);
		return "redirect: queryAll";
	}

	/**
	 * 返回指定标签对象
	 * 
	 * @param keyId
	 * @return
	 */
	@RequestMapping(value = "/select/{id}", method = RequestMethod.GET)
	public Keyword selectByPrimaryKey(@PathVariable("id") Integer keyId) {
		return iKeywordService.selectByPrimaryKey(keyId);
	}

	/**
	 * 更新前获取数据
	 * 
	 * @param model
	 * @param id
	 */
	@RequestMapping(value = "up/{id}", method = RequestMethod.GET)
	public String selectByPrimaryKey(Model model, @PathVariable("id") Integer id, HttpServletRequest req,
			HttpServletResponse resp) {
		Keyword keyword = iKeywordService.selectByPrimaryKey(id);
		model.addAttribute("keyword", keyword);
		return "/WEB-INF/manager/addKeyword";
	}

	/**
	 * 更新标签
	 * 
	 * @param record
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateByPrimaryKeySelective(@RequestParam(value = "iconPic", required = false) MultipartFile file,Keyword record,HttpServletRequest req,HttpServletResponse resp) {
		if (!file.isEmpty()) {
		String path = req.getSession().getServletContext().getRealPath("upload/keyWordicon");  
        String fileName = file.getOriginalFilename(); 
        System.out.println("path:");
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
        String iconPath = "upload/keyWordicon/"+fileName;
        record.setIconUrl(iconPath);
		}else{
			/**
			 * mapper中为空时不会更新
			 */
			record.setIconUrl(null);
		}
		iKeywordService.updateByPrimaryKeySelective(record);
		return "redirect: queryAll";
	}
}
