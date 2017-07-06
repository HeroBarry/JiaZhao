package io.renren.entity;

import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.ExtractByUrl;
import us.codecraft.webmagic.model.annotation.TargetUrl;

import java.io.Serializable;


/**
 * 试题
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-07-06 14:19:49
 */
@TargetUrl("http://www.jiazhao.com/tiba/\\d+")
public class QuestionsEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//ID
	private Integer id;
	//链接
	@ExtractByUrl("http://www.jiazhao.com/tiba/\\d+")
	private String url;
	//题目
	@ExtractBy("//div[@class='topic-l f-l']//ul/li/text()")
	private String title;
	//答案
	@ExtractBy("//div[@class='topic-l f-l']//ul/li[@class='answer']/strong/text()")
	private String answer;
	//图片
	@ExtractBy("//div[@class=topic-t]/div[2]/img/@src")
	private String img;

	/**
	 * 设置：ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：ID
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：链接
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：链接
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 设置：题目
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：题目
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：答案
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	/**
	 * 获取：答案
	 */
	public String getAnswer() {
		return answer;
	}
	/**
	 * 设置：图片
	 */
	public void setImg(String img) {
		this.img = img;
	}
	/**
	 * 获取：图片
	 */
	public String getImg() {
		return img;
	}

	@Override
	public String toString() {
		return "QuestionsEntity{" +
				"id=" + id +
				", url='" + url + '\'' +
				", title='" + title + '\'' +
				", answer='" + answer + '\'' +
				", img='" + img + '\'' +
				'}';
	}
}
