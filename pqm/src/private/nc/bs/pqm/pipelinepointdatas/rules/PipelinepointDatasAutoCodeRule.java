package nc.bs.pqm.pipelinepointdatas.rules;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import nc.bs.dao.BaseDAO;
import nc.bs.dao.DAOException;
import nc.bs.framework.common.NCLocator;
import nc.impl.pubapp.pattern.rule.IRule;
import nc.itf.uif.pub.IUifService;
import nc.jdbc.framework.processor.BeanListProcessor;
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
	
	private BaseDAO dao;

	private BaseDAO getDAO() { // 建立数据库连接

		if (dao == null) {
			dao = new BaseDAO();
		}
		return dao;
	}

	@Override
	public void process(PipelinepointdatasVO[] vos) {
		if (vos == null || vos.length == 0) {
			ExceptionUtils.wrappBusinessException("数据不能为空！");
		}
				
		Map<String, Integer> projMaxCodeMap = new HashMap<String, Integer>();
				
		for (int i = 0; i < vos.length; i++) {
			PipelinepointdatasVO vo = vos[i];
			Object code = vo.getAttributeValue("code");
			if( code!= null){
				continue;
			}
			//vo.setAttributeValue("pk_project", "1002A910000000NOZORS");
			Object pk_projectobj = vo.getAttributeValue("pk_project");
			if(pk_projectobj == null){
				vo.setAttributeValue("code", 999999999);
				continue;
			}
			String pk_project = (String) pk_projectobj;
			if(projMaxCodeMap.containsKey(pk_project)){
				int maxcode = projMaxCodeMap.get(pk_project);
				vo.setAttributeValue("code", ++maxcode);
				projMaxCodeMap.put(pk_project, maxcode);
			}else{
				int maxcode = queryMaxCode(pk_project);
				vo.setAttributeValue("code", ++maxcode);
				projMaxCodeMap.put(pk_project, maxcode);
			}									
		}		
	}

	@SuppressWarnings("unchecked")
	private int queryMaxCode(String pk_project) {		
		int maxcode = 0;
		String querySql = "select * from(select * from pqm_pipelinepointdatas where pk_project = '"+pk_project+"' order by code desc) where rownum=1";
		try {
			ArrayList<PipelinepointdatasVO> slist = (ArrayList<PipelinepointdatasVO>) getDAO()
					.executeQuery(querySql,
							new BeanListProcessor(PipelinepointdatasVO.class));
			if(slist != null && slist.size() > 0){
				maxcode = (int) slist.get(0).getAttributeValue("code");
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return maxcode;
	}

}
