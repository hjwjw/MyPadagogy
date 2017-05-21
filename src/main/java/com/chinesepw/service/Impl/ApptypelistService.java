package com.chinesepw.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinesepw.mapper.ApptypelistMapper;
import com.chinesepw.po.Apptypelist;
import com.chinesepw.service.IApptypelistService;

/**
 * @author HJW
 * @date 2017年5月1日
 * 
 */
@Service
public class ApptypelistService implements IApptypelistService {

	@Autowired
	ApptypelistMapper apptypelistMapper;
	
	@Override
	public List<Integer> getTypeListByAppId(Integer appId) {
		List<Integer> ints = apptypelistMapper.getTypeListByAppId(appId);
		return ints;
	}

	@Override
	public List<Integer> getAppListByTypeId(Integer typeId) {
		return apptypelistMapper.getAppListByTypeId(typeId);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return apptypelistMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Apptypelist record) {
		return apptypelistMapper.insert(record);
	}

	@Override
	public int insertSelective(Apptypelist record) {
		return apptypelistMapper.insertSelective(record);
	}

	@Override
	public Apptypelist selectByPrimaryKey(Integer id) {
		return apptypelistMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Apptypelist record) {
		return apptypelistMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Apptypelist record) {
		return apptypelistMapper.updateByPrimaryKey(record);
	}

	@Override
	public int deleteByappId(Integer appId) {
		return apptypelistMapper.deleteByappId(appId);
	}

	@Override
	public int deleteBytypeId(Integer typeId) {
		return apptypelistMapper.deleteBytypeId(typeId);
	}

	@Override
	public boolean isHave(Integer typeId, Integer appId) {
		boolean falg = false;
		List<Apptypelist> apptypelists = apptypelistMapper.isHave(typeId, appId);
		if (apptypelists.size() == 0) {
			falg = true;
		}
		return falg;
	}

}
