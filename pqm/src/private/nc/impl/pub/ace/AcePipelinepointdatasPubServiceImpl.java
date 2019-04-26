package nc.impl.pub.ace;
import nc.bs.pqm.pipelinepointdatas.ace.bp.AcePipelinepointdatasBP;
import nc.impl.pubapp.pub.smart.SmartServiceImpl;
import nc.ui.querytemplate.querytree.IQueryScheme;
import nc.vo.pub.ISuperVO;
import nc.vo.pqm.pipelinepointdatas.PipelinepointdatasVO;
import nc.vo.uif2.LoginContext;

public abstract class AcePipelinepointdatasPubServiceImpl extends SmartServiceImpl {
	public PipelinepointdatasVO[] pubquerybasedoc(IQueryScheme querySheme)
			throws nc.vo.pub.BusinessException {
		return new AcePipelinepointdatasBP().queryByQueryScheme(querySheme);
	}
}