package nc.ui.pqm.pipelinepointdatas.action;

import nc.vo.pm.util.StringUtil;



/**
 * 
 * 管线点数据查询按钮
 * 
 */
public class PipelinepointdatasQuaryAction extends nc.ui.uif2.actions.QueryAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void executeQuery(String sqlWhere) {
		if (StringUtil.isNotEmpty(sqlWhere)) {
			sqlWhere = " and " + sqlWhere;
		} 
		super.executeQuery(sqlWhere);
	}



}