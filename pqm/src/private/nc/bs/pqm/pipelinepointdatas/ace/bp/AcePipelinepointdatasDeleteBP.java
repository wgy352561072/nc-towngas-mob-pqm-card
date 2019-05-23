package nc.bs.pqm.pipelinepointdatas.ace.bp;

import nc.vo.pqm.pipelinepointdatas.AggPipelinepointdatasVO;

import nc.impl.pubapp.pattern.data.bill.template.DeleteBPTemplate;
import nc.impl.pubapp.pattern.rule.processer.AroundProcesser;
import nc.impl.pubapp.pattern.rule.IRule;


/**
 * ��׼����ɾ��BP
 */
public class AcePipelinepointdatasDeleteBP {

	public void delete(AggPipelinepointdatasVO[] bills) {

		DeleteBPTemplate<AggPipelinepointdatasVO> bp = new DeleteBPTemplate<AggPipelinepointdatasVO>(null);
		// ����ִ��ǰ����
		this.addBeforeRule(bp.getAroundProcesser());
		// ����ִ�к�ҵ�����
		this.addAfterRule(bp.getAroundProcesser());
		bp.delete(bills);
	}

	private void addBeforeRule(AroundProcesser<AggPipelinepointdatasVO> processer) {/*
		// TODO ǰ����
		IRule<AggPipelinepointdatasVO> rule = null;
		rule = new nc.bs.pubapp.pub.rule.BillDeleteStatusCheckRule();
		processer.addBeforeRule(rule);
	*/}

	/**
	 * ɾ����ҵ�����
	 * 
	 * @param processer
	 */
	private void addAfterRule(AroundProcesser<AggPipelinepointdatasVO> processer) {
		// TODO �����

	}
}
