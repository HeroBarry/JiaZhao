package io.renren.controller;

import io.renren.entity.QuestionsEntity;
import io.renren.service.QuestionsService;
import io.renren.utils.PageUtils;
import io.renren.utils.Query;
import io.renren.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

import java.util.List;
import java.util.Map;

/**
 * 试题
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-07-06 14:19:49
 */
@RestController
@RequestMapping("questions")
public class QuestionsController {
	@Autowired
	private QuestionsService questionsService;
	/**
	 * 删除
	 */
	@RequestMapping("/start")
	public void start(){

		OOSpider.create(Site.me()
						.setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/30.0.1599.101 Safari/537.36")
						.setSleepTime(0)
						.setRetryTimes(3)
				,new PageModelPipeline<QuestionsEntity>() {
					@Override
					public void process(QuestionsEntity o, Task task) {
						System.out.println(o);
						questionsService.save(o);
					}
				}, QuestionsEntity.class).thread(10).addUrl("http://www.jiazhao.com/tiba/1").run();
	}
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<QuestionsEntity> questionsList = questionsService.queryList(query);
		int total = questionsService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(questionsList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	

	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody QuestionsEntity questions){
		questionsService.save(questions);
		return R.ok();
	}

	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids){
		questionsService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
