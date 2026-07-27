package test.rudp;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import test.rudp.packet.ACKPacket;
import test.rudp.packet.DATPacket;
import test.rudp.packet.EAKPacket;
import test.rudp.packet.FINPacket;
import test.rudp.packet.NullPacket;
import test.rudp.packet.RSTPacket;
import test.rudp.packet.SYNPacket;

//h
public class ReliableSocket extends Socket {
   protected DatagramSocket c;// c
   protected SocketAddress d;// d
   protected o e;
   protected q f;
   private byte[] a_f;
   private boolean b;
   private boolean i;
   private boolean j;
   private boolean k;
   private int l;
   private int m;
   private boolean n;
   private boolean o;
   private int p;
   private Object q;
   private Object r;
   private ArrayList s;
   private ArrayList t;
   protected r g;
   private ArrayList u;
   private ArrayList v;
   private ArrayList w;
   private Object x;
   private i y;
   private Thread z;
   private int A;
   private int B;
   private int C;
   private int D;
   public boolean h;
   private test.rudp.packet.TaskScheduler E;
   private test.rudp.packet.TaskScheduler F;
   private test.rudp.packet.TaskScheduler G;
   private test.rudp.packet.TaskScheduler H;
   private static final boolean I = Boolean.getBoolean("net.rudp.debug");

   public ReliableSocket() throws SocketException {
      this(new r());
   }

   public ReliableSocket(r var1) throws SocketException {
      this(new DatagramSocket(), var1);
   }

   protected ReliableSocket(DatagramSocket var1) {
      this(var1, new r());
   }

   protected ReliableSocket(DatagramSocket var1, r var2) {
      this.b = false;
      this.i = false;
      this.j = false;
      this.k = true;
      this.l = 0;
      this.m = 0;
      this.n = false;
      this.o = false;
      this.p = -1;
      this.q = new Object();
      this.r = new Object();
      this.s = new ArrayList();
      this.t = new ArrayList();
      this.g = test.rudp.r.a;
      this.u = new ArrayList();
      this.v = new ArrayList();
      this.w = new ArrayList();
      this.x = new Object();
      this.y = new i();
      this.A = 32;
      this.B = 32;
      this.h = false;
      this.E = new test.rudp.packet.TaskScheduler("rudp-NullSegmentTimer", new l(this, null));
      this.F = new test.rudp.packet.TaskScheduler("rudp-RetransmissionTimer", new n(this, null));
      this.G = new test.rudp.packet.TaskScheduler("rudp-CumulativeAckTimer", new j(this, null));
      this.H = new test.rudp.packet.TaskScheduler("rudp-KeepAliveTimer", new k(this, null));
      if (var1 == null) {
         throw new NullPointerException("sock");
      } else {
         this.a(var1, var2);
      }
   }

   protected void a(DatagramSocket var1, r var2) {
      this.c = var1;
      this.g = var2;
      this.C = (this.g.a() - 6) * 32;
      this.D = (this.g.a() - 6) * 32;
      if (this.z == null) {
         this.z = new m(this);
         this.z.start();
      }

   }

   public void bind(SocketAddress var1) throws SocketException {
      this.c.bind(var1);
   }

   public void connect(SocketAddress var1) {
      try {
         this.connect(var1, 0);
      } catch (SocketException e) {
         e.printStackTrace();
      } catch (SocketTimeoutException e) {
         e.printStackTrace();
      }
   }

