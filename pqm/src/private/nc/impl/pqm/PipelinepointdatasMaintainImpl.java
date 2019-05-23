package nc.impl.pqm;

import nc.bs.pqm.pipelinepointdatas.ace.bp.AcePipelinepointdatasDeleteBP;
import nc.bs.pqm.pipelinepointdatas.ace.bp.AcePipelinepointdatasInsertBP;
import nc.bs.pqm.pipelinepointdatas.ace.bp.AcePipelinepointdatasUpdateBP;
import nc.impl.pubapp.pattern.data.bill.BillLazyQuery;
import nc.impl.pubapp.pattern.data.bill.tool.BillTransferTool;
import nc.itf.pqm.IPipelinepointdatasMaintain;
import nc.ui.querytemplate.querytree.IQueryScheme;
import nc.vo.pqm.pipelinepointdatas.AggPipelinepointdatasVO;
import nc.vo.pub.BusinessException;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;

public class PipelinepointdatasMaintainImpl 
		implements IPipelinepointdatasMaintain {
	
	private AcePipelinepointdatasInsertBP insertBP;
	private AcePipelinepointdatasUpdateBP updateBP;
	private AcePipelinepointdatasDeleteBP deleteBP;



	@Override
	public AggPipelinepointdatasVO[] query(IQueryScheme queryScheme)
			throws BusinessException {
		AggPipelinepointdatasVO[] bills = null;
		try {
			this.preQuery(queryScheme);
			BillLazyQuery<AggPipelinepointdatasVO> query = new BillLazyQuery<AggPipelinepointdatasVO>(
					AggPipelinepointdatasVO.class);
			bills = query.query(queryScheme, null);
		} catch (Exception e) {
			ExceptionUtils.marsh(e);
		}
		return bills;
	}
	
	/**
	 * ������ʵ�֣���ѯ֮ǰ��queryScheme���мӹ��������Լ����߼�
	 * 
	 * @param queryScheme
	 */
	protected void preQuery(IQueryScheme queryScheme) {
		// ��ѯ֮ǰ��queryScheme���мӹ��������Լ����߼�
	}

	@Override
	public AggPipelinepointdatasVO[] insertBill(
			AggPipelinepointdatasVO[] billVOs) throws BusinessException {
		return getInsertBP().insert(billVOs);
	}

	@Override
	public AggPipelinepointdatasVO[] updateBill(
			AggPipelinepointdatasVO[] billVOs) throws BusinessException {
		try {
			// ���� + ���ts
			BillTransferTool<AggPipelinepointdatasVO> transTool = new BillTransferTool<AggPipelinepointdatasVO>(billVOs);
			// ��ȫǰ̨VO
			AggPipelinepointdatasVO[] fullBills = transTool.getClientFullInfoBill();
			// ����޸�ǰvo
			AggPipelinepointdatasVO[] originBills = transTool.getOriginBills();
			// ����BP
			AggPipelinepointdatasVO[] retBills = getUpdateBP()
					.update(fullBills, originBills);
			// ���췵������
			retBills = transTool.getBillForToClient(retBills);
			return retBills;
		} catch (Exception e) {
			ExceptionUtils.marsh(e);
		}
		return null;
	}

	@Override
	public void deleteBill(AggPipelinepointdatasVO[] billVOs)
			throws BusinessException {
		// ���� �Ƚ�ts
		BillTransferTool<AggPipelinepointdatasVO> transferTool = new BillTransferTool<AggPipelinepointdatasVO>(billVOs);
		// ��ȫǰ̨VO
		AggPipelinepointdatasVO[] fullBills = transferTool.getClientFullInfoBill();
		// ����BP
		getDeleteBP().delete(fullBills);
	}

	public AcePipelinepointdatasInsertBP getInsertBP() {
		if(insertBP == null){
			insertBP = new AcePipelinepointdatasInsertBP();
		}
		return insertBP;
	}
	
	public AcePipelinepointdatasUpdateBP getUpdateBP() {
		if(updateBP == null){
			updateBP = new AcePipelinepointdatasUpdateBP();
		}
		return updateBP;
	}
	
	public AcePipelinepointdatasDeleteBP getDeleteBP() {
		if(deleteBP == null){
			deleteBP = new AcePipelinepointdatasDeleteBP();
		}
		return deleteBP;
	}
}
