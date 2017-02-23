package net.lighting.flow.adapter;

import java.util.HashMap;
import java.util.Map;

import net.lighting.flow.base.ValueAdapter;
import net.lighting.flow.util.FlowUtil;

public class SimpleValueAdapter implements ValueAdapter {

	Map<String, Object> dataMap = new HashMap<String, Object>();
	
	@Override
	public Object get(String key) {
		return dataMap.get(key);
	}

	@Override
	public void set(String key, Object data) {
		dataMap.put(key, data);
	}

    @Override
    public String getText(String key) {
        return FlowUtil.getText(get(key));
    }

}
