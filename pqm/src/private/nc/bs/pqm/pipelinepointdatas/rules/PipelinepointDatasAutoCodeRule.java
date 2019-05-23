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
import nc.vo.pqm.pipelinepointdatas.AggPipelinepointdatasVO;
import nc.vo.pqm.pipelinepointdatas.PipelinepointdatasVO;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;

/**
 * ���ߵ������Զ��������
 * 
 * @author wugy
 * @since 2019-04-26 18:06:00
 *
 */
public class PipelinepointDatasAutoCodeRule implements IRule<AggPipelinepointdatasVO> {
	
	private BaseDAO dao;

	private BaseDAO getDAO() { // �������ݿ�����

		if (dao == null) {
			dao = new BaseDAO();
		}
		return dao;
	}

	@Override
	public void process(AggPipelinepointdatasVO[] vos) {
		if (vos == null || vos.length == 0) {
			ExceptionUtils.wrappBusinessException("���ݲ���Ϊ�գ�");
		}
				
		Map<String, Integer> projMaxCodeMap = new HashMap<String, Integer>();
				
		for (int i = 0; i < vos.length; i++) {
			AggPipelinepointdatasVO vo = vos[i];
			PipelinepointdatasVO hvo = vo.getParentVO();
			Object code = hvo.getAttributeValue("code");
			if( code!= null){
				continue;
			}
			Object pk_projectobj = hvo.getAttributeValue("pk_project");
			if(pk_projectobj == null){
				hvo.setAttributeValue("code", 999999999);
				continue;
			}
			String pk_project = (String) pk_projectobj;
			if(projMaxCodeMap.containsKey(pk_project)){
				int maxcode = projMaxCodeMap.get(pk_project);
				hvo.setAttributeValue("code", ++maxcode);
				projMaxCodeMap.put(pk_project, maxcode);
			}else{
				int maxcode = queryMaxCode(pk_project);
				hvo.setAttributeValue("code", ++maxcode);
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
