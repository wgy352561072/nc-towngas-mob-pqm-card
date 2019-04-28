package nc.bs.pqm.pipelinepointdatas.rules;

import nc.bs.framework.common.NCLocator;
import nc.impl.pubapp.pattern.rule.IRule;
import nc.itf.uif.pub.IUifService;
import nc.uif.pub.exception.UifException;
import nc.vo.pqm.pipelinepointdatas.PipelinepointdatasVO;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;

/**
 * 管线点数据自动编码规则
 * 
 * @author wugy
 * @since 2019-04-26 18:06:00
 *
 */
public class PipelinepointDatasAutoCodeRule implements IRule<PipelinepointdatasVO> {

	@Override
	public void process(PipelinepointdatasVO[] vos) {
		if (vos == null || vos.length == 0) {
			ExceptionUtils.wrappBusinessException("数据不能为空！");
		}
		
		int maxcode = queryMaxCode();;
				
		for (int i = 0; i < vos.length; i++) {
			PipelinepointdatasVO vo = vos[i];
			vo.setAttributeValue("code", maxcode+1);
		}
		
	}

	private int queryMaxCode() {
		IUifService service = NCLocator.getInstance().lookup(IUifService.class);
		int maxcode = 0;
		try {
			maxcode = (int) service.findColValue("pqm_pipelinepointdatas", "code", "nvl(dr,0) = 0");
		} catch (UifException e) {
			e.printStackTrace();
		}
		return maxcode;
	}

}
