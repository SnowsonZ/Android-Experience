package utils;

import bean.LinkNode;

/**
 * @author Snowson Zhang
 * @
 */
public class LinkNodeUtils {

    public static LinkNode deleteNode(LinkNode head, int nodeIndex) {
        LinkNode node = head.getNext(); //不包括头节点
        for(int i = 0; ; i++) {
            if(i == nodeIndex - 1) {
                break;
            }
            node = node.getNext();
        }
        if (node.getNext() == null) {
            LinkNode temp = head;
            while (temp.getNext() != node) {
                temp = temp.getNext();
            }
            temp.setNext(null);
        } else if (node == head) {
            LinkNode temp = head;
            head = head.getNext();
            temp.setNext(null);
        } else {
            LinkNode temp = head;
            while (temp.getNext() != node) {
                temp = temp.getNext();
            }
            temp.setNext(node.getNext());
            node.setNext(null);
        }
        return head;
    }

    public static LinkNode deleteLastIndexNode(LinkNode head, int lastIndex) {
        if(head == null || lastIndex < 0) {
            return head;
        }
        LinkNode p = head; //包括头节点
        for (int i = 0; i < lastIndex; i++) {
            if(p.getNext() != null) {
                p = p.getNext();
            }else {
                return head;
            }
        }
        LinkNode q = head;
        while(p.getNext() != null) {
            p = p.getNext();
            q = q.getNext();
        }
        q.setNext(q.getNext().getNext());

        return head;
    }

    public static void display(LinkNode head) {
        LinkNode tempNode = head;
        while (tempNode.getNext() != null) {
            tempNode = tempNode.getNext();
            System.out.print(tempNode.getData() + ", ");
        }
        System.out.println();
    }

}
