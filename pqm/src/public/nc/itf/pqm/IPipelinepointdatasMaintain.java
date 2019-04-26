package nc.itf.pqm;

import nc.itf.pubapp.pub.smart.ISmartService;
import nc.ui.querytemplate.querytree.IQueryScheme;
import nc.vo.pub.BusinessException;
import nc.vo.pqm.pipelinepointdatas.PipelinepointdatasVO;

public interface IPipelinepointdatasMaintain extends ISmartService{

	 public PipelinepointdatasVO[] query(IQueryScheme queryScheme)
      throws BusinessException, Exception;
}