   public void connect(SocketAddress var1, int var2) throws SocketException, SocketTimeoutException {
      if (var1 == null) {
         throw new IllegalArgumentException("connect: The address can't be null");
      } else if (var2 < 0) {
         throw new IllegalArgumentException("connect: timeout can't be negative");
      } else if (this.isClosed()) {
         throw new SocketException("Socket is closed");
      } else if (this.isConnected()) {
         throw new SocketException("already connected");
      } else if (!(var1 instanceof InetSocketAddress)) {
         throw new IllegalArgumentException("Unsupported address type");
      } else {
         this.d = (InetSocketAddress) var1;
         this.f();
         this.l = 2;
         Random var3 = new Random(System.currentTimeMillis());
         SYNPacket var4 = new SYNPacket(this.y.a(var3.nextInt(255)), this.g.b(), this.g.a(), this.g.h(), this.g.i(),
               this.g.g(), this.g.c(), this.g.d(), this.g.e(), this.g.f());
         this.e((test.rudp.packet.RUDPPacket) var4);
         boolean var5 = false;
         synchronized (this) {
            if (!this.isConnected()) {
               try {
                  if (var2 == 0) {
                     this.wait();
                  } else {
                     long var7 = System.currentTimeMillis();
                     this.wait((long) var2);
                     if (System.currentTimeMillis() - var7 >= (long) var2) {
                        var5 = true;
                     }
                  }
               } catch (InterruptedException var12) {
                  var12.printStackTrace();
               }
            }
         }

         if (this.l != 3) {
            synchronized (this.u) {
               this.u.clear();
               this.u.notifyAll();
            }

            this.y.l();
            this.F.cancel();
            switch (this.l) {
               case 0:
               case 4:
                  this.l = 0;
                  throw new SocketException("Socket closed");
               case 1:
               case 3:
               default:
                  return;
               case 2:
                  this.k();
                  this.l = 0;
                  if (var5) {
                     throw new SocketTimeoutException();
                  } else {
                     throw new SocketException("Connection refused");
                  }
            }
         }
      }
   }

   public SocketChannel getChannel() {
      return null;
   }

   public InetAddress getInetAddress() {
      return !this.isConnected() ? null : ((InetSocketAddress) this.d).getAddress();
   }

   public int getPort() {
      return !this.isConnected() ? 0 : ((InetSocketAddress) this.d).getPort();
   }

   public SocketAddress getRemoteSocketAddress() {
      return !this.isConnected() ? null : new InetSocketAddress(this.getInetAddress(), this.getPort());
   }

   public SocketAddress c() {
      return this.d;
   }

   public InetAddress getLocalAddress() {
      return this.c.getLocalAddress();
   }

   public int getLocalPort() {
      return this.c.getLocalPort();
   }

   public SocketAddress getLocalSocketAddress() {
      return this.c.getLocalSocketAddress();
   }

   public synchronized InputStream getInputStream() throws SocketException {
      if (this.isClosed()) {
         throw new SocketException("Socket is closed");
      } else if (!this.isConnected()) {
         throw new SocketException("Socket is not connected");
      } else if (this.isInputShutdown()) {
         throw new SocketException("Socket input is shutdown");
      } else {
         if (this.e == null) {
            this.e = new o(this);
         }

         return this.e;
      }
   }

   public synchronized OutputStream getOutputStream() throws SocketException {
      if (this.isClosed()) {
         throw new SocketException("Socket is closed");
      } else if (!this.isConnected()) {
         throw new SocketException("Socket is not connected");
      } else if (this.isOutputShutdown()) {
         throw new SocketException("Socket output is shutdown");
      } else {
         if (this.f == null) {
            this.f = new q(this);
         }

         return this.f;
      }
   }

   public void d() {
      this.b = true;
      this.l = 0;
      this.c.close();
   }

   public synchronized void close() {
      synchronized (this.q) {
         if (!this.isClosed()) {
            this.g();
            switch (this.l) {
               case 0:
                  this.c.close();
                  break;
               case 1:
               case 3:
               case 4:
                  this.a((test.rudp.packet.RUDPPacket) (new FINPacket(this.y.a())));
                  this.e();
                  break;
               case 2:
                  synchronized (this) {
                     this.notify();
                  }
            }

            if (this.l != 0) {
               this.p = this.l;
            }

            this.b = true;
            this.l = 0;
            this.l();
            synchronized (this.u) {
               this.u.notify();
            }

            synchronized (this.w) {
               this.w.notify();
            }

         }
      }
   }

