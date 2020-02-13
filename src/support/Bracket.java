package support;

public class Bracket {
    private String input;

    public Bracket(String input) {
        this.input = input;
    }

    public void check() {
        Stack<Character> stack = new Stack<>(input.length());
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            switch (ch) {
                case '(':
                case '{':
                case '[':
                    stack.push(ch);
                    break;
                case ')':
                case '}':
                case ']':
                    if (!stack.isEmpty()) {
                        char chr = stack.pop();
                        if ((ch == ')' && chr != '(') || (ch == '}' && chr != '{') || (ch == ']' && chr != '[')) {
                            System.out.printf("wrong bracket %d %c %n", i, ch);
                        }
                    } else {
                        System.out.printf("error missing open bracket %d %n", i);
                    }
                    break;
                default:
                    break;
            }
        }
        if (!stack.isEmpty()) {
            System.out.printf("missing right bracket%n");
        }

    }
}
