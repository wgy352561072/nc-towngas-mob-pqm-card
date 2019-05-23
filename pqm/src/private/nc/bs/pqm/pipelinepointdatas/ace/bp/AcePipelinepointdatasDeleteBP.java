package nc.bs.pqm.pipelinepointdatas.ace.bp;

import nc.vo.pqm.pipelinepointdatas.AggPipelinepointdatasVO;

import nc.impl.pubapp.pattern.data.bill.template.DeleteBPTemplate;
import nc.impl.pubapp.pattern.rule.processer.AroundProcesser;
import nc.impl.pubapp.pattern.rule.IRule;


/**
 * 标准单据删除BP
 */
public class AcePipelinepointdatasDeleteBP {

	public void delete(AggPipelinepointdatasVO[] bills) {

		DeleteBPTemplate<AggPipelinepointdatasVO> bp = new DeleteBPTemplate<AggPipelinepointdatasVO>(null);
		// 增加执行前规则
		this.addBeforeRule(bp.getAroundProcesser());
		// 增加执行后业务规则
		this.addAfterRule(bp.getAroundProcesser());
		bp.delete(bills);
	}

	private void addBeforeRule(AroundProcesser<AggPipelinepointdatasVO> processer) {/*
		// TODO 前规则
		IRule<AggPipelinepointdatasVO> rule = null;
		rule = new nc.bs.pubapp.pub.rule.BillDeleteStatusCheckRule();
		processer.addBeforeRule(rule);
	*/}

	/**
	 * 删除后业务规则
	 * 
	 * @param processer
	 */
	private void addAfterRule(AroundProcesser<AggPipelinepointdatasVO> processer) {
		// TODO 后规则

	}
}
