package ru.itis301.labs;

public abstract class Stage {

    private Status status;
    public Stage() {
        double randomIntForStatus = Math.random();
        if (randomIntForStatus < 0.80) {
            status = Status.PLANNED;
        } else {
            status = Status.REJECTED;
        }
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
