package io.renren.service;


import io.renren.entity.QuestionsEntity;

import java.util.List;
import java.util.Map;

/**
 * 试题
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-07-06 14:19:49
 */
public interface QuestionsService{
	
	QuestionsEntity queryObject(Integer id);
	
	List<QuestionsEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(QuestionsEntity questions);
	
	void update(QuestionsEntity questions);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
