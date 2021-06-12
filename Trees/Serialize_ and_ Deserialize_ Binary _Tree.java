import java.util.StringTokenizer;
public class Codec {
   public String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    serialize(root, sb);
    return sb.toString();
}

private void serialize(TreeNode root, StringBuilder sb) {
    if (root == null)
        sb.append("# ");
    else {
        sb.append(root.val + " ");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }
}
public TreeNode deserialize(String data) {
    if (data == null || data.length() == 0) return null;
    StringTokenizer st = new StringTokenizer(data, " ");
    return deserialize(st);
}

private TreeNode deserialize(StringTokenizer st) {
    if (!st.hasMoreTokens())
        return null;
    String s = st.nextToken();
    if (s.equals("#"))
        return null;
    TreeNode root = new TreeNode(Integer.valueOf(s));
    root.left = deserialize(st);
    root.right = deserialize(st);
    
    return root;
}
}
