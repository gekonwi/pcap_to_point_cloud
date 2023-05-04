package konwisser;

import io.pkts.Pcap;

import java.io.IOException;

import static java.util.Objects.requireNonNull;

public class Main {
    public static void main(String[] args) throws IOException {
        String SAMPLE_FILE = requireNonNull(Main.class.getClassLoader().getResource("fuzz" +
                "-2007-03-14-24230.pcap")).getFile();
        Pcap pcap = Pcap.openStream(SAMPLE_FILE);
        pcap.loop(new TcpUdpPacketHandler());
        pcap.close();
    }

}