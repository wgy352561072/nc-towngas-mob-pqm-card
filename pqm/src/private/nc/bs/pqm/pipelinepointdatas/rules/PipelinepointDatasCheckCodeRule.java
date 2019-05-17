package nc.bs.pqm.pipelinepointdatas.rules;

import nc.bs.framework.common.NCLocator;
import nc.impl.pubapp.pattern.rule.IRule;
import nc.itf.uif.pub.IUifService;
import nc.uif.pub.exception.UifException;
import nc.vo.pqm.pipelinepointdatas.PipelinepointdatasVO;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;

/**
 * 管线点数据编码重复校验
 * @author wugy
 * @version 2019-04-10 16:11:26
 *
 */
public class PipelinepointDatasCheckCodeRule implements
		IRule<PipelinepointdatasVO> {

	@Override
	public void process(PipelinepointdatasVO[] vos) {
		if (vos == null || vos.length == 0) {
			ExceptionUtils.wrappBusinessException("数据不能为空！");
		}
		for (int i = 0; i < vos.length; i++) {
			PipelinepointdatasVO vo = vos[i];
			Object code = vo.getAttributeValue("code");
			if (code == null) {
				ExceptionUtils.wrappBusinessException("管线点数据编码不能为空！");
			}
			Object pk_pipelinepointdatas = vo
					.getAttributeValue("pk_pipelinepointdatas");
			//vo.setAttributeValue("pk_project", "1002A910000000NOZORS");
			Object pk_projectobj = vo.getAttributeValue("pk_project");
			if (pk_projectobj == null) {
				continue;
			}
			String pk_project = (String) pk_projectobj;
			String existpk = null;
			IUifService service = NCLocator.getInstance().lookup(
					IUifService.class);
			if (pk_pipelinepointdatas == null) {// 新增的单据
				try {
					existpk = (String) service.findColValue(
							"pqm_pipelinepointdatas", "pk_pipelinepointdatas",
							"code = " + code + " and pk_project = '"
									+ pk_project + "' and nvl(dr,0) = 0");
				} catch (UifException e) {
					e.printStackTrace();
				}
			} else {// 修改的单据
				try {
					existpk = (String) service.findColValue(
							"pqm_pipelinepointdatas", "pk_pipelinepointdatas",
							"code = " + code
									+ " and pk_pipelinepointdatas <> '"
									+ pk_pipelinepointdatas.toString()
									+ "' and pk_project = '" + pk_project
									+ "'  and nvl(dr,0) = 0");
				} catch (UifException e) {
					e.printStackTrace();
				}
			}
			if (existpk != null) {
				ExceptionUtils.wrappBusinessException("管线点数据编码:" + code
						+ "存在重复！");
			}
		}
	}
}
