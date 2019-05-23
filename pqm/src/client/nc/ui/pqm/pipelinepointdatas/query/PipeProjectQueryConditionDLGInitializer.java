package nc.ui.pqm.pipelinepointdatas.query;

import java.util.ArrayList;

import nc.ui.pubapp.uif2app.query2.IQueryConditionDLGInitializer;
import nc.ui.pubapp.uif2app.query2.QueryConditionDLGDelegator;
import nc.ui.pubapp.uif2app.query2.refregion.QueryDefaultOrgFilter;
import nc.vo.pqm.pipelinepointdatas.PipelinepointdatasVO;

public class PipeProjectQueryConditionDLGInitializer implements
		IQueryConditionDLGInitializer {
	
/*	private BatchBillTableModel  model;

	public BatchBillTableModel getModel() {
		return model;
	}
	public void setModel(BatchBillTableModel model) {
		this.model = model;
	}*/


	@Override
	public void initQueryConditionDLG(
			QueryConditionDLGDelegator condDLGDelegator) {
		//设置主组织参照只包含用户有权限的组织
		//condDLGDelegator.setRefFilter(PipelinepointdatasVO.PK_ORG, new MainOrgWithPermissionOrgFilter(model));
		ArrayList<String> targetFields = new ArrayList<String>();
		targetFields.add(PipelinepointdatasVO.PK_PROJECT);
		QueryDefaultOrgFilter orgFilter = new QueryDefaultOrgFilter(condDLGDelegator,PipelinepointdatasVO.PK_ORG,targetFields);
		orgFilter.addEditorListener();
	}

}