   public boolean isBound() {
      return this.c.isBound();
   }

   public boolean isConnected() {
      return this.i;
   }

   public boolean isClosed() {
      synchronized (this.q) {
         return this.b;
      }
   }

   public void setSoTimeout(int var1) {
      if (var1 < 0) {
         throw new IllegalArgumentException("timeout < 0");
      } else {
         this.m = var1;
      }
   }

   public synchronized void setSendBufferSize(int var1) throws SocketException {
      if (var1 <= 0) {
         throw new IllegalArgumentException("negative receive size");
      } else if (this.isClosed()) {
         throw new SocketException("Socket is closed");
      } else if (!this.isConnected()) {
         this.C = var1;
      }
   }

   public synchronized int getSendBufferSize() throws SocketException {
      if (this.isClosed()) {
         throw new SocketException("Socket is closed");
      } else {
         return this.C;
      }
   }

   public synchronized void setReceiveBufferSize(int var1) throws SocketException {
      if (var1 <= 0) {
         throw new IllegalArgumentException("negative send size");
      } else if (this.isClosed()) {
         throw new SocketException("Socket is closed");
      } else if (!this.isConnected()) {
         this.D = var1;
      }
   }

   public synchronized int getReceiveBufferSize() throws SocketException {
      if (this.isClosed()) {
         throw new SocketException("Socket is closed");
      } else {
         return this.D;
      }
   }

   public void setTcpNoDelay(boolean var1) {
   }

   public boolean getTcpNoDelay() {
      return false;
   }

   public synchronized void setKeepAlive(boolean var1) throws SocketException {
      if (this.isClosed()) {
         throw new SocketException("Socket is closed");
      } else if (this.k ^ var1) {
         this.k = var1;
         if (this.isConnected()) {
            if (this.k) {
               this.H.schedule((long) (this.g.g() * 6), (long) (this.g.g() * 6));
            } else {
               this.H.cancel();
            }
         }

      }
   }

   public synchronized boolean getKeepAlive() throws SocketException {
      if (this.isClosed()) {
         throw new SocketException("Socket is closed");
      } else {
         return this.k;
      }
   }

   public void shutdownInput() throws SocketException {
      if (this.isClosed()) {
         throw new SocketException("Socket is closed");
      } else if (!this.isConnected()) {
         throw new SocketException("Socket is not connected");
      } else if (this.isInputShutdown()) {
         throw new SocketException("Socket input is already shutdown");
      } else {
         this.n = true;
         synchronized (this.x) {
            this.x.notify();
         }
      }
   }

   public void shutdownOutput() throws SocketException {
      if (this.isClosed()) {
         throw new SocketException("Socket is closed");
      } else if (!this.isConnected()) {
         throw new SocketException("Socket is not connected");
      } else if (this.isOutputShutdown()) {
         throw new SocketException("Socket output is already shutdown");
      } else {
         this.o = true;
         synchronized (this.u) {
            this.u.notifyAll();
         }
      }
   }

   public boolean isInputShutdown() {
      return this.n;
   }

   public boolean isOutputShutdown() {
      return this.o;
   }

