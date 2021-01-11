public class App {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        // root.setLeft(new TreeNode(2));
        // root.setRight(new TreeNode(2));

        // TreeNode left = root.getLeft();
        // left.setLeft(new TreeNode(3));
        // left.setRight(new TreeNode(3));

        // TreeNode _left = left.getLeft();
        // _left.setLeft(new TreeNode(4));
        // _left.setRight(new TreeNode(4));

        root.setLeft(new TreeNode(9));
        root.setRight(new TreeNode(3));

        TreeNode _left = root.getRight();
        _left.setLeft(new TreeNode(5));
        _left.setRight(new TreeNode(7));

        
        System.out.println(check(root)[0]);
    }

    public static Object[] check(TreeNode node){

        if(node == null) return new Object[]{new Boolean(Boolean.TRUE), new Integer(0)};

        Object[] resL = check(node.getLeft());
        Object[] resR = check(node.getRight());

        if(resL[0] == Boolean.FALSE || resR[0] == Boolean.FALSE) return new Object[]{Boolean.FALSE};
        if(Math.abs(((Integer)resL[1]) - ((Integer)resR[1])) > 1) return new Object[]{Boolean.FALSE};

        return new Object[]{Boolean.TRUE, 1+Math.max((Integer)resL[1], (Integer)resR[1])};
    }
}
