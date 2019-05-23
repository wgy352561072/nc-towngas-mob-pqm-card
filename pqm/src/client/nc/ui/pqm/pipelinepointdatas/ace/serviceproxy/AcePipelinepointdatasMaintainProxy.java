package nc.ui.pqm.pipelinepointdatas.ace.serviceproxy;

import nc.bs.framework.common.NCLocator;
import nc.itf.pqm.IPipelinepointdatasMaintain;
import nc.ui.pubapp.pub.task.ISingleBillService;
import nc.ui.pubapp.uif2app.actions.IDataOperationService;
import nc.ui.pubapp.uif2app.query2.model.IQueryService;
import nc.ui.querytemplate.querytree.IQueryScheme;
import nc.vo.pqm.pipelinepointdatas.AggPipelinepointdatasVO;
import nc.vo.pub.BusinessException;
import nc.vo.pubapp.pattern.model.entity.bill.IBill;

/**
 * 示例单据的操作代理
 * 
 * @author author
 * @version tempProject version
 */
public class AcePipelinepointdatasMaintainProxy implements IQueryService,IDataOperationService, ISingleBillService<AggPipelinepointdatasVO> {
	
	IPipelinepointdatasMaintain service;
	
	@Override
	public Object[] queryByQueryScheme(IQueryScheme queryScheme)
			throws Exception {
		return getService().query(queryScheme);
	}
	
	private IPipelinepointdatasMaintain getService(){
		if (service == null){
			service = NCLocator.getInstance().lookup(
					IPipelinepointdatasMaintain.class);
		}
		return service;
	}

	@Override
	public AggPipelinepointdatasVO operateBill(AggPipelinepointdatasVO bill)
			throws Exception {
		getService().deleteBill(new AggPipelinepointdatasVO[] { bill });
        return bill;
	}

	@Override
	public IBill[] insert(IBill[] value) throws BusinessException {
		return getService().insertBill((AggPipelinepointdatasVO[]) value);
	}

	@Override
	public IBill[] update(IBill[] value) throws BusinessException {
		return getService().updateBill((AggPipelinepointdatasVO[]) value);
	}

	@Override
	public IBill[] delete(IBill[] value) throws BusinessException {
		// TODO 自动生成的方法存根
		return null;
	}

}