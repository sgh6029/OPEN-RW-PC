package test.rudp.packet;

import java.io.IOException;

public class SYNPacket extends RUDPPacket {
    private int version;
    private int connectionId;
    private int segmentSize;
    private int windowSize;
    private int maxOutstandingSegments;
    private int maxRetransmitTime;
    private int maxCumulativeAcks;
    private int maxOutOfSequence;
    private int maxAutoReset;
    private int nullSegmentTimeout;
    private int retransmitTimeout;

    public SYNPacket() {
    }

    public SYNPacket(int sequenceNumber, int connectionId, int windowSize,
                     int maxOutstandingSegments, int maxRetransmitTime, int maxCumulativeAcks,
                     int maxOutOfSequence, int maxAutoReset, int nullSegmentTimeout, int retransmitTimeout) {
        init(0x80, sequenceNumber, 22);
        version = 1;
        this.connectionId = connectionId;
        this.segmentSize = 1;//我怎么知道为什么
        this.windowSize = windowSize;
        this.maxOutstandingSegments = maxOutstandingSegments;
        this.maxRetransmitTime = maxRetransmitTime;
        this.maxCumulativeAcks = maxCumulativeAcks;
        this.maxOutOfSequence = maxOutOfSequence;
        this.maxAutoReset = maxAutoReset;
        this.nullSegmentTimeout = nullSegmentTimeout;
        this.retransmitTimeout = retransmitTimeout;
    }

    @Override
    public String getType() {
        return "SYN";
    }

    public int getConnectionId() {
        return connectionId;
    }

    public int getSegmentSize() {
        return segmentSize;
    }

    public int getWindowSize() {
        return windowSize;
    }

    public int getMaxOutstandingSegments() {
        return maxOutstandingSegments;
    }

    public int getMaxRetransmitTime() {
        return maxRetransmitTime;
    }

    public int getMaxCumulativeAcks() {
        return maxCumulativeAcks;
    }

    public int getMaxOutOfSequence() {
        return maxOutOfSequence;
    }

    public int getMaxAutoReset() {
        return maxAutoReset;
    }

    public int getNullSegmentTimeout() {
        return nullSegmentTimeout;
    }

    public int getRetransmitTimeout() {
        return retransmitTimeout;
    }

    @Override
    public byte[] toBytes() {
        byte[] base = super.toBytes();
        base[4] = (byte) ((version << 4) & 0xFF);
        base[5] = (byte) (connectionId & 0xFF);
        base[6] = (byte) (segmentSize & 0xFF);
        base[7] = 0;
        base[8] = (byte) ((windowSize >>> 8) & 0xFF);
        base[9] = (byte) ((windowSize >>> 0) & 0xFF);
        base[10] = (byte) ((maxOutstandingSegments >>> 8) & 0xFF);
        base[11] = (byte) ((maxOutstandingSegments >>> 0) & 0xFF);
        base[12] = (byte) ((maxRetransmitTime >>> 8) & 0xFF);
        base[13] = (byte) ((maxRetransmitTime >>> 0) & 0xFF);
        base[14] = (byte) ((maxCumulativeAcks >>> 8) & 0xFF);
        base[15] = (byte) ((maxCumulativeAcks >>> 0) & 0xFF);
        base[16] = (byte) (maxOutOfSequence & 0xFF);
        base[17] = (byte) (maxAutoReset & 0xFF);
        base[18] = (byte) (nullSegmentTimeout & 0xFF);
        base[19] = (byte) (retransmitTimeout & 0xFF);
        return base;
    }

    @Override
    protected void parseData(byte[] data, int offset, int length) throws IOException {
        super.parseData(data, offset, length);
        if (length < 22) {
            throw new IOException("Invalid SYN segment");
        }
        version = (data[offset + 4] & 0xFF) >>> 4;
        if (version != 1) {
            throw new IOException("Invalid RUDP version:" + version);
        }
        connectionId = data[offset + 5] & 0xFF;
        segmentSize = data[offset + 6] & 0xFF;
        windowSize = (data[offset + 8] & 0xFF) << 8 | (data[offset + 9] & 0xFF) << 0;
        maxOutstandingSegments = (data[offset + 10] & 0xFF) << 8 | (data[offset + 11] & 0xFF) << 0;
        maxRetransmitTime = (data[offset + 12] & 0xFF) << 8 | (data[offset + 13] & 0xFF) << 0;
        maxCumulativeAcks = (data[offset + 14] & 0xFF) << 8 | (data[offset + 15] & 0xFF) << 0;
        maxOutOfSequence = data[offset + 16] & 0xFF;
        maxAutoReset = data[offset + 17] & 0xFF;
        nullSegmentTimeout = data[offset + 18] & 0xFF;
        retransmitTimeout = data[offset + 19] & 0xFF;
    }
}