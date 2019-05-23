package nc.bs.pqm.pipelinepointdatas.ace.bp;

import nc.impl.pubapp.pattern.data.bill.template.InsertBPTemplate;
import nc.impl.pubapp.pattern.rule.processer.AroundProcesser;
import nc.impl.pubapp.pattern.rule.IRule;
import nc.vo.pqm.pipelinepointdatas.AggPipelinepointdatasVO;

/**
 * 标准单据新增BP
 */
public class AcePipelinepointdatasInsertBP {

	public AggPipelinepointdatasVO[] insert(AggPipelinepointdatasVO[] bills) {

		InsertBPTemplate<AggPipelinepointdatasVO> bp = new InsertBPTemplate<AggPipelinepointdatasVO>(null);
		this.addBeforeRule(bp.getAroundProcesser());
		this.addAfterRule(bp.getAroundProcesser());
		return bp.insert(bills);

	}

	/**
	 * 新增后规则
	 * 
	 * @param processor
	 */
	private void addAfterRule(AroundProcesser<AggPipelinepointdatasVO> processor) {
		// TODO 新增后规则
		IRule<AggPipelinepointdatasVO> rule = null;
	}

	/**
	 * 新增前规则
	 * 
	 * @param processor
	 */
	private void addBeforeRule(AroundProcesser<AggPipelinepointdatasVO> processer) {
		// TODO 新增前规则
		IRule<AggPipelinepointdatasVO> rule = null;
		rule = new nc.bs.pubapp.pub.rule.FillInsertDataRule();
		processer.addBeforeRule(rule);
		rule = new nc.bs.pqm.pipelinepointdatas.rules.PipelinepointDatasAutoCodeRule();
		processer.addBeforeRule(rule);
	}
}
