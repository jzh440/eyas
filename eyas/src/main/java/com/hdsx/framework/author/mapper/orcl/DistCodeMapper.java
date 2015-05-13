package com.hdsx.framework.author.mapper.orcl;

import java.util.List;

import com.hdsx.framework.author.bean.DistCode;
import com.hdsx.framework.dao.Dao;
import com.hdsx.framework.dao.Mapper;
/**
 * 行政区划持久层
 * @author xiongxt
 * @2015年3月15日
 */
@Mapper
public interface DistCodeMapper extends Dao<DistCode> {
	/**
	 * 下级行政区划
	 * @param code
	 * @return
	 */
	List<DistCode> selectChildren(String code);
}
