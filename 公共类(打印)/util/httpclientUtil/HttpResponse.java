package com.cakes.frameworks.util.httpclientUtil;
import org.apache.commons.httpclient.Header;
import java.io.UnsupportedEncodingException;

/* *
 *类名：HttpResponse
 *功能：Http返回对象的封装
 *详细：封装Http返回信息  默认编码是UTF-8
 */

public class HttpResponse {
	
	public HttpResponse(){}
	public HttpResponse(String input_charset){
		this.input_charset=input_charset;
	}

	private String input_charset="UTF-8";
	
    /**
     * 返回中的Header信息
     */
    private Header[] responseHeaders;

    /**
     * String类型的result
     */
    private String   stringResult;

    /**
     * btye类型的result
     */
    private byte[]   byteResult;

    public Header[] getResponseHeaders() {
        return responseHeaders;
    }

    public void setResponseHeaders(Header[] responseHeaders) {
        this.responseHeaders = responseHeaders;
    }

    public byte[] getByteResult() {
        if (byteResult != null) {
            return byteResult;
        }
        if (stringResult != null) {
            return stringResult.getBytes();
        }
        return null;
    }

    public void setByteResult(byte[] byteResult) {
        this.byteResult = byteResult;
    }

    public String getStringResult() throws UnsupportedEncodingException {
        if (stringResult != null) {
            return stringResult;
        }
        if (byteResult != null) {
            return new String(byteResult, input_charset);
        }
        return null;
    }

    public void setStringResult(String stringResult) {
        this.stringResult = stringResult;
    }
	public String getInput_charset() {
		return input_charset;
	}
	public void setInput_charset(String input_charset) {
		this.input_charset = input_charset;
	} 
}
