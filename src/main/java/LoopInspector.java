import java.util.ArrayList;
import java.util.List;

public class LoopInspector {
    public int loopSize(Node node) {
        List<Node> nodeList = new ArrayList<>();
        nodeList.add(node);
        Node next = node.getNext();
        while(!node.equals(next)) {
            if (nodeList.contains(next)) break;
            nodeList.add(next);
            next = next.getNext();
        }
        return nodeList.subList(nodeList.indexOf(next), nodeList.size()).size();
    }

    static class Node {
        Node getNext() {
            return new Node();
        }
    }
}