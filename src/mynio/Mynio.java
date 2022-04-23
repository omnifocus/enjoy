package mynio;

import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Mynio {

    public static void main(String[] args) throws  Exception {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        System.out.println(buffer);

        byte[] bs = new byte[10];
        buffer.get(bs);

        buffer.put(bs);

        Selector selector = Selector.open();
        Set<SelectionKey> keys = selector.selectedKeys();
        for (SelectionKey key : keys) {
            key.cancel();
        }
        Iterator<SelectionKey> iterator = keys.iterator();
        iterator.remove();
        SocketChannel sc = null;
        sc.register(selector,SelectionKey.OP_ACCEPT);
    }
}