   protected void a(byte[] var1, int var2, int var3) {
      try {
         this.a(var1, var2, var3, false);
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public void a(byte[] var1, int var2, int var3, boolean var4) throws IOException {
      if (this.isClosed()) {
         throw new SocketException("Socket is closed");
      } else if (this.isOutputShutdown()) {
         throw new IOException("Socket output is shutdown");
      } else if (!this.isConnected()) {
         throw new SocketException("Connection reset");
      } else {
         int var5 = 0;

         while (var5 < var3) {
            synchronized (this.r) {
               while (this.j) {
                  try {
                     this.r.wait();
                  } catch (InterruptedException var10) {
                     var10.printStackTrace();
                  }
               }

               int var7 = Math.min(this.g.a() - 6, var3 - var5);
               DATPacket var8 = new DATPacket(this.y.a(), this.y.b(), var1, var2 + var5, var7);
               this.e((test.rudp.packet.RUDPPacket) var8);
               if (var4) {
                  this.a((test.rudp.packet.RUDPPacket) var8);
               }

               var5 += var7;
            }
         }

      }
   }

   protected int b(byte[] var1, int var2, int var3) throws IOException {
      int var4 = 0;
      synchronized (this.x) {
         while (true) {
            while (!this.w.isEmpty()) {
               Iterator var6 = this.w.iterator();

               while (var6.hasNext()) {
                  test.rudp.packet.RUDPPacket var7 = (test.rudp.packet.RUDPPacket) var6.next();
                  if (var7 instanceof RSTPacket) {
                     var6.remove();
                     break;
                  }

                  if (var7 instanceof FINPacket) {
                     if (var4 <= 0) {
                        var6.remove();
                        return -1;
                     }
                     break;
                  }

                  if (var7 instanceof DATPacket) {
                     byte[] var8 = ((DATPacket) var7).getPayload();
                     if (var8.length + var4 > var3) {
                        if (var4 <= 0) {
                           throw new IOException("insufficient buffer space");
                        }
                        break;
                     }

                     System.arraycopy(var8, 0, var1, var2 + var4, var8.length);
                     var4 += var8.length;
                     var6.remove();
                  }
               }

               if (var4 > 0) {
                  return var4;
               }
            }

            if (this.isClosed()) {
               throw new SocketException("Socket is closed");
            }

            if (this.isInputShutdown()) {
               throw new EOFException();
            }

            if (!this.isConnected()) {
               throw new SocketException("Connection reset");
            }

            try {
               if (this.m == 0) {
                  this.x.wait();
               } else {
                  long var12 = System.currentTimeMillis();
                  this.x.wait((long) this.m);
                  if (System.currentTimeMillis() - var12 >= (long) this.m) {
                     throw new SocketTimeoutException();
                  }
               }
            } catch (InterruptedException var10) {
               if (I) {
                  var10.printStackTrace();
               }
            }
         }
      }
   }

   public void a(s var1) {
      if (var1 == null) {
         throw new NullPointerException("stateListener");
      } else {
         synchronized (this.t) {
            if (!this.t.contains(var1)) {
               this.t.add(var1);
            }

         }
      }
   }

   private void a(test.rudp.packet.RUDPPacket var1) {
      if (var1 instanceof DATPacket || var1 instanceof RSTPacket || var1 instanceof FINPacket
            || var1 instanceof NullPacket) {
         this.h(var1);
      }

      if (var1 instanceof DATPacket || var1 instanceof RSTPacket || var1 instanceof FINPacket) {
         this.E.pause();
      }

      if (I) {
         this.a("sent " + var1);
      }

      this.d(var1);
   }

   private test.rudp.packet.RUDPPacket i() {
      test.rudp.packet.RUDPPacket var1;
      if ((var1 = this.a()) != null) {
         if (I) {
            this.a("recv " + var1);
         }

         if (var1 instanceof DATPacket || var1 instanceof NullPacket || var1 instanceof RSTPacket
               || var1 instanceof FINPacket || var1 instanceof SYNPacket) {
            this.y.c();
         }

         if (this.k) {
            this.H.pause();
         }
      }

      return var1;
   }

   private void e(test.rudp.packet.RUDPPacket var1) throws SocketException {
      synchronized (this.u) {
         while (this.u.size() >= this.A || this.y.j() > this.g.b()) {
            if (this.b) {
               throw new SocketException("Socket is closed");
            }

            try {
               this.u.wait(10000L);
            } catch (InterruptedException var8) {
               var8.printStackTrace();
            }
         }

         this.y.i();
         this.u.add(var1);
      }

      if (this.b) {
         throw new SocketException("Socket is closed");
      } else {
         if (!(var1 instanceof EAKPacket) && !(var1 instanceof ACKPacket)) {
            synchronized (this.F) {
               if (this.F.isIdle()) {
                  this.F.schedule((long) this.g.h(), (long) this.g.h());
               }
            }
         }

         this.a(var1);
         if (var1 instanceof DATPacket) {
            synchronized (this.s) {
               Iterator var3 = this.s.iterator();

               while (var3.hasNext()) {
                  p var4 = (p) var3.next();
                  var4.a();
               }
            }
         }

      }
   }

   private void f(test.rudp.packet.RUDPPacket var1) {
      if (this.g.c() > 0) {
         var1.setRetransmitCount((var1.getRetransmitCount() + 1));
      }

      if (this.g.c() != 0 && var1.getRetransmitCount() > this.g.c()) {
         this.m();
      } else {
         this.a(var1);
         if (var1 instanceof DATPacket) {
            synchronized (this.s) {
               Iterator var3 = this.s.iterator();

               while (var3.hasNext()) {
                  p var4 = (p) var3.next();
                  var4.b();
               }
            }
         }

      }
   }

   private void j() {
      if (this.isConnected()) {
         this.E.cancel();
         if (this.k) {
            this.H.cancel();
         }

         synchronized (this.r) {
            this.j = false;
            this.r.notify();
         }
      } else {
         synchronized (this) {
            this.f();
            this.i = true;
            this.l = 3;
            this.notify();
         }

         synchronized (this.t) {
            Iterator var2 = this.t.iterator();

            while (var2.hasNext()) {
               s var3 = (s) var2.next();
               var3.a(this);
            }
         }
      }

      this.E.schedule(0L, (long) this.g.g());
      if (this.k) {
         this.H.schedule((long) (this.g.g() * 6), (long) (this.g.g() * 6));
      }

   }

   private void k() {
      synchronized (this.t) {
         Iterator var2 = this.t.iterator();

         while (var2.hasNext()) {
            s var3 = (s) var2.next();
            var3.b(this);
         }

      }
   }

   private void l() {
      synchronized (this.t) {
         Iterator var2 = this.t.iterator();

         while (var2.hasNext()) {
            s var3 = (s) var2.next();
            var3.c(this);
         }

      }
   }

   private void m() {
      synchronized (this.q) {
         if (this.isClosed()) {
            return;
         }

         switch (this.l) {
            case 1:
            case 3:
            case 4:
               this.i = false;
               synchronized (this.u) {
                  this.u.notifyAll();
               }

               synchronized (this.x) {
                  this.x.notify();
               }

               this.e();
               break;
            case 2:
               synchronized (this) {
                  this.notify();
               }
         }

         this.l = 0;
         this.b = true;
      }

      synchronized (this.t) {
         Iterator var2 = this.t.iterator();

         while (var2.hasNext()) {
            s var3 = (s) var2.next();
            var3.d(this);
         }

      }
   }

   private void n() {
      synchronized (this.t) {
         Iterator var2 = this.t.iterator();

         while (var2.hasNext()) {
            s var3 = (s) var2.next();
            var3.e(this);
         }

      }
   }

   protected void a(SYNPacket var1) throws SocketException {
      switch (this.l) {
         case 0:
            this.l = 1;
            this.g = new r(this.A, this.B, var1.getWindowSize(), var1.getConnectionId(), var1.getMaxOutOfSequence(),
                  var1.getMaxAutoReset(), var1.getNullSegmentTimeout(), var1.getRetransmitTimeout(),
                  var1.getMaxCumulativeAcks(), var1.getMaxOutstandingSegments(), var1.getMaxRetransmitTime());
            this.y.b(var1.getSequenceNumber());
            Random var2 = new Random(System.currentTimeMillis());
            SYNPacket var9 = new SYNPacket(this.y.a(var2.nextInt(255)), this.g.b(), this.g.a(), this.g.h(), this.g.i(),
                  this.g.g(), this.g.c(), this.g.d(), this.g.e(), this.g.f());
            var9.setAckNumber(var1.getSequenceNumber());
            this.e((test.rudp.packet.RUDPPacket) var9);
            break;
         case 1:
            synchronized (this.u) {
               Iterator var3 = this.u.iterator();

               while (var3.hasNext()) {
                  test.rudp.packet.RUDPPacket var4 = (test.rudp.packet.RUDPPacket) var3.next();

                  this.f(var4);
               }

               return;
            }
         case 2:
            this.y.b(var1.getSequenceNumber());
            this.l = 3;
            this.o();
            this.j();
      }

   }

   private void a(EAKPacket var1) {
      int[] var3 = var1.getAdditionalAcks();
      int var4 = var1.getAckNumber();
      int var5 = var3[var3.length - 1];
      synchronized (this.u) {
         Iterator var2 = this.u.iterator();

         while (true) {
            test.rudp.packet.RUDPPacket var7;
            while (var2.hasNext()) {
               var7 = (test.rudp.packet.RUDPPacket) var2.next();
               if (this.a(var7.getSequenceNumber(), var4) <= 0) {
                  var2.remove();
               } else {
                  for (int var8 = 0; var8 < var3.length; ++var8) {
                     if (this.a(var7.getSequenceNumber(), var3[var8]) == 0) {
                        var2.remove();
                        break;
                     }
                  }
               }
            }

            var2 = this.u.iterator();

            while (var2.hasNext()) {
               var7 = (test.rudp.packet.RUDPPacket) var2.next();
               if (this.a(var4, var7.getSequenceNumber()) < 0 && this.a(var5, var7.getSequenceNumber()) > 0) {
                  this.f(var7);
               }
            }

            this.u.notifyAll();
            return;
         }
      }
   }

   private void g(test.rudp.packet.RUDPPacket var1) {
      if (var1 instanceof RSTPacket) {
         synchronized (this.r) {
            this.j = true;
         }

         this.n();
      }

      if (var1 instanceof FINPacket) {
         switch (this.l) {
            case 0:
               break;
            case 2:
               synchronized (this) {
                  this.notify();
                  break;
               }
            default:
               this.l = 4;
         }
      }

      boolean var2 = false;
      synchronized (this.x) {
         if (this.a(var1.getSequenceNumber(), this.y.b()) > 0) {
            if (this.a(var1.getSequenceNumber(), b(this.y.b())) == 0) {
               var2 = true;
               if (this.w.size() == 0 || this.w.size() + this.v.size() < this.B) {
                  this.y.b(var1.getSequenceNumber());
                  if (var1 instanceof DATPacket || var1 instanceof RSTPacket || var1 instanceof FINPacket) {
                     this.w.add(var1);
                  }

                  if (var1 instanceof DATPacket) {
                     synchronized (this.s) {
                        Iterator var5 = this.s.iterator();

                        while (var5.hasNext()) {
                           p var6 = (p) var5.next();
                           var6.c();
                        }
                     }
                  }

                  this.r();
               }
            } else if (this.w.size() + this.v.size() < this.B) {
               boolean var4 = false;

               for (int var17 = 0; var17 < this.v.size() && !var4; ++var17) {
                  test.rudp.packet.RUDPPacket var18 = (test.rudp.packet.RUDPPacket) this.v.get(var17);
                  int var7 = this.a(var1.getSequenceNumber(), var18.getSequenceNumber());
                  if (var7 == 0) {
                     var4 = true;
                  } else if (var7 < 0) {
                     this.v.add(var17, var1);
                     var4 = true;
                  }
               }

               if (!var4) {
                  this.v.add(var1);
               }

               this.y.f();
               if (var1 instanceof DATPacket) {
                  synchronized (this.s) {
                     Iterator var19 = this.s.iterator();

                     while (var19.hasNext()) {
                        p var20 = (p) var19.next();
                        var20.d();
                     }
                  }
               }
            }
         }

         if (var2 && (var1 instanceof RSTPacket || var1 instanceof NullPacket || var1 instanceof FINPacket)) {
            this.o();
         } else if (this.y.g() <= 0 || this.g.e() != 0 && this.y.g() <= this.g.e()) {
            if (this.y.d() > 0 && (this.g.d() == 0 || this.y.d() > this.g.d())) {
               this.q();
            } else {
               synchronized (this.G) {
                  if (this.G.isIdle()) {
                     this.G.schedule((long) this.g.i());
                  }
               }
            }
         } else {
            this.p();
         }

      }
   }

   private void o() {
      synchronized (this.x) {
         if (!this.v.isEmpty()) {
            this.p();
         } else {
            this.q();
         }
      }
   }

   private void p() {
      synchronized (this.x) {
         if (!this.v.isEmpty()) {
            this.y.e();
            this.y.h();
            int[] var2 = new int[this.v.size()];

            int var3;
            for (var3 = 0; var3 < var2.length; ++var3) {
               test.rudp.packet.RUDPPacket var4 = (test.rudp.packet.RUDPPacket) this.v.get(var3);
               var2[var3] = var4.getSequenceNumber();
            }

            var3 = this.y.b();
            this.a((test.rudp.packet.RUDPPacket) (new EAKPacket(b(var3), var3, var2)));
         }
      }
   }

   private void q() {
      if (this.y.e() != 0) {
         int var1 = this.y.b();
         this.a((test.rudp.packet.RUDPPacket) (new ACKPacket(b(var1), var1)));
      }
   }

   private void h(test.rudp.packet.RUDPPacket var1) {
      if (this.y.e() != 0) {
         var1.setAckNumber(this.y.b());
      }
   }

   protected boolean b(test.rudp.packet.RUDPPacket var1) {
      int var2 = var1.getAckNumber();
      if (var2 < 0) {
         return false;
      } else {
         Iterator var3 = this.u.iterator();

         test.rudp.packet.RUDPPacket var4;
         do {
            if (!var3.hasNext()) {
               return false;
            }

            var4 = (test.rudp.packet.RUDPPacket) var3.next();
         } while (this.a(var4.getSequenceNumber(), var2) > 0);

         return true;
      }
   }

   protected void c(test.rudp.packet.RUDPPacket var1) {
      int var2 = var1.getAckNumber();
      if (var2 >= 0) {
         this.y.k();
         synchronized (this.u) {
            Iterator var4 = this.u.iterator();

            while (var4.hasNext()) {
               test.rudp.packet.RUDPPacket var5 = (test.rudp.packet.RUDPPacket) var4.next();
               if (this.a(var5.getSequenceNumber(), var2) <= 0) {
                  var4.remove();
               }
            }

            if (this.l == 1) {
               boolean var9 = false;
               if (!this.u.isEmpty()) {
                  Iterator var10 = this.u.iterator();

                  while (var10.hasNext()) {
                     test.rudp.packet.RUDPPacket var6 = (test.rudp.packet.RUDPPacket) var10.next();
                     if (var6 instanceof SYNPacket) {
                        var9 = true;
                     }
                  }
               }

               if (var9) {
                  this.a("Bad first ack: " + var2);
                  return;
               }

               this.l = 3;
               this.j();
            }

            if (this.u.isEmpty()) {
               this.F.cancel();
            }

            this.u.notifyAll();
         }
      }
   }

   private void r() {
      synchronized (this.x) {
         Iterator var2 = this.v.iterator();

         while (true) {
            test.rudp.packet.RUDPPacket var3;
            do {
               if (!var2.hasNext()) {
                  this.x.notify();
                  return;
               }

               var3 = (test.rudp.packet.RUDPPacket) var2.next();
            } while (this.a(var3.getSequenceNumber(), b(this.y.b())) != 0);

            this.y.b(var3.getSequenceNumber());
            if (var3 instanceof DATPacket || var3 instanceof RSTPacket || var3 instanceof FINPacket) {
               this.w.add(var3);
            }

            var2.remove();
         }
      }
   }

   protected void d(test.rudp.packet.RUDPPacket var1) {
      try {
         DatagramPacket var2 = new DatagramPacket(var1.toBytes(), var1.getLength(), this.d);
         this.c.send(var2);
      } catch (IOException var3) {
         if (!this.isClosed()) {
            var3.printStackTrace();
         }
      }

   }

   protected test.rudp.packet.RUDPPacket a() {
      try {
         if (this.a_f == null) {
            this.a_f = new byte['\uffff'];
         }

         DatagramPacket var1 = new DatagramPacket(this.a_f, this.a_f.length);
         this.c.receive(var1);
         return test.rudp.packet.RUDPPacket.parse(var1.getData(), 0, var1.getLength());
      } catch (IOException var2) {
         if (!this.isClosed()) {
            var2.printStackTrace();
         }

         return null;
      }
   }

   protected void b() {
      this.c.close();
   }

   protected void e() {
      this.E.cancel();
      this.H.cancel();
      this.l = 4;
      h$1 var1 = new h$1(this);
      var1.setName("ReliableSocket-Closing");
      var1.setDaemon(true);
      var1.start();
   }

   protected synchronized void a(String var1) {
      System.out.println(this.getLocalPort() + ": " + var1);
   }

   private static int b(int var0) {
      return (var0 + 1) % 255;
   }

   private int a(int var1, int var2) {
      if (var1 == var2) {
         return 0;
      } else {
         return (var1 >= var2 || var2 - var1 <= 127) && (var1 <= var2 || var1 - var2 >= 127) ? -1 : 1;
      }
   }

   public synchronized void f() {
      if (!this.h) {
         this.h = true;
         this.E.start();
         this.F.start();
         this.G.start();
         this.H.start();
      }

   }

   public synchronized void g() {
      if (this.h) {
         this.h = false;
         this.F.stop();
         this.G.stop();
         this.H.stop();
         this.E.stop();
      }

   }

   // $FF: synthetic method
   static test.rudp.packet.TaskScheduler a(ReliableSocket var0) {
      return var0.H;
   }

   // $FF: synthetic method
   static test.rudp.packet.TaskScheduler b(ReliableSocket var0) {
      return var0.E;
   }

   // $FF: synthetic method
   static test.rudp.packet.TaskScheduler c(ReliableSocket var0) {
      return var0.F;
   }

   // $FF: synthetic method
   static test.rudp.packet.TaskScheduler d(ReliableSocket var0) {
      return var0.G;
   }

   // $FF: synthetic method
   static void e(ReliableSocket var0) {
      var0.l();
   }

   // $FF: synthetic method
   static int a(int var0) {
      return b(var0);
   }

   // $FF: synthetic method
   static test.rudp.packet.RUDPPacket f(ReliableSocket var0) {
      return var0.i();
   }

   // $FF: synthetic method
   static void a(ReliableSocket var0, EAKPacket var1) {
      var0.a(var1);
   }

   // $FF: synthetic method
   static void a(ReliableSocket var0, test.rudp.packet.RUDPPacket var1) {
      var0.g(var1);
   }

   // $FF: synthetic method
   static ArrayList g(ReliableSocket var0) {
      return var0.u;
   }

   // $FF: synthetic method
   static i h(ReliableSocket var0) {
      return var0.y;
   }

   // $FF: synthetic method
   static void b(ReliableSocket var0, test.rudp.packet.RUDPPacket var1) {
      try {
         var0.e(var1);
      } catch (SocketException e) {
         e.printStackTrace();
      }
   }

   // $FF: synthetic method
   static boolean h() {
      return I;
   }

   // $FF: synthetic method
   static void c(ReliableSocket var0, test.rudp.packet.RUDPPacket var1) {
      var0.f(var1);
   }

   // $FF: synthetic method
   static void i(ReliableSocket var0) {
      var0.o();
   }

   // $FF: synthetic method
   static void j(ReliableSocket var0) {
      var0.m();
   }
}
