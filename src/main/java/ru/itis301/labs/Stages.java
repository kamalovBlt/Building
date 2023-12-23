package ru.itis301.labs;

public class Stages implements Stageable {

    private final Node head;
    private Node currentStage;
    public Stages() {

        head = new Node(new Project());
        head.next = new Node(new Foundation());
        Node current = head.next;

        current.next = new Node(new Walls());
        current = current.next;

        current.next = new Node(new Roof());
        current = current.next;

        current.next = new Node(new Finishing());

        currentStage = head;

    }

    @Override
    public Stage next() {
        if (currentStage.next != null) {
            currentStage.stage.setStatus(Status.COMPLETED);
            Stage returnElement = currentStage.next.stage;
            currentStage = currentStage.next;
            currentStage.stage.setStatus(Status.MAKING);
            return returnElement;
        }
        return null;
    }

    @Override
    public Stage prev() {
        if (currentStage.prev != null) {
            currentStage.stage.setStatus(Status.PLANNED);
            Stage returnElement = currentStage.prev.stage;
            currentStage = currentStage.prev;
            currentStage.stage.setStatus(Status.MAKING);
            return returnElement;
        }
        return null;
    }
    public Stage getCurrentStage() {
        return currentStage.stage;
    }

    public Stage getHead() {
        return head.stage;
    }
    public boolean isEnd() {
        return currentStage.next == null;
    }

    public Stage nextToCheck() throws StageRejectedException {
        return currentStage.next.stage;
    }
    public void setCurrentStage() {
        currentStage.stage.setStatus(Status.PLANNED);
    }
}
