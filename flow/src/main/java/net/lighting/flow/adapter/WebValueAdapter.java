package net.lighting.flow.adapter;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.lighting.flow.base.K;
import net.lighting.flow.base.ValueAdapter;
import net.lighting.flow.util.FlowUtil;

public class WebValueAdapter implements ValueAdapter {
    
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private Map<String, Object> data = new HashMap<String, Object>();    
    
    public WebValueAdapter() {
        
    }
    
    public WebValueAdapter(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.session = request.getSession();
        this.response = response;
    }

    @Override
    public Object get(String key) {
        if (key.startsWith(K.para_)) {
            return request.getParameter(key.substring(K.para_.length()));
        } else if (key.startsWith(K.request_)) {
            return request.getAttribute(key.substring(K.request_.length()));
        } else if (key.startsWith(K.session_)) {
            return session.getAttribute(key.substring(K.session_.length()));
        } else if (key.startsWith(K.cookie_)) {
            Cookie[] cookies = request.getCookies();
            String name = key.substring(K.cookie_.length());
            for (Cookie c : cookies) {
                if (name.equals(c.getName())) {
                    return c;
                }
            }
        } else {
            return data.get(key);
        }
        return null;
    }

    @Override
    public void set(String key, Object value) {
        if (key.startsWith(K.request_)) {
            request.setAttribute(key.substring(K.request_.length()), value);
        } else if (key.startsWith(K.session_)) {
            session.setAttribute(key.substring(K.session_.length()), value);
        } else  if (key.startsWith(K.cookie_)) {
            response.addCookie((Cookie)value);
        } else {
            data.put(key, value);
        }
    }
    
    @Override
    public String getText(String key) {
        return FlowUtil.getText(get(key));
    }
    
}
