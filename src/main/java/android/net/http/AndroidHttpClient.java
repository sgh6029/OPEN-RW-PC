package android.net.http;

import org.apache.http.*;
import org.apache.http.client.*;
import org.apache.http.client.methods.*;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.*;
import org.apache.http.conn.scheme.*;
import org.apache.http.impl.client.*;
import org.apache.http.impl.conn.tsccm.*;
import org.apache.http.params.*;
import org.apache.http.protocol.*;

import android.content.Context;
import android.net.SSLSessionCache;
import android.net.http.AndroidHttpClient;
import android.util.Base64;
import android.content.*;
import android.net.*;
import android.util.*;

import java.io.*;
import java.net.*;

public final class AndroidHttpClient implements HttpClient {
    public static long a;
    private static String[] b;
    private static final HttpRequestInterceptor c;
    private final HttpClient d;
    private RuntimeException e;
    private volatile android.net.http.b f;

    public static AndroidHttpClient a(String arg0, Context arg1) {
        BasicHttpParams var2 = new BasicHttpParams();
        HttpConnectionParams.setStaleCheckingEnabled(var2, false);
        HttpConnectionParams.setConnectionTimeout(var2, 60000);
        HttpConnectionParams.setSoTimeout(var2, 60000);
        HttpConnectionParams.setSocketBufferSize(var2, 8192);
        HttpClientParams.setRedirecting(var2, false);

        SSLSessionCache var3 = arg1 != null ? new SSLSessionCache(arg1) : null;

        HttpProtocolParams.setUserAgent(var2, arg0);

        SchemeRegistry var4 = new SchemeRegistry();
        var4.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        // Use SSLSocketFactory instead of deprecated SSLCertificateSocketFactory.getHttpSocketFactory
        var4.register(new Scheme("https", org.apache.http.conn.ssl.SSLSocketFactory.getSocketFactory(), 443));

        ThreadSafeClientConnManager var5 = new ThreadSafeClientConnManager(var2, var4);
        return new AndroidHttpClient(var5, var2);
    }

    public static AndroidHttpClient a(String arg0) {
        return a(arg0, null);
    }

    private AndroidHttpClient(ClientConnectionManager arg0, HttpParams arg1) {
        super();
        this.e = new IllegalStateException("AndroidHttpClient created and never closed");
        this.d = new DefaultHttpClient(arg0, arg1);
    }

    protected void finalize() throws Throwable {
        super.finalize();
        if (this.e != null) {
            this.e = null;
        }
    }

    public void a() {
        if (this.e != null) {
            this.getConnectionManager().shutdown();
            this.e = null;
        }
    }

    public HttpParams getParams() {
        return this.d.getParams();
    }

    public ClientConnectionManager getConnectionManager() {
        return this.d.getConnectionManager();
    }

    public HttpResponse execute(HttpUriRequest arg0) throws IOException {
        return this.d.execute(arg0);
    }

    public HttpResponse execute(HttpUriRequest arg0, HttpContext arg1) throws IOException {
        return this.d.execute(arg0, arg1);
    }

    public HttpResponse execute(HttpHost arg0, HttpRequest arg1) throws IOException {
        return this.d.execute(arg0, arg1);
    }

    public HttpResponse execute(HttpHost arg0, HttpRequest arg1, HttpContext arg2) throws IOException {
        return this.d.execute(arg0, arg1, arg2);
    }

    public Object execute(HttpUriRequest arg0, ResponseHandler arg1) throws IOException {
        return this.d.execute(arg0, arg1);
    }

    public Object execute(HttpUriRequest arg0, ResponseHandler arg1, HttpContext arg2) throws IOException {
        return this.d.execute(arg0, arg1, arg2);
    }

    public Object execute(HttpHost arg0, HttpRequest arg1, ResponseHandler arg2) throws IOException {
        return this.d.execute(arg0, arg1, arg2);
    }

    public Object execute(HttpHost arg0, HttpRequest arg1, ResponseHandler arg2, HttpContext arg3) throws IOException {
        return this.d.execute(arg0, arg1, arg2, arg3);
    }

    private static String b(HttpUriRequest arg0, boolean arg1) throws IOException {
        StringBuilder var2 = new StringBuilder();
        var2.append("curl ");
        var2.append("-X ");
        var2.append(arg0.getMethod());
        var2.append(" ");

        Header[] var3 = arg0.getAllHeaders();
        int var4 = var3.length;
        for (int var5 = 0; var5 < var4; var5++) {
            Header var6 = var3[var5];
            if (arg1 || (!var6.getName().equals("Authorization") && !var6.getName().equals("Cookie"))) {
                var2.append("--header \"");
                var2.append(var6.toString().trim());
                var2.append("\" ");
            }
        }

        URI var3_2 = arg0.getURI();
        if (arg0 instanceof RequestWrapper) {
            HttpRequest var4_2 = ((RequestWrapper) arg0).getOriginal();
            if (var4_2 instanceof HttpUriRequest) {
                var3_2 = ((HttpUriRequest) var4_2).getURI();
            }
        }

        var2.append("\"");
        var2.append(var3_2);
        var2.append("\"");

        if (arg0 instanceof HttpEntityEnclosingRequest) {
            HttpEntityEnclosingRequest var4_3 = (HttpEntityEnclosingRequest) arg0;
            HttpEntity var5_2 = var4_3.getEntity();
            if (var5_2 != null && var5_2.isRepeatable()) {
                if (var5_2.getContentLength() < 1024) {
                    ByteArrayOutputStream var6_2 = new ByteArrayOutputStream();
                    var5_2.writeTo(var6_2);

                    if (a(arg0)) {
                        String var7 = Base64.encodeToString(var6_2.toByteArray(), 2);
                        var2.insert(0, "echo '" + var7 + "' | base64 -d > /tmp/$$.bin; ");
                        var2.append(" --data-binary @/tmp/$$.bin");
                    } else {
                        String var7_2 = var6_2.toString();
                        var2.append(" --data-ascii \"");
                        var2.append(var7_2);
                        var2.append("\"");
                    }
                } else {
                    var2.append(" [TOO MUCH DATA TO INCLUDE]");
                }
            }
        }

        return var2.toString();
    }

    private static boolean a(HttpUriRequest arg0) {
        Header[] var1 = arg0.getHeaders("content-encoding");
        if (var1 != null) {
            for (Header var5 : var1) {
                if ("gzip".equalsIgnoreCase(var5.getValue())) {
                    return true;
                }
            }
        }

        var1 = arg0.getHeaders("content-type");
        if (var1 != null) {
            for (Header var5_2 : var1) {
                String[] var6 = b;
                int var7 = var6.length;
                for (int var8 = 0; var8 < var7; var8++) {
                    String var9 = var6[var8];
                    if (var5_2.getValue().startsWith(var9)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    static HttpRequestInterceptor b() {
        return c;
    }

    static android.net.http.b a(AndroidHttpClient arg0) {
        return arg0.f;
    }

    static String a(HttpUriRequest arg0, boolean arg1) throws IOException {
        return b(arg0, arg1);
    }

    static {
        a = 256L;
        b = new String[] { "text/", "application/xml", "application/json" };
        c = new HttpRequestInterceptor() {
            public void process(HttpRequest request, HttpContext context) throws HttpException, IOException {
                // Empty implementation
            }
        };
    }
}
