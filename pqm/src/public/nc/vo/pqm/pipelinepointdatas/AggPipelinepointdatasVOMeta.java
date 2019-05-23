package nc.vo.pqm.pipelinepointdatas;

import nc.vo.pubapp.pattern.model.meta.entity.bill.AbstractBillMeta;

public class AggPipelinepointdatasVOMeta extends AbstractBillMeta{
	
	public AggPipelinepointdatasVOMeta(){
		this.init();
	}
	
	private void init() {
		this.setParent(nc.vo.pqm.pipelinepointdatas.PipelinepointdatasVO.class);
	}
}