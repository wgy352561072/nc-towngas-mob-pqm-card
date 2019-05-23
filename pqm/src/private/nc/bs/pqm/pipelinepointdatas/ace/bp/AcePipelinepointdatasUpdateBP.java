package nc.bs.pqm.pipelinepointdatas.ace.bp;

import nc.impl.pubapp.pattern.data.bill.template.UpdateBPTemplate;
import nc.impl.pubapp.pattern.rule.processer.CompareAroundProcesser;
import nc.impl.pubapp.pattern.rule.IRule;
import nc.vo.pqm.pipelinepointdatas.AggPipelinepointdatasVO;

/**
 * �޸ı����BP
 * 
 */
public class AcePipelinepointdatasUpdateBP {

	public AggPipelinepointdatasVO[] update(AggPipelinepointdatasVO[] bills,
			AggPipelinepointdatasVO[] originBills) {
		// �����޸�ģ��
		UpdateBPTemplate<AggPipelinepointdatasVO> bp = new UpdateBPTemplate<AggPipelinepointdatasVO>(null);
		// ִ��ǰ����
		this.addBeforeRule(bp.getAroundProcesser());
		// ִ�к����
		this.addAfterRule(bp.getAroundProcesser());
		return bp.update(bills, originBills);
	}

	private void addAfterRule(CompareAroundProcesser<AggPipelinepointdatasVO> processer) {
		// TODO �����
		IRule<AggPipelinepointdatasVO> rule = null;

	}

	private void addBeforeRule(CompareAroundProcesser<AggPipelinepointdatasVO> processer) {
		// TODO ǰ����
		IRule<AggPipelinepointdatasVO> rule = null;
		rule = new nc.bs.pubapp.pub.rule.FillUpdateDataRule();
		processer.addBeforeRule(rule);
	}

}
