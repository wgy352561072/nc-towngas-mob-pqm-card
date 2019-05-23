package nc.bs.pqm.pipelinepointdatas.ace.bp;

import nc.impl.pubapp.pattern.data.bill.template.UpdateBPTemplate;
import nc.impl.pubapp.pattern.rule.processer.CompareAroundProcesser;
import nc.impl.pubapp.pattern.rule.IRule;
import nc.vo.pqm.pipelinepointdatas.AggPipelinepointdatasVO;

/**
 * 修改保存的BP
 * 
 */
public class AcePipelinepointdatasUpdateBP {

	public AggPipelinepointdatasVO[] update(AggPipelinepointdatasVO[] bills,
			AggPipelinepointdatasVO[] originBills) {
		// 调用修改模板
		UpdateBPTemplate<AggPipelinepointdatasVO> bp = new UpdateBPTemplate<AggPipelinepointdatasVO>(null);
		// 执行前规则
		this.addBeforeRule(bp.getAroundProcesser());
		// 执行后规则
		this.addAfterRule(bp.getAroundProcesser());
		return bp.update(bills, originBills);
	}

	private void addAfterRule(CompareAroundProcesser<AggPipelinepointdatasVO> processer) {
		// TODO 后规则
		IRule<AggPipelinepointdatasVO> rule = null;

	}

	private void addBeforeRule(CompareAroundProcesser<AggPipelinepointdatasVO> processer) {
		// TODO 前规则
		IRule<AggPipelinepointdatasVO> rule = null;
		rule = new nc.bs.pubapp.pub.rule.FillUpdateDataRule();
		processer.addBeforeRule(rule);
	}

}
