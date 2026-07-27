/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.http.HttpRequestInterceptor
 *  org.apache.http.conn.ClientConnectionManager
 *  org.apache.http.impl.client.DefaultHttpClient
 *  org.apache.http.params.HttpParams
 *  org.apache.http.protocol.BasicHttpContext
 *  org.apache.http.protocol.BasicHttpProcessor
 *  org.apache.http.protocol.HttpContext
 */
package android.net.http;

import org.apache.http.HttpRequestInterceptor;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.BasicHttpProcessor;
import org.apache.http.protocol.HttpContext;

import android.net.http.AndroidHttpClient;
import android.net.http.a;


class AndroidHttpClient$2 extends DefaultHttpClient {
    final AndroidHttpClient a;

    AndroidHttpClient$2(AndroidHttpClient arg0, ClientConnectionManager arg1, HttpParams arg2) {
        super(arg1, arg2);
        this.a = arg0;
    }

    protected BasicHttpProcessor createHttpProcessor() {
        BasicHttpProcessor var1 = super.createHttpProcessor();
        var1.addRequestInterceptor(AndroidHttpClient.b());
        var1.addRequestInterceptor(new android.net.http.a(this.a, null));
        return var1;
    }

    protected HttpContext createHttpContext() {
        BasicHttpContext var1 = new BasicHttpContext();
        var1.setAttribute("http.authscheme-registry", this.getAuthSchemes());
        var1.setAttribute("http.cookiespec-registry", this.getCookieSpecs());
        var1.setAttribute("http.auth.credentials-provider", this.getCredentialsProvider());
        return var1;
    }
}

