class TextStateNode {
    String content;
    TextStateNode prev, next;

    public TextStateNode(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}

public class Texteditor {
    private TextStateNode head, current;
    private int size = 0;
    private final int MAX_HISTORY = 10;

    // Add a new text state
    public void addState(String newText) {
        TextStateNode newNode = new TextStateNode(newText);

        // If current is not the latest (redo chain exists), truncate redo history
        if (current != null && current.next != null) {
            current.next.prev = null;
            current.next = null;
        }

        if (current == null) {
            head = newNode;
        } else {
            current.next = newNode;
            newNode.prev = current;
        }

        current = newNode;
        size++;

        // Trim head if history exceeds MAX_HISTORY
        while (size > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    // Undo operation
    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo performed.");
        } else {
            System.out.println("No more undo steps available.");
        }
    }

    // Redo operation
    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo performed.");
        } else {
            System.out.println("No more redo steps available.");
        }
    }
    public void showCurrentState() {
        if (current != null) {
            System.out.println("Current Text: \"" + current.content + "\"");
        } else {
            System.out.println("Text is empty.");
        }
    }

    public void printHistory() {
        TextStateNode temp = head;
        System.out.print("Text History: ");
        while (temp != null) {
            System.out.print("[" + temp.content + "] ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Texteditor editor = new Texteditor();

        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");
        editor.addState("Hello World! This is a test.");

        editor.showCurrentState(); 
        editor.undo();
        editor.showCurrentState(); 

        editor.undo();
        editor.showCurrentState(); 
        editor.redo();
        editor.showCurrentState(); 

        editor.addState("New branch after undo"); 
        editor.showCurrentState();

        editor.printHistory(); 
    }
}
