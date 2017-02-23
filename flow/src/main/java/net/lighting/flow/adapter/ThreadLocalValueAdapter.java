package net.lighting.flow.adapter;

import java.util.HashMap;
import java.util.Map;

import net.lighting.flow.base.ValueAdapter;
import net.lighting.flow.util.FlowUtil;

public class ThreadLocalValueAdapter implements ValueAdapter {

	private ThreadLocal<Map<String, Object>> local = new ThreadLocal<Map<String, Object>>();
	
	@Override
	public Object get(String key) {
		return getDataMap().get(key);
	}

	@Override
	public void set(String key, Object data) {
		getDataMap().put(key, data);
	}

	private Map<String, Object> getDataMap() {
		Map<String, Object> dataMap = local.get();
		if (dataMap == null) {
			dataMap = new HashMap<String, Object>();
			local.set(dataMap);
		}
		return dataMap;
	}
	
	@Override
    public String getText(String key) {
        return FlowUtil.getText(get(key));
    }
	
}
