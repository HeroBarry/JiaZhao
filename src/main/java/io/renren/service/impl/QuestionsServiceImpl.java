package io.renren.service.impl;

import io.renren.dao.QuestionsDao;
import io.renren.entity.QuestionsEntity;
import io.renren.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("questionsService")
public class QuestionsServiceImpl implements QuestionsService {
	@Autowired
	private QuestionsDao questionsDao;
	
	@Override
	public QuestionsEntity queryObject(Integer id){
		return questionsDao.queryObject(id);
	}
	
	@Override
	public List<QuestionsEntity> queryList(Map<String, Object> map){
		return questionsDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return questionsDao.queryTotal(map);
	}
	
	@Override
	public void save(QuestionsEntity questions){
		questionsDao.save(questions);
	}
	
	@Override
	public void update(QuestionsEntity questions){
		questionsDao.update(questions);
	}
	
	@Override
	public void delete(Integer id){
		questionsDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		questionsDao.deleteBatch(ids);
	}

}
