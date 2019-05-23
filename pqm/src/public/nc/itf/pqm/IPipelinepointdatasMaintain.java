package nc.itf.pqm;

import nc.ui.querytemplate.querytree.IQueryScheme;
import nc.vo.pqm.pipelinepointdatas.AggPipelinepointdatasVO;
import nc.vo.pub.BusinessException;

public interface IPipelinepointdatasMaintain {
	
	/**
	 * ÐÂÔö
	 * 
	 * @param context
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	public AggPipelinepointdatasVO[] insertBill(AggPipelinepointdatasVO[] billVOs)
			throws BusinessException;

	/**
	 * ÐÞ¸Ä
	 * 
	 * @param context
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	public AggPipelinepointdatasVO[] updateBill(AggPipelinepointdatasVO[] billVOs)
			throws BusinessException;

	/**
	 * É¾³ý
	 * 
	 * @param context
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	public void deleteBill(AggPipelinepointdatasVO[] billVOs) throws BusinessException;



	public AggPipelinepointdatasVO[] query(IQueryScheme queryScheme)
			throws BusinessException;


}
