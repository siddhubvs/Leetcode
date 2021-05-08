 public int calculate(String s) {
    Stack<String> stack = new Stack<>();
    String num = "";
    s = "(" + s + ")";
    for (char c : s.toCharArray()) {
      switch (c) {
        case ' ':
        case '(':
        case '+':
        case '-':
          if (!num.equals("")) {
            stack.push(String.valueOf(num));
            num = "";
          }
          if (c != ' ') { 
            stack.push(String.valueOf(c));
          }
          break;
        case ')':
          if (!num.equals("")) {
            stack.push(String.valueOf(num));
            num = "";
          }
          int sum = 0;
          int prev = 0; 
          while (!stack.isEmpty()) {
            String top = stack.pop();
            if (top.equals("-")) {
              sum -= (prev * 2);
              prev = 0;
            } else if (top.equals("+")) {
              
            } else if (top.equals("(")) {
              stack.push(String.valueOf(sum));
              break;
            } else {
              sum += Integer.parseInt(top);
              prev = Integer.parseInt(top);
            }
          }
          break;
        default:
          num += String.valueOf(c);
          break;
      }
    }
    return Integer.parseInt(stack.peek());
  }
}
