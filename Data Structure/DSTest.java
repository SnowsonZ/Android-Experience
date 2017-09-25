import bean.LinkNode;
import bean.TreeNode;
import utils.LinkNodeUtils;
import utils.StackUtils;
import utils.TreeUtils;

/**
 * Created by xuelian on 2017/9/23.
 */
public class DSTest {
    public static void main(String[] args) {
        //头节点
        LinkNode head = new LinkNode();
        LinkNode temp = head;
        //初始化链表
        for (int i = 0; i < 20; i++) {
            LinkNode node = new LinkNode();
            node.setData("" + i);
            temp.setNext(node);
            temp = temp.getNext();
        }
        //目标node下标
        int targetIndex = 10;
        System.out.println("------------链表---------------");
        LinkNodeUtils.display(head);
//        LinkNodeUtils.deleteNode(head, targetIndex);
        LinkNodeUtils.deleteLastIndexNode(head, 7);
        LinkNodeUtils.display(head);

        System.out.println("------------栈---------------");
        StackUtils.add(2, 5, 9, 10, 32, 21);

        StackUtils.poll();

        System.out.println("------------二叉树---------------");
        TreeNode root = new TreeNode();
        root.setData("A");
        TreeNode node1 = new TreeNode();
        node1.setData("C");
        TreeNode node2 = new TreeNode();
        node2.setData("B");
        TreeNode node3 = new TreeNode();
        node3.setData("D");
        TreeNode node4 = new TreeNode();
        node4.setData("E");
        TreeNode node5 = new TreeNode();
        node5.setData("F");
        TreeNode node6 = new TreeNode();
        node6.setData("G");
        root.setLeft(node1);
        root.setRight(node3);
        node1.setRight(node2);
        node2.setLeft(node4);
        node3.setRight(node5);
        node5.setLeft(node6);
        System.out.println("------------深度非递归---------------");
        TreeUtils.levelDepth(root);
        System.out.println();
        System.out.println("------------深度递归---------------");
        TreeUtils.levelDepthRecursion(root);
        System.out.println();
        System.out.println("------------广度---------------");
        TreeUtils.levelTraversal(root);
        System.out.println();
        System.out.println("------------最大深度非递归---------------");
        System.out.println(TreeUtils.maxDepth(root));
        System.out.println();
        System.out.println("------------最大深度递归---------------");
        System.out.println(TreeUtils.maxDepthRecursion(root));
        System.out.println();
    }
}
