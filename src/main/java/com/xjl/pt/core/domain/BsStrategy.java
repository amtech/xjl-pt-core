package com.xjl.pt.core.domain;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.annotation.TableDB;

/**
* 办事攻略
* @author DomainCoderTools 陶杰
*
*/
@TableDB(name="xjl_bs_strategy")
public class BsStrategy extends XJLDomain {
	//办事攻略状态
	private String strategyState;
	//办事攻略 对应名称(非数据库字段)
	private String strategyState$name;
	//办事攻略内容
	private String strategyContent;
	//办事攻略标题
	private String strategyTitle;
	//办事攻略编号
	private String strategyId;
	//办事攻略创建时间格式
	private String strategyCreateDateStr;
	public void setStrategyState(String strategyState){
		this.strategyState = strategyState;
	}
	public String getStrategyState(){
		return this.strategyState;
	}
	public void setStrategyContent(String strategyContent){
		this.strategyContent = strategyContent;
	}
	public String getStrategyContent(){
		return this.strategyContent;
	}
	public void setStrategyTitle(String strategyTitle){
		this.strategyTitle = strategyTitle;
	}
	public String getStrategyTitle(){
		return this.strategyTitle;
	}
	public void setStrategyId(String strategyId){
		this.strategyId = strategyId;
	}
	public String getStrategyId(){
		return this.strategyId;
	}
	public String getStrategyState$name() {
		return strategyState$name;
	}
	public void setStrategyState$name(String strategyState$name) {
		this.strategyState$name = strategyState$name;
	}
	public String getStrategyCreateDateStr() {
		return strategyCreateDateStr;
	}
	public void setStrategyCreateDateStr(String strategyCreateDateStr) {
		this.strategyCreateDateStr = strategyCreateDateStr;
	}
	
	
}
