package nc.ui.pqm.pipelinepointdatas.action;

import nc.ui.pubapp.uif2app.actions.batch.BatchAddLineAction;
import nc.vo.pqm.pipelinepointdatas.PipelinepointdatasVO;
/**
  batch addLine or insLine action autogen
*/
public class PipelinepointdatasAddLineAction extends BatchAddLineAction {

	private static final long serialVersionUID = 1L;

	@Override
	protected void setDefaultData(Object obj) {
		super.setDefaultData(obj);
		PipelinepointdatasVO singleDocVO = (PipelinepointdatasVO) obj;
		singleDocVO.setPk_group(this.getModel().getContext().getPk_group());
		singleDocVO.setPk_org(this.getModel().getContext().getPk_org());
	}
}