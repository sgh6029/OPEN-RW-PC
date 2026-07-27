package test.rudp.packet;

import java.io.IOException;

public abstract class RUDPPacket {
    private int flags;
    private int length;
    private int sequenceNumber;
    private int ackNumber = -1;
    private int retransmitCount = 0;

    protected RUDPPacket() {
    }

    public abstract String getType();

    // m
    public int getSequenceNumber() {
        return sequenceNumber;
    }

    // b
    public int getLength() {
        return length;
    }

    // a
    public void setAckNumber(int ackNumber) {
        flags |= 0x40;
        this.ackNumber = ackNumber;
    }

    // n
    public int getAckNumber() {
        if ((flags & 0x40) == 64) {
            return ackNumber;
        }
        return -1;
    }

    // o
    public int getRetransmitCount() {
        return retransmitCount;
    }

    // b
    public void setRetransmitCount(int retransmitCount) {
        this.retransmitCount = retransmitCount;
    }

    // d
    public byte[] toBytes() {
        byte[] data = new byte[getLength()];
        data[0] = (byte) (flags & 0xFF);
        data[1] = (byte) (length & 0xFF);
        data[2] = (byte) (sequenceNumber & 0xFF);
        data[3] = (byte) (ackNumber & 0xFF);
        return data;
    }

    @Override
    public String toString() {
        return getType() + " [ SEQ = " + getSequenceNumber() +
                ", ACK = " + (getAckNumber() >= 0 ? String.valueOf(getAckNumber()) : "N/A") +
                ", LEN = " + getLength() + " ]";
    }

    public static RUDPPacket parse(byte[] data, int offset, int length) throws IOException {
        RUDPPacket packet = null;
        if (length < 6) {
            throw new IOException("Invalid segment:" + length);
        }
        byte flags = data[offset];
        if ((flags & 0x80) != 0) {
            packet = new SYNPacket();
        } else if ((flags & 8) != 0) {
            packet = new NullPacket();
        } else if ((flags & 0x20) != 0) {
            packet = new EAKPacket();
        } else if ((flags & 0x10) != 0) {
            packet = new RSTPacket();
        } else if ((flags & 2) != 0) {
            packet = new FINPacket();
        } else if ((flags & 0x40) != 0) {
            packet = (length == 6) ? new ACKPacket() : new DATPacket();
        }
        if (packet == null) {
            throw new IOException("Invalid segment");
        }
        packet.parseData(data, offset, length);
        return packet;
    }

    protected void init(int flags, int sequenceNumber, int length) {
        this.flags = flags;
        this.sequenceNumber = sequenceNumber;
        this.length = length;
    }

    protected void parseData(byte[] data, int offset, int length) throws IOException {
        flags = data[offset] & 0xFF;
        this.length = data[offset + 1] & 0xFF;
        sequenceNumber = data[offset + 2] & 0xFF;
        ackNumber = data[offset + 3] & 0xFF;
    }
}