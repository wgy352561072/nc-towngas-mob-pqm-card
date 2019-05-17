package nc.bs.pqm.pipelinepointdatas.rules;

import nc.impl.pubapp.pattern.rule.IRule;
import nc.vo.pqm.pipelinepointdatas.PipelinepointdatasVO;
import nc.vo.pub.lang.UFDateTime;
import nc.vo.pubapp.AppContext;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;

/**
 * 保存前人员时间记录
 * 
 * @author wugy
 * @since 2019-03-27 09:21:00
 *
 */
public class PipelinepointDatasSaveRecordRule implements IRule<PipelinepointdatasVO> {

	@Override
	public void process(PipelinepointdatasVO[] vos) {
		if (vos == null || vos.length == 0) {
			ExceptionUtils.wrappBusinessException("数据不能为空！");
		}
		String userid = AppContext.getInstance().getPkUser();
		UFDateTime nowTime = new UFDateTime();
		for (int i = 0; i < vos.length; i++) {
			PipelinepointdatasVO vo = vos[i];
			Object pk_pipelinepointdatas = vo.getAttributeValue("pk_pipelinepointdatas");
			if(pk_pipelinepointdatas == null){//新增的单据
				if(vo.getAttributeValue("creator") == null){
					vo.setAttributeValue("creator", userid);
				}
				if(vo.getAttributeValue("creationtime") == null){
					vo.setAttributeValue("creationtime", nowTime);
				}								
			}else{//修改的单据
				vo.setAttributeValue("modifier", userid);
				vo.setAttributeValue("modifiedtime", nowTime);
			}
		}
	}

}
